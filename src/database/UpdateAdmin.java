package database;

import java.sql.*;

public class UpdateAdmin {
    public static boolean sureuser(String user) {

        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        ResultSet rs;
        String sqlStr = "select * from usertable where user = ?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, user);
            rs = preSql.executeQuery();
            boolean flag = false;
            while(rs.next()) {
                flag = true;
                return true;
            }
            if(!flag) {
                return false;
            }
            con.close();
            return false;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //删除用户
    public static void deleteuser(String user) {
        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        String sqlStr = "delete from usertable where user = ?";
        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, user);
            preSql.executeUpdate();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //更改为用户
    public static void updateuser(String user) {
        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        String sqlStr = "update usertable  set admin = ? where user = ?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setInt(1, 0);
            preSql.setString(2, user);
            int ok = preSql.executeUpdate();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //添加为管理员
    public static void updateadmin(String user) {
        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        String sqlStr = "update usertable  set admin = ? where user = ?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setInt(1, 1);
            preSql.setString(2, user);
            preSql.executeUpdate();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //更改密码
    public static void updatepass(String user,String password) {
        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        String sqlStr = "update usertable  set password = ? where user = ?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, password);
            preSql.setString(2, user);
            preSql.executeUpdate();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
