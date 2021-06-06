package com.example.eduadministration.Model;

import lombok.Data;

import javax.persistence.*;

/**
 * 用户接口
 * @author 秋猫
 * @version $Id: User.java, v 0.1 2021-05-11 7:32 下午 eleme Exp $$
 * MappedSuperclass注解: 数据库模型的抽象父类, 拥有此注解的类不会映射到数据库中
 */
@MappedSuperclass
@Data
public abstract class User {

    /**
     * 用户姓名
     */
    @Column(nullable = false, length = 5)
    private String name;

    /**
     * 邮箱
     */
    @Column(length = 30)
    private String mail;

    /**
     * 性别
     */
    @Column(length = 2, nullable = false)
    private String sex;

    /**
     * 默认构造函数，JPA自动调用，可以设置为protected
     */
    protected User() {}

}
