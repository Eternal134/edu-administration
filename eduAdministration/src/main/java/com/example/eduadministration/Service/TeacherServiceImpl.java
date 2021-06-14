package com.example.eduadministration.Service;

import com.example.eduadministration.DAO.CourseTeacherRepository;
import com.example.eduadministration.DAO.TeacherRepository;
import com.example.eduadministration.Mapper.Course;
import com.example.eduadministration.Mapper.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements BaseService {

    private final TeacherRepository repository;

    private final CourseTeacherRepository courseTeacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository repository, CourseTeacherRepository courseTeacherRepository) {

        this.repository = repository;
        this.courseTeacherRepository = courseTeacherRepository;
    }

    @Override
    public void addRecord(Object object) {
        repository.save((Teacher) object);
    }

    /**
     * @return 所有教师列表
     */
    public List<Teacher> findAll() {

        Iterable<Teacher> teacherIterable = repository.findAll();
        List<Teacher> teacherList = new ArrayList<>();
        teacherIterable.forEach(teacherList::add);
        return teacherList;
    }

    /**
     * @param teacherId 教师工号
     * @return 这个老师带的所有的课
     */
    public List<Course> getCourseByTeacherId(String teacherId) {
        return courseTeacherRepository.fetchCourseByTeacherId(teacherId);
    }
}
