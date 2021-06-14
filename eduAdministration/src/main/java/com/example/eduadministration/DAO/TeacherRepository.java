package com.example.eduadministration.DAO;

import com.example.eduadministration.Mapper.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, String> {
}
