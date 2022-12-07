package com.book.servlet.manage;

import com.book.service.BookService;
import com.book.service.impl.BookServiceImpl;
import com.book.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

/**
 * @Author: shlin
 * @Date: 2022/12/6 - 12 - 06 - 22:36
 * @Description: com.book.servlet.manage
 * @Version: 1.0
 */
@WebServlet("/add-borrow")
public class AddBorrowServlet extends HttpServlet {

    BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = new Context();
        context.setVariable("active_book",bookService.getActivateBook());
        bookService.getActivateBook().forEach(System.out::println);
        context.setVariable("active_student",bookService.getStudentList());
        //bookService.getStudentList().forEach(System.out::println);
        ThymeleafUtil.process("add-borrow.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bid = Integer.parseInt(req.getParameter("book"));
        int sid = Integer.parseInt(req.getParameter("student"));
        bookService.addBorrow(bid,sid);
        resp.sendRedirect("index");
    }
}
