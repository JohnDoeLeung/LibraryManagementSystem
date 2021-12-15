package viewgui.english;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.UpdateAdmin;

/**
 * �޸�Ȩ�޽���
 */
public class PermissionsEn extends JFrame {

    // ���
    private JPanel jPanel = new JPanel();
    // ��ǩ
    private JLabel jLabel = new JLabel("User:");
    private JLabel jLabel2 = new JLabel("Option:");
    // �ı���
    private JTextField field = new JTextField(22);
    // ������
    private JComboBox<String> box = new JComboBox<String>();
    // ����
    private Font font2 = new Font("����", Font.BOLD, 22);
    private Font font3 = new Font("����", Font.BOLD, 18);
    // ��ť �޸�
    private JButton button = new JButton("Confirm");

    private String s;

    public PermissionsEn() {
        setSize(400, 450);
        setTitle("ModifyPermission");

        jLabel.setFont(font2);
        jLabel2.setFont(font2);
        field.setFont(font2);
        button.setFont(font3);

        jLabel.setBounds(50, 150, 100, 30);
        field.setBounds(150, 150, 185, 28);

        jLabel2.setBounds(50, 225, 100, 30);

        button.setBounds(47, 300, 288, 35);
        // ������
        box.addItem("DeleteUser");
        box.addItem("ModifyAsUser");
        box.addItem("AddAsAdmin");
        box.setFont(font3);
        box.setBounds(150, 225, 185, 28);
        // box.setBackground(Color.cyan);
        box.setOpaque(false);

        //����¼�
        addEvent();

        jPanel.add(jLabel);
        jPanel.add(field);
        jPanel.add(jLabel2);
        jPanel.add(box);
        jPanel.add(button);
        jPanel.setLayout(null);
        jPanel.setBounds(0, 0, 600, 400);
        jPanel.setOpaque(false);
        add(jPanel);
        // �����Ըı䴰��Ĵ�С
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    private void addEvent() {

        // ��ȡ�����б�ֵ
        s = "ɾ���û�";
        box.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    s = (String) e.getItem();
                }
            }
        });

        // ���ȷ����ť�¼�
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String user = field.getText().trim();
                if(UpdateAdmin.sureuser(user)) {
                    if (s.equals("ɾ���û�")) {
                        UpdateAdmin.deleteuser(user);
                        JOptionPane.showMessageDialog(null, "Done !");
                    }
                    else if (s.equals("����Ϊ�û�")) {
                        UpdateAdmin.updateuser(user);
                        JOptionPane.showMessageDialog(null, "Done !");
                    }
                    else if(s.equals("���Ϊ����Ա")) {
                        UpdateAdmin.updateadmin(user);
                        JOptionPane.showMessageDialog(null, "Done !");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "User Not Exist !", "WARNING", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

}
