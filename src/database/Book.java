package database;

import javax.swing.*;
import java.sql.*;

public class Book {
    //ͼ��������������
    public static void findcategory(JComboBox<String> box) {

        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        ResultSet rs;
        String sqlStr = "select * from bookcategory";
        try {
            preSql = con.prepareStatement(sqlStr);
            rs = preSql.executeQuery();
            while (rs.next()) {
                String category = rs.getString(1);
                box.addItem(category);
            }
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //���ͼ����Ϣ
    public static void addbook(String category,String bookname,String author,String press) {

        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        String sqlStr = "insert into booktable(category,bookname,author,press,state) values (?,?,?,?,?)";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, category);
            preSql.setString(2, bookname);
            preSql.setString(3, author);
            preSql.setString(4, press);
            preSql.setString(5, "�ڹ�");
            preSql.executeUpdate();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //�޸�ͼ����Ϣ
    public static void modifybook(int bookid,String category,String bookname,String author,String press,String state) {

        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        String sqlStr = "update booktable set category = ? ,bookname = ? ,author = ?,press = ? ,state = ? where bookid = ?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, category);
            preSql.setString(2, bookname);
            preSql.setString(3, author);
            preSql.setString(4, press);
            preSql.setString(5, state);
            preSql.setInt(6, bookid);
            preSql.executeUpdate();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //ɾ��ͼ��
    public static void deletebook(int bookid) {

        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        String sqlStr = "delete from booktable where bookid = ?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setInt(1, bookid);
            preSql.executeUpdate();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
