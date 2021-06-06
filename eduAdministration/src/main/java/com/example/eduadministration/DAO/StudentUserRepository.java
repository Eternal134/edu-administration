package com.example.eduadministration.DAO;

import com.example.eduadministration.Model.StudentUser;
import com.example.eduadministration.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 学生用户表DAO层接口
 * @author eleme
 * @version $Id: UserRepository.java, v 0.1 2021-05-11 8:08 下午 eleme Exp $$
 */
@Repository
public interface StudentUserRepository extends CrudRepository<StudentUser, Long> {

    /**
     * 根据用户的工号查询用户，只能查到一个
     * @param studentId 工号
     * @return StudentUser对象
     */
    StudentUser findByStudentId(String studentId);

    /**
     * 根据姓名查询用户，可能查到多个
     * @param name 姓名
     * @return 所有查到的学生用户
     */
    List<StudentUser> findByName(String name);

}
