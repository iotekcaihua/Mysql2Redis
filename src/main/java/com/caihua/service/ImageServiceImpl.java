package com.caihua.service;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.UUID;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void addImage(URL imageURL) {
        ByteArrayOutputStream outputStream = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(imageURL);
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", outputStream);
            String imageStr = Base64.encodeBase64String(outputStream.toByteArray());
            String str=UUID.randomUUID().toString();
            log.info("上传图片成功，图片id为:"+str);
            redisTemplate.opsForValue().set(str,imageStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getImage(String id) {
        String imageStr = redisTemplate.opsForValue().get(id);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("D:/Images/" + id + ".jpg"));
            byte[] decodedStr = Base64.decodeBase64(imageStr);
            fos.write(decodedStr);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] downloadImage(String id) {
        String imagStr = redisTemplate.opsForValue().get(id);
        byte[] bytes = Base64.decodeBase64(imagStr);
        return  bytes;
    }
}
