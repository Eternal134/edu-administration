package com.example.eduadministration.Service;

import com.example.eduadministration.DAO.CourseStudentRepository;
import com.example.eduadministration.DAO.StudentGrade;
import com.example.eduadministration.request.QueryGradeRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 秋猫
 * @version 2021-06-01 10:37
 * @description 与学生和成绩有关的服务实现
 */
@Data
@Service
public class StudentCourseServiceImpl implements StudentCourseService{

    private CourseStudentRepository repository;

    /**
     * 基于构造器的依赖注入
     */
    @Autowired
    public StudentCourseServiceImpl(CourseStudentRepository repository) {

         this.repository = repository;
    }

    /**
     *
     * @param request 成绩查询请求
     * @return 如果请求中学年信息为空，返回学生的所有成绩；如果请求中学期信息为空，返回学生的schoolYear学年的所有成绩
     */
    @Override
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
}
