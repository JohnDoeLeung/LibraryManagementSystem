package database;

import java.sql.*;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FindBook {
    // ��ʾ����ͼ��
    public static void allbook(DefaultTableModel model) {

        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        ResultSet rs;
        String sqlStr = "select * from booktable";

        try {
            preSql = con.prepareStatement(sqlStr);
            rs = preSql.executeQuery();
            while (rs.next()) {
                int bookid = rs.getInt(1);
                String category = rs.getString(2);
                String bookname = rs.getString(3);
                String author = rs.getString(4);
                String press = rs.getString(5);
                String state = rs.getString(6);
                model.addRow(new Vector<>(Arrays.asList(bookid, category, bookname, author, press, state)));
            }
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // ��������ͼ��
    public static void findcategory(DefaultTableModel model, String CateGory) {
        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        ResultSet rs;
        CateGory = "%" + CateGory + "%";
        String sqlStr = "select * from booktable where category like ?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, CateGory);
            rs = preSql.executeQuery();
            boolean flag = false;
            while (rs.next()) {
                flag = true;
                int bookid = rs.getInt(1);
                String category = rs.getString(2);
                String bookname = rs.getString(3);
                String author = rs.getString(4);
                String press = rs.getString(5);
                String state = rs.getString(6);
                model.addRow(new Vector<>(Arrays.asList(bookid, category, bookname, author, press, state)));
            }
            if (!flag) {
                JOptionPane.showMessageDialog(null, "ͼ�鲻����", "����", JOptionPane.WARNING_MESSAGE);
            }
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ����������ͼ��
    public static void findbookname(DefaultTableModel model, String BookName) {
        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        ResultSet rs;
        BookName = "%" + BookName + "%";
        String sqlStr = "select * from booktable where bookname like ?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, BookName);
            rs = preSql.executeQuery();
            boolean flag = false;
            while (rs.next()) {
                flag = true;
                int bookid = rs.getInt(1);
                String category = rs.getString(2);
                String bookname = rs.getString(3);
                String author = rs.getString(4);
                String press = rs.getString(5);
                String state = rs.getString(6);
                model.addRow(new Vector<>(Arrays.asList(bookid, category, bookname, author, press, state)));
            }
            if (!flag) {
                JOptionPane.showMessageDialog(null, "ͼ�鲻����", "����", JOptionPane.WARNING_MESSAGE);
            }
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // �����߲���ͼ��
    public static void findauthor(DefaultTableModel model, String Author) {
        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        ResultSet rs;
        Author = "%" + Author + "%";
        String sqlStr = "select * from booktable where author like ?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, Author);
            rs = preSql.executeQuery();
            boolean flag = false;
            while (rs.next()) {
                flag = true;
                int bookid = rs.getInt(1);
                String category = rs.getString(2);
                String bookname = rs.getString(3);
                String author = rs.getString(4);
                String press = rs.getString(5);
                String state = rs.getString(6);
                model.addRow(new Vector<>(Arrays.asList(bookid, category, bookname, author, press, state)));
            }
            if (!flag) {
                JOptionPane.showMessageDialog(null, "ͼ�鲻����", "����", JOptionPane.WARNING_MESSAGE);
            }
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // ����Ų���ͼ��
    public static void findbookid(DefaultTableModel model, int BookId) {
        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        ResultSet rs;
        String sqlStr = "select * from booktable where bookid = ?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setInt(1, BookId);
            rs = preSql.executeQuery();
            boolean flag = false;
            while (rs.next()) {
                flag = true;
                int bookid = rs.getInt(1);
                String category = rs.getString(2);
                String bookname = rs.getString(3);
                String author = rs.getString(4);
                String press = rs.getString(5);
                String state = rs.getString(6);
                model.addRow(new Vector<>(Arrays.asList(bookid, category, bookname, author, press, state)));
            }
            if (!flag) {
                JOptionPane.showMessageDialog(null, "ͼ�鲻����", "����", JOptionPane.WARNING_MESSAGE);
            }
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


