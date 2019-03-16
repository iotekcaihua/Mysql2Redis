package com.caihua.mapper;

import com.caihua.bean.User;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public void addUser(User user);

    public void delUser(int id);

    public void updateUser(User user);

    public List<User> findUsers(String name);

    public User findUser(int id);

    List<User> findAll();
}
