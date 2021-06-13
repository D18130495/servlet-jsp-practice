package com.shun.servlet.user;

import com.shun.pojo.User;
import com.shun.service.user.UserService;
import com.shun.service.user.UserServiceImpl;
import com.shun.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    //控制层调用业务层
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        //调用业务层
        UserService userService = new UserServiceImpl();
        User user = userService.login(userCode, userPassword);

        if(user != null) {
            req.getSession().setAttribute(Constants.USER_SESSION, user);
            //跳转到主页面
            resp.sendRedirect("jsp/frame.jsp");
        }else {
            req.setAttribute("error", "用户名不正确");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
