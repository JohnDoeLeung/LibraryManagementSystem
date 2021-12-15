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
 * ������
 */

public class MainInterfaceEnglish extends JFrame{
    /*
     * ѡ�     ������       ͼ���ѯ          ͼ��軹       �˺Ź���
     *
     * */
    //ѡ�
    public  JTabbedPane jTabbedPane = new JTabbedPane();
    //���������
    private JPanel jPanel = new JPanel();
    //��ǩ
    private JLabel jLabel = new JLabel("Welcomes!");
    // ����
    private Font font = new Font("����", Font.BOLD, 70);
    private Font font2 = new Font("����", Font.BOLD, 20);

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
        // ���Ըı䴰��Ĵ�С
        setResizable(true);
        setTitle("LibraryManagementSystem");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
