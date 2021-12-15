package viewgui.english;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import database.ConnectDatabase;

/**
 * 修改密码界面
 */
public class ModifyPasswordEnglish extends JFrame {
    /*
     * 两个标签 用户名 一标签 一文本框 旧密码 一标签 一文本框 新密码 一标签 一文本框 确认密码
     */
    // 面板
    private JPanel jPanel = new JPanel();
    // 标签
    private JLabel jLabel = new JLabel("Username:");
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel("OldPassword：");
    private JLabel jLabel4 = new JLabel("NewPassword：");
    private JLabel jLabel5 = new JLabel("Confirm：");
    // 文本框
    private JPasswordField field = new JPasswordField(22);
    private JPasswordField field2 = new JPasswordField(22);
    private JPasswordField field3 = new JPasswordField(22);
    // 字体
    private Font font = new Font("宋体", Font.BOLD, 24);
    private Font font1 = new Font("宋体", Font.BOLD, 22);
    // 按钮 修改
    private JButton button = new JButton("Modify");
    private JFrame frame = new JFrame();

    public ModifyPasswordEnglish(String user) {
        setSize(600, 450);

        setTitle("ChangePassword");
        jLabel2.setText(user);
        jLabel.setFont(font);
        jLabel2.setFont(font);
        jLabel3.setFont(font);
        jLabel4.setFont(font);
        jLabel5.setFont(font);
        field.setFont(font1);
        field2.setFont(font1);
        field3.setFont(font1);
        button.setFont(font1);

        add();

        jLabel.setBounds(120, 170, 150, 30);
        jLabel2.setBounds(260, 170, 300, 30);
        jLabel3.setBounds(100, 210, 180, 30);
        field.setBounds(260, 215, 140, 25);
        jLabel4.setBounds(100, 250, 180, 30);
        field2.setBounds(260, 255, 140, 25);
        jLabel5.setBounds(120, 290, 150, 30);
        field3.setBounds(260, 295, 140, 25);
        button.setBounds(115, 340, 285, 30);

        jPanel.add(jLabel);
        jPanel.add(jLabel2);
        jPanel.add(jLabel3);
        jPanel.add(field);
        jPanel.add(jLabel4);
        jPanel.add(field2);
        jPanel.add(jLabel5);
        jPanel.add(field3);
        jPanel.add(button);
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, 600, 400);
        jPanel.setOpaque(false);
        add(jPanel);
        // 不可以改变窗体的大小
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    // 比对旧密码
    private boolean comparison(String user, String password) {

        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        ResultSet rs;
        String sqlStr = "select * from usertable where user = ?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, user);
            rs = preSql.executeQuery();
            while (rs.next()) {
                String s = rs.getString(4);

                if (s.equals(password)) {
                    return true;
                }
                else {
                    return false;
                }
            }
            con.close();
            return false;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // 添加事件
    private void add() {
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String user = jLabel2.getText().trim();
                String oldpass = field.getText().trim();
                String newpass = field2.getText().trim();
                String surepass = field3.getText().trim();
                if (comparison(user, oldpass)) {
                    if(newpass.length()<6||newpass.length()>16) {
                        JOptionPane.showMessageDialog(null, "Password length: 6~16 digits, no spaces", "WARNING", JOptionPane.WARNING_MESSAGE);
                        empty();
                    }
                    else {
                        if (newpass.equals(surepass)) {
                            database.ModifyPassword.modifypass(user, newpass);
                            JOptionPane.showMessageDialog(null, "Done !");

                            JOptionPane.showMessageDialog(null, "Please log in again !");
                            dispose();
                            frame.dispose();
                            new LandEnglish();
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "The two passwords are not the same !   ", "WARNING", JOptionPane.WARNING_MESSAGE);
                            empty();
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Original password is incorrect !", "WARNING", JOptionPane.WARNING_MESSAGE);
                    empty();
                }

            }
        });
    }

    private void empty() {
        field.setText("");
        field2.setText("");
        field3.setText("");
    }
}
