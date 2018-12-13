package com.example.demo.entity;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * create by guanhao 2018-12-12
 **/
public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        logger.info("测试日志 info");
        logger.error("测试日志 error");
        logger.warn("测试日志 warn");

    }
}
