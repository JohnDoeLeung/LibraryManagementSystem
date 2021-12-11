package database;

import javax.swing.*;
import java.sql.*;

public class Adduser {
    public static Boolean adduser(String user, String studentid, String name, String password) {

        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        String sqlStr=null;

        if(userlist()) {
            sqlStr = "insert into usertable values (?,?,?,?,0)";
        }
        else {
            sqlStr = "insert into usertable values (?,?,?,?,1)";
        }

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, user);
            preSql.setString(2, studentid);
            preSql.setString(3, name);
            preSql.setString(4, password);
            preSql.executeUpdate();
            con.close();
            return true;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog
                    (null, "用户名已存在", "警告", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    //判断用户是否存在
    public static boolean userlist() {

        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        ResultSet rs;

        String sqlStr = "select * from usertable";
        try {
            preSql = con.prepareStatement(sqlStr);
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
}
