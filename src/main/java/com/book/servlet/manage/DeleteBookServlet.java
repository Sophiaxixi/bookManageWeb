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
 * @Date: 2022/12/7 - 12 - 07 - 9:52
 * @Description: com.book.servlet.manage
 * @Version: 1.0
 */
@WebServlet("/delete_book")
public class DeleteBookServlet extends HttpServlet {
    BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bid = Integer.parseInt(req.getParameter("bid")); //其实是int 但是这里只能返回string
        bookService.deleteBook(bid);
        resp.sendRedirect("book");
    }
}
