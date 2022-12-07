package com.book.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: shlin
 * @Date: 2022/12/6 - 12 - 06 - 20:19
 * @Description: com.book.entity
 * @Version: 1.0
 */
@Data
public class Borrow {
    int id;
    int book_id;
    String book_name;
    Date date;
    String student_name;
    int student_id;
}
