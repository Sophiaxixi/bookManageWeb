package com.book.service.impl;

import com.book.dao.BorrowMapper;
import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Student;
import com.book.service.BookService;
import com.book.utils.mybatisUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.apache.ibatis.session.SqlSession;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: shlin
 * @Date: 2022/12/6 - 12 - 06 - 20:32
 * @Description: com.book.service.impl
 * @Version: 1.0
 */
public class BookServiceImpl implements BookService {
    @Override
    public List<Borrow> getBorrowList() {
        try(SqlSession sqlSession = mybatisUtil.getSession();) {
            BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
            return borrowMapper.getBorrowList();
        }
    }

    @Override
    public void returnBook(String bid) {

        try(SqlSession sqlSession = mybatisUtil.getSession();) {
            BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
            borrowMapper.returnBook(bid);
        }

    }

    @Override
    public void addBorrow(int bid, int sid) {

        try(SqlSession sqlSession = mybatisUtil.getSession();) {
            BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
            borrowMapper.addBorrow(bid,sid);
        }
    }

    @Override
    public List<Book> getActivateBook() {//获取没被借走的书
        Set<Integer> set = new HashSet<>();
        this.getBorrowList().forEach(borrow->set.add(borrow.getBook_id()));
        try(SqlSession sqlSession = mybatisUtil.getSession()){
            BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
            return borrowMapper.getBookList()
                    .stream()
                    .filter(book -> !set.contains(book.getBid()))//没被接走的才允许通过
                    .collect(Collectors.toList());
        }
    }

    @Override
    public Map<Book, Boolean> getBookList() {
        Set<Integer> set = new HashSet<>();
        this.getBorrowList().forEach(borrow->set.add(borrow.getBook_id()));
        Map<Book, Boolean> map = new LinkedHashMap<>();
        try(SqlSession sqlSession = mybatisUtil.getSession()){
            BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
            borrowMapper.getBookList().forEach(book -> map.put(book,set.contains(book.getBid())));
            return map;
        }
    }

    @Override
    public List<Student> getStudentList() {
        try(SqlSession sqlSession = mybatisUtil.getSession()){
            BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
            return borrowMapper.getStudentList();
        }
    }

    @Override
    public void deleteBook(int bid) {
        try(SqlSession sqlSession = mybatisUtil.getSession()){
            BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
            borrowMapper.deleteBook(bid);
        }

    }

    @Override
    public void addBook(String name, String descrip, double price) {
        try(SqlSession sqlSession = mybatisUtil.getSession()){
            BorrowMapper borrowMapper = sqlSession.getMapper(BorrowMapper.class);
            borrowMapper.addBook(name,descrip,price);
        }
    }
}
