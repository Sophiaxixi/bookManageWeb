package com.book.servlet.auth;

import com.book.entity.User;
import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;
import com.book.utils.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.thymeleaf.context.Context;

import java.io.IOException;

/**
 * @Author: shlin
 * @Date: 2022/12/5 - 12 - 05 - 20:48
 * @Description: com.book.servlet
 * @Version: 1.0
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService userService;
    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Context context = new Context();
        if(req.getSession().getAttribute("login-failure")!=null){
            context.setVariable("failure",true);
            req.getSession().removeAttribute("login-failure");//下一次就不会再出现
        }
        User user = (User) req.getSession().getAttribute("user");
        if(user!=null){
            resp.sendRedirect("index");
            System.out.println("没有重定向吗");
            return;
        }
        ThymeleafUtil.process("login.html", context, resp.getWriter()); //什么都没做，就是把页面返回给前端
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        if(userService.auth(username,password, req.getSession())){
            resp.sendRedirect("index");
            System.out.println("输入了可以进");
        }else{
            req.getSession().setAttribute("login-failure",new Object());
            this.doGet(req,resp);
        }
    }
}
