package com.example.eduadministration.DAO;

import com.example.eduadministration.Mapper.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 秋猫
 * @version 2021-06-04 16:10
 * @Description 描述
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
}
