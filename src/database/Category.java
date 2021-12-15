package database;

import java.sql.*;
import javax.swing.JOptionPane;

public class Category {
    //������
    public static boolean addcategory(String category) {

        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        String sqlStr = "insert into bookcategory values (?)";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, category);
            int ok = preSql.executeUpdate();
            con.close();
            return true;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "����Ѵ���", "����", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    //�޸����
    public static boolean setcategory(String category,String category2) {

        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        String sqlStr = "update bookcategory  set Category = ? where Category = ?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, category2);
            preSql.setString(2, category);
            int ok = preSql.executeUpdate();
            con.close();
            if(ok==0) {
                JOptionPane.showMessageDialog(null, "��𲻴���", "����", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            return true;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "��𲻴���", "����", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
