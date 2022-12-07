package com.book.dao;

import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Student;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: shlin
 * @Date: 2022/12/6 - 12 - 06 - 20:22
 * @Description: com.book.dao
 * @Version: 1.0
 */
public interface BorrowMapper {
    @Results({
        @Result(column = "id",property = "id"),
        @Result(column = "bid",property = "book_id"),
        @Result(column = "bname",property = "book_name"),
        @Result(column = "time",property = "date"),
        @Result(column = "sname",property = "student_name"),
        @Result(column = "sid",property = "student_id"),

    })
    @Select("select * from borrow,student,book where borrow.sid = student.sid and borrow.bid = book.bid")
    List<Borrow> getBorrowList();

    @Delete("delete from borrow where id=#{id}")
    void returnBook(String id);

    @Insert("insert into borrow(sid,bid,time) values(#{sid},#{bid},NOW())")
    void addBorrow(@Param("bid") int bid,@Param("sid")int sid);
    @Results({
            @Result(column = "bid",property = "bid"),
            @Result(column = "bname",property = "title"),
            @Result(column = "descrip",property = "descr"),
            @Result(column = "price",property = "price"),
    })
    @Select("select * from book")
    List<Book> getBookList();

    @Results({
            @Result(column = "sid",property = "sid"),
            @Result(column = "sname",property = "name"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "grade",property = "grade"),
    })
    @Select("select * from student")
    List<Student> getStudentList();

    @Delete("delete from book where bid = #{bid}")
    void deleteBook(int bid);

    @Insert("insert into book(bname,descrip,price) values(#{bname},#{descrip},#{price})")
    void addBook(@Param("bname") String bname, @Param("descrip") String descrip, @Param("price") double price);
}
