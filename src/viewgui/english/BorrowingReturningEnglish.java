package viewgui.english;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.BorrowRecords;
import database.ConnectDatabase;
import database.FindBook;

/**
 * 图书借还界面
 *
 */

public class BorrowingReturningEnglish {
    /*
     * 一个标签 图书借还 一个标签 文本框 按钮 分层窗口 大面板做底 标签 按钮 加在面板
     *
     */
    // 分层窗格
    public JLayeredPane jLayeredPane = new JLayeredPane();
    // 标签
    private JLabel jLabel = new JLabel("BorrowAndReturn");
    private JLabel jLabel2 = new JLabel("Enter ISBN：");
    private JLabel jLabel3 = new JLabel("TitleName：");
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel("Author：");
    private JLabel jLabel6 = new JLabel();
    private JLabel jLabel7 = new JLabel("Status：");
    private JLabel jLabel8 = new JLabel();
    private JLabel jLabel9 = new JLabel("ISBN：");
    private JLabel jLabel10 = new JLabel();

    // 文本框
    private JTextField field = new JTextField(20);
    // 大小
    // private Dimension dimension = new Dimension(220, 20);
    // 按钮
    private JButton button = new JButton("Retrieve");
    private JButton button2 = new JButton("Return");
    private JButton button3 = new JButton("Borrow");

    // 面板
    private JPanel jPanel = new JPanel();
    // 字体
    private Font font = new Font("宋体", Font.BOLD, 60);
    private Font font2 = new Font("宋体", Font.BOLD, 30);
    private Font font3 = new Font("宋体", Font.BOLD, 26);

    // 接收此账号的用户名
    private String user;

    // 接收图书查询表格，实现实时更新
    private DefaultTableModel model = new DefaultTableModel();
    int id;

    public BorrowingReturningEnglish() {

        // 标签
        jLabel.setFont(font);
        jLabel.setBounds(380, 35, 800, 100);
        jLabel.setForeground(Color.black);

        jLabel2.setFont(font2);
        jLabel2.setBounds(280, 164, 250, 30);
        jLabel2.setForeground(Color.black);

        // 文本框
        field.setFont(font2);
        field.setBackground(Color.black);
        field.setBounds(480, 164, 250, 30);
        field.setForeground(Color.black);
        field.setOpaque(false);

        // 按钮
        button.setFont(font2);
        button.setBounds(780, 160, 180, 40);
        button.setForeground(Color.black);
        button.setBackground(Color.black);
        button.setOpaque(false);

        // 面板
        jPanel.setBounds(270, 220, 620, 450);
        jPanel.setBackground(Color.white);
        jPanel.setLayout(null);

        // 面板上标签及按钮
        jLabel3.setFont(font2);
        jLabel4.setFont(font2);
        jLabel5.setFont(font2);
        jLabel6.setFont(font2);
        jLabel7.setFont(font2);
        jLabel8.setFont(font2);
        jLabel9.setFont(font2);
        jLabel10.setFont(font2);

        button2.setFont(font3);
        button3.setFont(font3);

        jLabel3.setForeground(Color.black);
        jLabel4.setForeground(Color.black);
        jLabel5.setForeground(Color.black);
        jLabel6.setForeground(Color.black);
        jLabel7.setForeground(Color.black);
        jLabel8.setForeground(Color.black);
        jLabel9.setForeground(Color.black);
        jLabel10.setForeground(Color.black);

        button2.setForeground(Color.black);
        button3.setForeground(Color.black);

        jLabel9.setBounds(100, 20, 100, 50);
        jLabel10.setBounds(200, 20, 400, 50);
        jLabel3.setBounds(40, 90, 230, 50);
        jLabel4.setBounds(200, 90, 400, 50);
        jLabel5.setBounds(80, 160, 130, 50);
        jLabel6.setBounds(200, 160, 400, 50);
        jLabel7.setBounds(80, 230, 130, 50);
        jLabel8.setBounds(200, 230, 400, 50);

        button2.setBounds(80, 310, 140, 50);
        button3.setBounds(460, 310, 140, 50);
        button2.setBackground(Color.black);
        button2.setOpaque(false);
        button3.setBackground(Color.black);
        button3.setOpaque(false);

        // 添加事件
        addEvent();

        jPanel.add(jLabel3);
        jPanel.add(jLabel4);
        jPanel.add(jLabel5);
        jPanel.add(jLabel6);
        jPanel.add(jLabel7);
        jPanel.add(jLabel8);
        jPanel.add(jLabel9);
        jPanel.add(jLabel10);
        jPanel.add(button2);
        jPanel.add(button3);

        jPanel.setOpaque(false);

        // 加入分层窗口
        jLayeredPane.add(jLabel, new Integer(100), 0);
        jLayeredPane.add(jLabel2, new Integer(100), 1);
        jLayeredPane.add(field, new Integer(100), 2);
        jLayeredPane.add(button, new Integer(100), 3);
        jLayeredPane.add(jPanel, new Integer(100), 4);
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    private void addEvent() {
        // 添加检索按钮事件
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                try {
                    id = Integer.parseInt(field.getText().trim());
                    field.setText("");
                    Connection con = ConnectDatabase.connectDB();
                    PreparedStatement preSql;
                    ResultSet rs;
                    String sqlStr = "select * from booktable where bookid = ?";
                    try {
                        preSql = con.prepareStatement(sqlStr);
                        preSql.setInt(1, id);
                        rs = preSql.executeQuery();
                        boolean flag = false;
                        while (rs.next()) {
                            flag = true;
                            jLabel10.setText(rs.getString(1));
                            jLabel4.setText(rs.getString(3));
                            jLabel6.setText(rs.getString(4));
                            jLabel8.setText(rs.getString(6));
                        }
                        if (!flag) {
                            JOptionPane.showMessageDialog(null, "The Book is not exist!", "WARNING", JOptionPane.WARNING_MESSAGE);
                            empty();
                        }
                        con.close();
                    }
                    catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "InputError", "WARNING", JOptionPane.WARNING_MESSAGE);
                    field.setText("");
                }

            }
        });

        // 添加借阅按钮事件
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                if (jLabel8.getText().equals("在馆")) {
                    id = Integer.parseInt(jLabel10.getText().trim());
                    BorrowRecords.Borrow(user, id, jLabel4.getText().trim());
                    JOptionPane.showMessageDialog(null, "SuccessfullyBorrowed", "Congratulations", JOptionPane.WARNING_MESSAGE);
                    empty();
                    model.setRowCount(0);
                    FindBook.allbook(model);
                }
                else if (jLabel8.getText().equals("外借")) {
                    JOptionPane.showMessageDialog(null, "This Book is already Out!", "WARNING", JOptionPane.WARNING_MESSAGE);
                    empty();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect!", "WARNING", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // 添加还书按钮事件
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (jLabel8.getText().equals("外借")) {
                    if(BorrowRecords.comparison(user, id)) {
                        id = Integer.parseInt(jLabel10.getText().trim());
                        BorrowRecords.Return(user, id);
                        JOptionPane.showMessageDialog(null, "SuccessfullyReturned");
                        empty();
                        model.setRowCount(0);
                        FindBook.allbook(model);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "The Book Borrowed by OtherUser", "WARNING", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else if (jLabel8.getText().equals("在馆")) {
                    JOptionPane.showMessageDialog(null, "Book Available", "Congratulations", JOptionPane.WARNING_MESSAGE);
                    empty();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect!", "WARNING", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public void empty() {
        jLabel4.setText("");
        jLabel6.setText("");
        jLabel8.setText("");
        jLabel10.setText("");
    }

}
