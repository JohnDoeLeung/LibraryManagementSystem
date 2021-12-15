package viewgui.english;

import viewgui.english.AdminSetPassEn;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 管理员账户界面
 */
public class AdminEnglish {
    /*
     * 标签
     *
     * 四个按钮 修改账号 修改密码 借书记录 退出程序
     *
     */
    // 面板
    public JPanel jPanel2 = new JPanel();
    // 标签
    private JLabel jLabel = new JLabel("AccountManagement");
    // 按钮
    private JButton button = new JButton("ModifyInfo");
    private JButton button2 = new JButton("ChangePassword");
    private JButton button3 = new JButton("BorrowRecord");
    private JButton button4 = new JButton("LoginOut");
    private JButton button5 = new JButton("Account");
    private JButton button6 = new JButton("ModifyPermission");
    private JButton button7 = new JButton("SetPassword");
    // 字体
    private Font font = new Font("宋体", Font.BOLD, 60);
    private Font font1 = new Font("宋体", Font.BOLD, 25);
    private Font font2 = new Font("宋体", Font.BOLD, 23);
    private String user;
    private JFrame frame;

    public AdminEnglish() {
        // 面板布局为空
        jPanel2.setLayout(null);
        // 标签
        jLabel.setFont(font);
        jLabel.setBounds(350, 50, 800, 70);
        // 按钮
        button.setFont(font1);
        button2.setFont(font1);
        button3.setFont(font1);
        button4.setFont(font1);
        button5.setFont(font1);
        button6.setFont(font2);
        button7.setFont(font1);
        button.setBounds(150, 250, 250, 50);
        button2.setBounds(150, 310, 250, 50);
        button3.setBounds(150, 370, 250, 50);
        button4.setBounds(150, 430, 250, 50);
        button5.setBounds(420, 250, 250, 50);
        button6.setBounds(420, 310, 250, 50);
        button7.setBounds(420, 370, 250, 50);

        button.setBackground(Color.cyan);
        button2.setBackground(Color.cyan);
        button3.setBackground(Color.cyan);
        button4.setBackground(Color.cyan);
        button5.setBackground(Color.cyan);
        button6.setBackground(Color.cyan);
        button7.setBackground(Color.cyan);

        //添加事件
        add();

        button.setOpaque(false);
        button2.setOpaque(false);
        button3.setOpaque(false);
        button4.setOpaque(false);
        button5.setOpaque(false);
        button6.setOpaque(false);
        button7.setOpaque(false);

        jPanel2.add(button);
        jPanel2.add(button2);
        jPanel2.add(button3);
        jPanel2.add(button4);
        jPanel2.add(button5);
        jPanel2.add(button6);
        jPanel2.add(button7);
        jPanel2.add(jLabel);
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    // 添加事件
    private void add() {
        // 修改信息
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new ModifyInformationEnglish(user);
            }
        });

        // 修改密码
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                ModifyPasswordEnglish password = new ModifyPasswordEnglish(user);
                password.setFrame(frame);
            }
        });

        //借书记录
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new AdminBorrowEn();
            }
        });

        //退出登陆
        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                frame.dispose();
                new LandEnglish();
            }
        });

        //账户信息
        button5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new AdminAccountEn();
            }
        });

        //修改权限
        button6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new PermissionsEn();
            }
        });

        //设定密码
        button7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new AdminSetPassEn();
            }
        });
    }
}
