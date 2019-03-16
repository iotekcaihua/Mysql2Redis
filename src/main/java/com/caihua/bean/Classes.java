package com.caihua.bean;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Alias("Classes")
public class Classes {

    private int cid;
    private String cname;
    private List<User> users;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Classes() {
    }

    public Classes(int cid) {
        this.cid = cid;
    }
}
