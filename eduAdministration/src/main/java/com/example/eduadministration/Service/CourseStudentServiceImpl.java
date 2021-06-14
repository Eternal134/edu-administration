package com.example.eduadministration.Service;

import com.example.eduadministration.DAO.CourseStudentRepository;
import com.example.eduadministration.Mapper.CourseStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseStudentServiceImpl implements BaseService{

    private final CourseStudentRepository courseStudentRepository;

    @Autowired
    public CourseStudentServiceImpl(CourseStudentRepository courseStudentRepository) {
        this.courseStudentRepository = courseStudentRepository;
    }

    @Override
    public void addRecord(Object object) {
        courseStudentRepository.save((CourseStudent) object);
    }

    public List<?> findAllRecord() {
        List<CourseStudent> courseStudentList = new ArrayList<>();
        courseStudentRepository.findAll().forEach(courseStudentList::add);
        return courseStudentList;
    }
}
