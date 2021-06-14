package com.shun.service.user;

import com.shun.dao.BaseDao;
import com.shun.dao.user.UserDao;
import com.shun.dao.user.UserDaoImpl;
import com.shun.pojo.User;
import org.junit.Test;

import java.sql.Connection;

public class UserServiceImpl implements UserService{
    //业务层调用dao层
    private UserDao userDao;
    public  UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;

        connection = BaseDao.getConnection();
        user = userDao.getLonginUser(connection, userCode);
        BaseDao.closeResource(connection, null, null);

        return user;
    }

    public boolean updatePwd(int id, String pwd) {
        Connection connection = null;
        boolean flag = false;

        connection = BaseDao.getConnection();
        if(userDao.updatePwd(connection, id, pwd) > 0) {
            flag = true;
        }
        BaseDao.closeResource(connection, null, null);

        return flag;
    }

//    @Test
//    public void test() {
//        UserServiceImpl userService = new UserServiceImpl();
//        User user = userService.login("wen", "123456");
//        System.out.println(user.getUserName());
//    }
}
