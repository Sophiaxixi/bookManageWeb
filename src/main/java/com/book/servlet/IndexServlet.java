package com.book.servlet;

import com.book.entity.User;
import com.book.service.BookService;
import com.book.service.impl.BookServiceImpl;
import com.book.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;
import org.thymeleaf.standard.expression.Each;

import java.io.IOException;

/**
 * @Author: shlin
 * @Date: 2022/12/5 - 12 - 05 - 23:25
 * @Description: com.book.servlet
 * @Version: 1.0
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        User user = (User) req.getSession().getAttribute("user");
        context.setVariable("nickname",user.getNickname());
        context.setVariable("borrow_list",bookService.getBorrowList());
        context.setVariable("borrow_count",bookService.getBorrowList().size());
        context.setVariable("book_count",bookService.getBookList().size());
        context.setVariable("student_count",bookService.getStudentList().size());
        //bookService.getBorrowList().forEach(System.out::println);
        ThymeleafUtil.process("index.html", context, resp.getWriter());
    }
}
