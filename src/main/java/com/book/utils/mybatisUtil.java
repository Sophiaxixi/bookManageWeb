package com.book.utils;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @Author: shlin
 * @Date: 2022/12/5 - 12 - 05 - 21:36
 * @Description: com.book.utils
 * @Version: 1.0
 */
public class mybatisUtil {
    private static SqlSessionFactory factory;
    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static SqlSession getSession(){
        return factory.openSession(true);
    }

}
