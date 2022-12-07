package com.book.entity;

import lombok.Data;

/**
 * @Author: shlin
 * @Date: 2022/12/6 - 12 - 06 - 23:06
 * @Description: com.book.entity
 * @Version: 1.0
 */
@Data
public class Book {
    int bid;
    String title;
    String descr;
    double price;
}
