package viewgui.english;
/**
 * �û��˻��������
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountManagementEn {
    /*
     * ��ǩ
     *
     * �ĸ���ť �޸��˺� �޸����� �����¼ �˳�����
     *
     */
    // ���
    public JPanel jPanel2 = new JPanel();
    // ��ǩ
    private JLabel jLabel = new JLabel("AccountManagement");
    // ��ť
    private JButton button = new JButton("ModifyInfo");
    private JButton button2 = new JButton("ModifyPassword");
    private JButton button3 = new JButton("BorrowRecords");
    private JButton button4 = new JButton("LoginOut");
    // ����
    private Font font = new Font("����", Font.BOLD, 60);
    private Font font1 = new Font("����", Font.BOLD, 25);

    private String user;
    private JFrame frame;

    public AccountManagementEn() {

        jPanel2.setLayout(null);
        // ��ǩ
        jLabel.setFont(font);
        jLabel.setBounds(460, 50, 800, 70);
        // ��ť
        button.setFont(font1);
        button2.setFont(font1);
        button3.setFont(font1);
        button4.setFont(font1);
        button.setBounds(150, 250, 250, 50);
        button2.setBounds(150, 310, 250, 50);
        button3.setBounds(150, 370, 250, 50);
        button4.setBounds(150, 430, 250, 50);

        button.setBackground(Color.cyan);
        button2.setBackground(Color.cyan);
        button3.setBackground(Color.cyan);
        button4.setBackground(Color.cyan);

        button.setOpaque(false);
        button2.setOpaque(false);
        button3.setOpaque(false);
        button4.setOpaque(false);
        // ����¼�
        add();
        jPanel2.add(button);
        jPanel2.add(button2);
        jPanel2.add(button3);
        jPanel2.add(button4);
        jPanel2.add(jLabel);
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    // ����¼�
    private void add() {
        // �޸���Ϣ
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new ModifyInformationEnglish(user);
            }
        });

        // �޸�����
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                ModifyPasswordEnglish password = new ModifyPasswordEnglish(user);
                password.setFrame(frame);
            }
        });

        //�����¼
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new BorrowRecordsEn(user);
            }
        });

        //�˳���½
        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                frame.dispose();
                new LandEnglish();
            }
        });
    }

}
