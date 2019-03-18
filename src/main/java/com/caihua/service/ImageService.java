package com.caihua.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public interface ImageService {

    //存入一张图片
    void addImage(URL imageURL);

    void getImage(String id);

    //取出一张图片
    byte[] downloadImage(String id);

}
