package com.example.eduadministration.Service;

import com.example.eduadministration.Model.StudentUser;
import com.example.eduadministration.Model.User;

/**
 * @author eleme
 * @version $Id: UserService.java, v 0.1 2021-05-12 2:58 下午 eleme Exp $$
 */
public interface UserService {
    /**
     * 新增用户
     * @param user 用户
     */
    void addUser(User user);

    /**
     * 查询所有用户
     * @return 所有用户
     */
    Iterable<?> allUser();
}
