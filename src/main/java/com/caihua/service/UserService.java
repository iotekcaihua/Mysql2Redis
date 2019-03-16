package com.caihua.service;

import com.caihua.bean.User;
import com.caihua.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    //将所有的User存入redis
    void addToRedis();

    void addUser();
}
