package database;

import java.sql.*;
import javax.swing.JOptionPane;

public class Landing {
    public static Boolean test(String user, String password) {

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
                String password2 = rs.getString(4);
                if (!(password.equals(password2))) {
                    JOptionPane.showMessageDialog(null, "�������", "����", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }
            if(!flag) {
                JOptionPane.showMessageDialog(null, "�û���������", "����", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            con.close();
            return true;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "�û���������", "����", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    //ȷ���Ƿ�Ϊ����Ա
    public static boolean sureadmin(String user) {
        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        ResultSet rs;
        String sqlStr = "select * from usertable where user = ?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, user);
            rs = preSql.executeQuery();
            while(rs.next()) {
                int admin = rs.getInt(5);
                if (admin==1) {
                    return true;
                }else {
                    return false;
                }
            }
            con.close();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}