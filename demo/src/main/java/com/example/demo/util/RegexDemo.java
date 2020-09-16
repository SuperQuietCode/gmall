package com.example.demo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证正则表达式
 *
 * @author ZhaoXin
 * @date 2020/9/16 10:59
 */
public class RegexDemo {
    public static void main(String[] args) {
        System.out.println(checkEmail("11111@ 11.11"));
    }

    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            // String check = "^（[a-z0-9A-Z]+[-|\\.]?）+[a-z0-9A-Z]@（[a-z0-9A-Z]+（-[a-z0-9A-Z]+）？\\.）+[a-zA-Z]{2,}$";
            String check = "\\S+@\\S+\\.\\S+";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
