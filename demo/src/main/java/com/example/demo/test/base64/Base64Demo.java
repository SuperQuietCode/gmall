package com.example.demo.test.base64;


import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @author ZhaoXin
 * @date 2020/9/22 15:02
 */
public class Base64Demo {
    public static void main(String[] args) throws IOException {

        String s = "hello world";
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(s.getBytes());
        System.out.println(encode);

        BASE64Decoder decoder = new BASE64Decoder();
        System.out.println(new String(decoder.decodeBuffer(encode)));
    }

    /**
     * 将图片处理成Base64编码格式
     *
     * @return
     */
    public static String encodeImg(MultipartFile file) {
        byte[] imgBytes = null;
        try {
            imgBytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return imgBytes == null ? null : encoder.encode(imgBytes);
    }

}
