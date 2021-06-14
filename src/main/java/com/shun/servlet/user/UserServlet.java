package com.shun.servlet.user;

import com.mysql.jdbc.StringUtils;
import com.shun.pojo.User;
import com.shun.service.user.UserService;
import com.shun.service.user.UserServiceImpl;
import com.shun.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method.equals("savepwd")&& method != null) {
            this. updatePwd(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void updatePwd(HttpServletRequest req, HttpServletResponse resp) {
        Object user = req.getSession().getAttribute(Constants.USER_SESSION);

        String newpassword = req.getParameter("newpassword");

        boolean flag = false;

        if(user != null && !StringUtils.isNullOrEmpty(newpassword)) {
            UserService userService = new UserServiceImpl();
            flag = userService.updatePwd(((User)user).getId(), newpassword);
            if(flag) {
                req.setAttribute("message", " 修改密码成功");
                req.getSession().removeAttribute(Constants.USER_SESSION);
                try {
                    resp.sendRedirect(req.getContextPath() + "/jsp/pwdmodify.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                req.setAttribute("message", "密码修改失败");
                try {
                    req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            req.setAttribute("message", "密码有问题");
            try {
                req.getRequestDispatcher("pwdmodify.jsp").forward(req, resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

