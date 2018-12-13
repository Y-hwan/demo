package com.example.demo.util;

public class MD5UtilsTest {

    public static void main(String[] args) {
        String password = "950222";
        String password2 = MD5Utils.MD5Encode(password,"utf8");

        System.out.println("加密前密码: " + password);
        System.out.println("加密后密码: " + password2);
    }

}