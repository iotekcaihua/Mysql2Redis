package com.caihua.service;

import com.alibaba.fastjson.JSON;
import com.caihua.bean.Classes;
import com.caihua.bean.User;
import com.caihua.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private UserMapper userMapper;

    public void addToRedis() {
        log.info("开始加入Redis");
        List<User> users=userMapper.findAll();
        Map<String,String> map=new HashMap<String, String>();
        for(User user:users){
            map.put(String.valueOf(user.getId()), JSON.toJSONString(user));
        }
        redisTemplate.opsForHash().putAll("SYS_USER_TABLE",map);
        log.info("已经全部加入Redis");
    }

    public void addUser() {
        for(int i=0;i<100;i++){
            User user=new User("用户"+i,"男",23);
            user.setClasses(new Classes(1));
            userMapper.addUser(user);
        }
    }
}
