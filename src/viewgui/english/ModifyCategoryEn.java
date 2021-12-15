package viewgui.english;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.Category;

/**
 * �޸�ͼ��������
 */
public class ModifyCategoryEn extends JFrame{

    // ���
    private JPanel jPanel = new JPanel();
    // ��ǩ
    private JLabel jLabel = new JLabel("Category��");
    private JLabel jLabel2 = new JLabel("ModifyAs��");
    // �ı���
    private JTextField field = new JTextField(22);
    private JTextField field2 = new JTextField(22);
    // ����
    private Font font2 = new Font("����", Font.BOLD, 22);
    private Font font3 = new Font("����", Font.BOLD, 18);
    // ��ť �޸�
    private JButton button = new JButton("Confirm");


    public ModifyCategoryEn() {
        setSize(400, 450);
        setTitle("ModifyCategory");

        jLabel.setFont(font2);
        field.setFont(font2);
        jLabel2.setFont(font2);
        field2.setFont(font2);
        button.setFont(font3);

        jLabel.setBounds(30, 150, 130, 30);
        field.setBounds(150, 150, 185, 28);
        jLabel2.setBounds(30, 210, 130, 30);
        field2.setBounds(150, 210, 185, 28);
        button.setBounds(47, 280, 288, 35);

        //����¼�
        addEvent();
        // �����Ըı䴰��Ĵ�С
        setResizable(false);
        jPanel.add(jLabel);
        jPanel.add(field);
        jPanel.add(jLabel2);
        jPanel.add(field2);
        jPanel.add(button);
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, 600, 400);
        jPanel.setOpaque(false);
        add(jPanel);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    private void addEvent() {

        // ���ȷ����ť�¼�
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String s = field.getText().trim();
                String s2 = field2.getText().trim();
                if(Category.setcategory(s,s2)) {
                    JOptionPane.showMessageDialog(null, "Done !");
                }
            }
        });
    }
}
