package com.book.dao;

import com.book.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: shlin
 * @Date: 2022/12/5 - 12 - 05 - 21:33
 * @Description: com.book.dao
 * @Version: 1.0
 */
public interface UserMapper{
    @Select("select * from admin where username = #{username} and password = #{password}")
    User getUser(@Param("username") String username, @Param("password") String password);
}
