package com.example.eduadministration.Service;

import com.example.eduadministration.DAO.CourseStudentRepository;
import com.example.eduadministration.DAO.StudentGrade;
import com.example.eduadministration.Mapper.CourseStudent;
import com.example.eduadministration.request.OriginGrade;
import com.example.eduadministration.request.QueryGradeRequest;
import com.example.eduadministration.response.GradeAnalyse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class GradeSqlServiceImpl implements BaseSqlService{

    private final CourseStudentRepository repository;

    @Autowired
    public GradeSqlServiceImpl(CourseStudentRepository repository) {

        this.repository = repository;
    }

    @Override
    public void addRecord(Object object) {

        repository.save(calculateFinalGrade((OriginGrade) object));
    }

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

    public List<StudentGrade> queryGrade(QueryGradeRequest request) {

        String studentId = request.getStudentId();
        String schoolYear = request.getSchoolYear();
        String schoolTerm = request.getSchoolTerm();
        List<StudentGrade> gradeList = repository.fetchAllCourseByStudentId(studentId);
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

    public GradeAnalyse analyzeGrade(String studentId) {

        List<StudentGrade> gradeList = repository.fetchAllCourseByStudentId(studentId);
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
}
