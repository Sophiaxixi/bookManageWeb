package com.book.service;

import jakarta.servlet.http.HttpSession;

/**
 * @Author: shlin
 * @Date: 2022/12/5 - 12 - 05 - 21:41
 * @Description: com.book.service
 * @Version: 1.0
 */
public interface UserService {
    boolean auth(String username, String password, HttpSession session);
}
