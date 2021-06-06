package com.example.eduadministration.Service;

import com.example.eduadministration.DAO.StudentGrade;
import com.example.eduadministration.request.QueryGradeRequest;

import java.util.List;

/**
 * @author eleme
 * @version $Id: StudentCourseService.java, v 0.1 2021-06-01 10:39 上午 eleme Exp $$
 * 与学生和成绩有关的服务
 */
public interface StudentCourseService {

    /**
     * 查询一个学生的成绩
     * @param  request 成绩查询请求
     * @return 所有学生成绩
     */
    List<StudentGrade> queryGrade(QueryGradeRequest request);
}
