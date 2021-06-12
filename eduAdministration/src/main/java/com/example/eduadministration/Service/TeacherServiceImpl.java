package com.example.eduadministration.Service;

import com.example.eduadministration.DAO.TeacherRepository;
import com.example.eduadministration.Mapper.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements BaseSqlService{

    private final TeacherRepository repository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
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
}
