package com.caihua.service;

import com.caihua.bean.Classes;

import java.util.List;

public interface ClassesService {

    //找到所有的班级
    List<Classes> findAllClasses();

    //将所有班级存入Redis
    void addToRedis(List<Classes> classes);

}
