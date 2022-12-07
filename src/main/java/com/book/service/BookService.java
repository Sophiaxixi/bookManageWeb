package com.book.service;

import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @Author: shlin
 * @Date: 2022/12/6 - 12 - 06 - 20:31
 * @Description: com.book.service
 * @Version: 1.0
 */
public interface BookService {
    List<Borrow> getBorrowList();
    void returnBook(String bid);

    void addBorrow(int bid, int sid);

    List<Book> getActivateBook();

    Map<Book,Boolean> getBookList();

    List<Student> getStudentList();

    void deleteBook(int bid);

    void addBook(String name, String descrip, double price);
}
