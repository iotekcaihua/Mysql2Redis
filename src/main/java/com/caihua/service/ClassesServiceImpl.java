package com.caihua.service;

import com.caihua.bean.Classes;
import com.caihua.mapper.ClassesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    public List<Classes> findAllClasses() {
        return classesMapper.findAll();
    }

    public void addToRedis(List<Classes> classes) {

    }
}
