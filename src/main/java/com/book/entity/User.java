package com.book.entity;

import lombok.Data;

/**
 * @Author: shlin
 * @Date: 2022/12/5 - 12 - 05 - 21:18
 * @Description: com.book.entity
 * @Version: 1.0
 */
@Data
public class User {
    int id;
    String name;
    String nickname;
    String password;
}
