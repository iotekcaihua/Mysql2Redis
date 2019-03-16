package com.caihua.mapper;

import com.caihua.bean.Classes;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesMapper {

    public void addClasses(Classes classes);

    public  void delClasses(int cid);

    public void updateClasses(Classes classes);

    public Classes findClasses(String cname);

    List<Classes> findAll();
}
