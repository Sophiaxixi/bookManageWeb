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
 * @Date: 2022/12/6 - 12 - 06 - 21:05
 * @Description: com.book.servlet.manage
 * @Version: 1.0
 */
@WebServlet("/return_book")
public class ReturnServlet extends HttpServlet {
    BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id"); //其实是int 但是这里只能返回string
        bookService.returnBook(id);
        resp.sendRedirect("index");

        ThymeleafUtil.process("index.html", new Context(), resp.getWriter());
    }
}
