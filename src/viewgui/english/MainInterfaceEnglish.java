package viewgui.english;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import database.Landing;

/**
 * 主界面
 */

public class MainInterfaceEnglish extends JFrame{
    /*
     * 选项卡     主界面       图书查询          图书借还       账号管理
     *
     * */
    //选项卡
    public  JTabbedPane jTabbedPane = new JTabbedPane();
    //主界面面板
    private JPanel jPanel = new JPanel();
    //标签
    private JLabel jLabel = new JLabel("Welcomes!");
    // 字体
    private Font font = new Font("宋体", Font.BOLD, 70);
    private Font font2 = new Font("宋体", Font.BOLD, 20);

    private Container con = getContentPane();
    public MainInterfaceEnglish(String user) {

        jPanel.setLayout(null);
        jLabel.setFont(font);

        jLabel.setBounds(230, 50, 1000,200);
        jLabel.setForeground(Color.blue);
        jPanel.add(jLabel);

        jTabbedPane.setFont(font2);
        jTabbedPane.add("MainUI", jPanel);
        BookSearchEnglish search = new BookSearchEnglish();
        jTabbedPane.add("BookSearch",search.jLayeredPane);

        BorrowingReturningEnglish returning = new BorrowingReturningEnglish();
        returning.setUser(user);
        returning.setModel(search.model);
        jTabbedPane.add("BorrowAndReturn", returning.jLayeredPane);

        if(Landing.sureadmin(user)) {
            AdminEnglish admin = new AdminEnglish();
            admin.setUser(user);
            admin.setFrame(this);
            jTabbedPane.add("AccountManagement", admin.jPanel2);

            BookAdminEnglish bookAdmin = new BookAdminEnglish();
            bookAdmin.setModel(search.model);
            jTabbedPane.add("BookAdmin",bookAdmin.jPanel2);

        }
        else {
            AccountManagementEn management = new AccountManagementEn();
            management.setUser(user);
            management.setFrame(this);
            jTabbedPane.add("AccountManagement", management.jPanel2);
        }

        con.add(jTabbedPane);
        // 可以改变窗体的大小
        setResizable(true);
        setTitle("LibraryManagementSystem");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
