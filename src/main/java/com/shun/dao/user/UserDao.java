package com.shun.dao.user;

import com.shun.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    //得到要登陆的用户
    public User getLonginUser(Connection connection, String userCode);
}
