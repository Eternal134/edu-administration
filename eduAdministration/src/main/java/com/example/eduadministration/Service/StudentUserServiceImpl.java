package com.example.eduadministration.Service;

import com.example.eduadministration.DAO.StudentUserRepository;
import com.example.eduadministration.Model.StudentUser;
import com.example.eduadministration.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 秋猫
 * @version 2021-05-12 15:05
 * @description 学生用户Service层
 */
@Service
public class StudentUserServiceImpl implements UserService{

    /**
     * 数据库控制对象
     */
    private StudentUserRepository repository;

    /**
     * 基于setter的依赖注入
     * @param repository 数据库类型
     */
    @Autowired
    public void setRepository(StudentUserRepository repository) {

        this.repository = repository;
    }

    /**
     * 学生用户表中增加用户
     * @param user 用户
     */
    @Override
    public void addUser(User user) {
        repository.save((StudentUser) user);
    }

    /**
     * @return 所有学生用户
     */
    @Override
    public Iterable<?> allUser() {
        return repository.findAll();
    }
}
