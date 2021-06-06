package com.example.eduadministration.Service;

/**
 * @author 秋猫
 * @version 2021-06-04 16:22
 * @Description 最基本的数据库操作接口，包括最简单的增删查改
 */
public interface BaseSqlService {

    /**
     * 向数据库表中增加一条记录
     * @param object 对应的数据库映射对象
     */
    void addRecord(Object object);
}
