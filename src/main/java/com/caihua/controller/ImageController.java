package com.caihua.controller;

import com.alibaba.fastjson.JSON;
import com.caihua.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Iterator;

@Controller
@RequestMapping("image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "addImage", produces = "text/json;charset=utf-8")
    @ResponseBody
    public String addImage(MultipartFile[] file, HttpServletRequest request) throws IOException {
        if (file != null && file.length > 0) {
            for (int i = 0; i < file.length; i++) {
                String fileName = file[i].getOriginalFilename();
                File f = new File("D:/uploadimages");
                if (!f.exists()) {
                    f.mkdir();
                }
                File f2 = new File("D:/uploadimages/" + fileName);
                file[i].transferTo(f2);
                imageService.addImage(new URL("file:///" + "D:/uploadimages/" + fileName));
            }
            return JSON.toJSONString("上传成功");
        }
        return JSON.toJSONString("无上传文件");
    }

    @RequestMapping(value = "getImage", produces = "text/json;charset=utf-8")
    @ResponseBody
    public String getImage(String id) {
        imageService.getImage(id);
        return JSON.toJSONString("文件已存入到D盘Images目录下，请查看！");
    }

    @RequestMapping(value = "showImage", produces = "text/json;charset=utf-8")
    public void showImage(String gid, HttpServletResponse response) {
        byte[] bytes = imageService.downloadImage(gid);
        try {
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
