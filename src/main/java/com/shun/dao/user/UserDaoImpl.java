package com.shun.dao.user;

import com.shun.dao.BaseDao;
import com.shun.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao{

    public User getLonginUser(Connection connection, String userCode) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if(connection != null) {
            String sql = "select * from smbms_user where userCode = ?";
            Object[] params = {userCode};

            try {
                rs = BaseDao.exectue(connection, pstm, rs, sql, params);

                if(rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUserCode(rs.getString("userCode"));
                    user.setUserName(rs.getString("userName"));
                    user.setUserPassword(rs.getString("userPassword"));
                    user.setGender(rs.getInt("gender"));
                    user.setBirthday(rs.getDate("birthday"));
                    user.setPhone(rs.getString("phone"));
                    user.setAddress(rs.getString("address"));
                    user.setUserRole(rs.getInt("userRole"));
                    user.setCreatedBy(rs.getInt("createdBy"));
                    user.setCreationDate(rs.getTimestamp("creationDate"));
                    user.setModifyBy(rs.getInt("modifyBy"));
                    user.setModifyDate(rs.getTimestamp("modifyDate"));
                }
                BaseDao.closeResource(null, pstm, rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    public  int updatePwd(Connection connection, int id, String password) {
        PreparedStatement pstm = null;
        int rs = 0;

        if (connection != null) {
            Object[] params = {password, id};
            String sql = "update smbms_user set userPassword = ? where id = ?";

            try {
                rs = BaseDao.exectue(connection, pstm, sql, params);
            } catch (Exception e) {
                e.printStackTrace();
            }

            BaseDao.closeResource(null, pstm, null);
        }
        return rs;
    }

}
