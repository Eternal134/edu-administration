package com.example.eduadministration.DAO;

import com.example.eduadministration.Mapper.CourseTeacher;
import org.hibernate.mapping.PrimaryKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CourseTeacherRepository extends CrudRepository<CourseTeacher, PrimaryKey> {

}
