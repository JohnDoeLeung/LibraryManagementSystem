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
 * ����Ա�˻�����
 */
public class AdminEnglish {
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
    private JButton button2 = new JButton("ChangePassword");
    private JButton button3 = new JButton("BorrowRecord");
    private JButton button4 = new JButton("LoginOut");
    private JButton button5 = new JButton("Account");
    private JButton button6 = new JButton("ModifyPermission");
    private JButton button7 = new JButton("SetPassword");
    // ����
    private Font font = new Font("����", Font.BOLD, 60);
    private Font font1 = new Font("����", Font.BOLD, 25);
    private Font font2 = new Font("����", Font.BOLD, 23);
    private String user;
    private JFrame frame;

    public AdminEnglish() {
        // ��岼��Ϊ��
        jPanel2.setLayout(null);
        // ��ǩ
        jLabel.setFont(font);
        jLabel.setBounds(350, 50, 800, 70);
        // ��ť
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

        //����¼�
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
                new AdminBorrowEn();
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

        //�˻���Ϣ
        button5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new AdminAccountEn();
            }
        });

        //�޸�Ȩ��
        button6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new PermissionsEn();
            }
        });

        //�趨����
        button7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new AdminSetPassEn();
            }
        });
    }
}
