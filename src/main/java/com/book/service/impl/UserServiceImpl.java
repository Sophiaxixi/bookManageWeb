package com.book.service.impl;

import com.book.dao.UserMapper;
import com.book.entity.User;
import com.book.service.UserService;
import com.book.utils.mybatisUtil;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author: shlin
 * @Date: 2022/12/5 - 12 - 05 - 21:43
 * @Description: com.book.service.impl
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {

    @Override
    public boolean auth(String username, String password, HttpSession session) {
        try(SqlSession sqlsession = mybatisUtil.getSession()){
            UserMapper userMapper = sqlsession.getMapper(UserMapper.class);
            User user = userMapper.getUser(username, password);
            if(user==null) return false;
            session.setAttribute("user",user);
            return true;
        }
    }
}
