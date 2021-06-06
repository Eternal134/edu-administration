package com.example.eduadministration.Service;

import com.example.eduadministration.DAO.CourseRepository;
import com.example.eduadministration.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 秋猫
 * @version 2021-06-04 16:27
 * @Description 针对Course表的数据库基础操作服务实现
 */
@Service
public class CourseBaseSqlServiceImpl implements BaseSqlService{

    private final CourseRepository repository;

    @Autowired
    public CourseBaseSqlServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addRecord(Object object) {
        // 向下转型
        Course course = (Course) object;
        repository.save(course);
    }
}
