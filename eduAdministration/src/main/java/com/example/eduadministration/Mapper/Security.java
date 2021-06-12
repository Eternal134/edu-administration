package com.example.eduadministration.Mapper;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 秋猫
 * @version 2021-06-04 15:41
 * @Description 用于保存账号密码
 */
@Entity
@Data
public class Security {

    /**
     * 账号
     */
    @Id
    @Column(nullable = false, length = 10)
    private String userId;

    /**
     * 密码
     */
    @Column(length = 30)
    private String password;
}
