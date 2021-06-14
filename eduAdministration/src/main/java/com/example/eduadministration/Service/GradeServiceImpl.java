package com.example.eduadministration.Service;

import com.example.eduadministration.DAO.CourseStudentRepository;
import com.example.eduadministration.DAO.StudentRepository;
import com.example.eduadministration.response.StudentGrade;
import com.example.eduadministration.Mapper.CourseStudent;
import com.example.eduadministration.request.OriginGrade;
import com.example.eduadministration.request.QueryGradeRequest;
import com.example.eduadministration.response.GradeAnalyse;
import com.example.eduadministration.response.GradeStatistics;
import com.example.eduadministration.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class GradeServiceImpl implements BaseService {

    private final CourseStudentRepository courseStudentRepository;

    private final StudentRepository studentRepository;

    @Autowired
    public GradeServiceImpl(CourseStudentRepository repository, StudentRepository studentRepository) {

        this.courseStudentRepository = repository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void addRecord(Object object) {

        courseStudentRepository.save(calculateFinalGrade((OriginGrade) object));
    }

    /**
     * @param originGrade 平时分、卷面分和占比
     * @return 最终成绩
     */
    CourseStudent calculateFinalGrade(OriginGrade originGrade) {

        CourseStudent grade = new CourseStudent();
        grade.setCourseId(Integer.parseInt(originGrade.getCourseId()));
        grade.setStudentId(originGrade.getStudentId());
        double finalGrade = Double.parseDouble(originGrade.getUsualGradePercentage()) * Double.parseDouble(originGrade.getUsualGrade()) +
                (1- Double.parseDouble(originGrade.getUsualGradePercentage())) * Double.parseDouble(originGrade.getExamGrade());
        BigDecimal finalGradeRound = new BigDecimal(finalGrade).setScale(2, RoundingMode.UP);
        grade.setScore(finalGradeRound.doubleValue());
        return grade;
    }

    /**
     * 查成绩单
     */
    public List<StudentGrade> queryGrade(QueryGradeRequest request) {

        String studentId = request.getStudentId();
        String schoolYear = request.getSchoolYear();
        String schoolTerm = request.getSchoolTerm();
        List<StudentGrade> gradeList = courseStudentRepository.fetchAllCourseByStudentId(studentId);
        List<StudentGrade> response = new ArrayList<>();
        if ("".equals(schoolYear)) {
            response = gradeList;
        } else if ("".equals(schoolTerm)) {
            for(StudentGrade g : gradeList) {
                if(schoolYear.equals(g.getSchoolYear())) {
                    response.add(g);
                }
            }
        } else {
            for(StudentGrade g : gradeList) {
                if(schoolYear.equals(g.getSchoolYear()) && schoolTerm.equals(g.getSchoolTerm())) {
                    response.add(g);
                }
            }
        }
        return response;
    }

    /**
     * @param studentId 学号
     * @return 成绩分析
     */
    public GradeAnalyse analyzeGrade(String studentId) {

        List<StudentGrade> gradeList = courseStudentRepository.fetchAllCourseByStudentId(studentId);
        int totalCredits = 0, lostCredits = 0;
        double gradePoint = 0, gradePointAverage = 0;
        for (StudentGrade grade: gradeList) {

            totalCredits += grade.getCredit();
            if (grade.getScore() < 60) {
                // 不满60分的绩点算1
                gradePoint += grade.getCredit();
                lostCredits += grade.getCredit();
            } else {
                gradePoint += (grade.getScore()-50)/10 * grade.getCredit();
            }
        }
        if (totalCredits != 0) {
            gradePointAverage = gradePoint / totalCredits;
        }
        return new GradeAnalyse(totalCredits, gradePoint, gradePointAverage, lostCredits);
    }

    /**
     * @param courseId 课程号
     * @return 这门课学生的全班成绩统计数据
     */
    public GradeStatistics countGrade(int courseId) {
        List<StudentResponse> studentResponseList = studentRepository.fetchAllStudentGradeByCourseId(courseId);

        int totalStudent = studentResponseList.size();
        if (totalStudent == 0) {
            // 如果总人数为0
            return GradeStatistics.builder().build();
        }
        int passedStudent = 0, excellentStudent = 0;
        double sumScore = 0, highestScore = -1;
        for(StudentResponse student: studentResponseList) {
            double score = student.getScore();
            sumScore += score;
            passedStudent += score >= 60 ? 1 : 0;
            excellentStudent += score >= 80 ? 1 : 0;
            highestScore = Math.max(score, highestScore);
        }
        return GradeStatistics.builder()
                .studentNum(totalStudent)
                .averageScore(sumScore / totalStudent)
                .passedRate((double) passedStudent / totalStudent)
                .highestScore(highestScore)
                .excellentRate((double) excellentStudent / totalStudent)
                .build();
    }
}
