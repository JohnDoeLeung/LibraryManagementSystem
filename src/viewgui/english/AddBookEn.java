package viewgui.english;

import java.awt.Color;
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
import javax.swing.table.DefaultTableModel;

import database.Book;
import database.FindBook;
/**
 * ���ͼ�����
 */
public class AddBookEn extends JFrame{

    // ���
    private JPanel jPanel = new JPanel();
    // ��ǩ
    private JLabel jLabel = new JLabel("AddBook");
    private JLabel jLabel2 = new JLabel("Category��");
    private JLabel jLabel3 = new JLabel("TitleName��");
    private JLabel jLabel4 = new JLabel("Author��");
    private JLabel jLabel5 = new JLabel("Publisher��");
    // �ı���
    private JTextField field = new JTextField(20);
    private JTextField field2 = new JTextField(20);
    private JTextField field3 = new JTextField(20);
    // ������
    private JComboBox<String> box = new JComboBox<String>();
    // ��ť
    private JButton button = new JButton("Confirm");
    // ����
    private Font font = new Font("����", Font.BOLD, 40);
    private Font font2 = new Font("����", Font.BOLD, 25);
    private Font font3 = new Font("����", Font.BOLD, 20);
    // ���   ���ڸ���ͼ����������ı��
    public DefaultTableModel model = new DefaultTableModel();

    private String s;

    public AddBookEn() {

        setLayout(null);
        setSize(580, 650);
        setTitle("AddBook");
        setLocationRelativeTo(null);

        jLabel.setFont(font);
        jLabel.setBounds(195, 80, 400, 100);

        jLabel2.setFont(font2);
        jLabel2.setBounds(105, 200, 250, 30);

        jLabel3.setFont(font2);
        jLabel3.setBounds(105, 260, 250, 30);

        jLabel4.setFont(font2);
        jLabel4.setBounds(125, 320, 250, 30);

        jLabel5.setFont(font2);
        jLabel5.setBounds(105, 380, 250, 30);
        // ������
        box.addItem("SelectCategory");
        Book.findcategory(box);
        box.setFont(font3);
        box.setBounds(245, 200, 200, 30);
        // box.setBackground(Color.cyan);
        box.setOpaque(false);

        // �ı���
        field.setFont(font3);
        field.setBackground(Color.cyan);
        field.setBounds(245, 260, 200, 30);
        field.setOpaque(false);

        field2.setFont(font3);
        field2.setBackground(Color.cyan);
        field2.setBounds(245, 320, 200, 30);
        field2.setOpaque(false);

        field3.setFont(font3);
        field3.setBackground(Color.cyan);
        field3.setBounds(245, 380, 200, 30);
        field3.setOpaque(false);

        // ��ť
        button.setFont(font2);
        button.setBounds(120, 455, 325, 35);
        button.setBackground(Color.cyan);
        button.setOpaque(false);

        jPanel.add(jLabel);
        jPanel.add(jLabel2);
        jPanel.add(jLabel3);
        jPanel.add(jLabel4);
        jPanel.add(jLabel5);
        jPanel.add(box);
        jPanel.add(field);
        jPanel.add(field2);
        jPanel.add(field3);
        jPanel.add(button);

        add();

        // jPanel.setBackground(Color.blue);
        jPanel.setBounds(0, 0, 850, 650);
        jPanel.setOpaque(false);
        jPanel.setLayout(null);
        add(jPanel);
        // �����Ըı䴰��Ĵ�С
        setResizable(false);
        setVisible(true);
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    private void add() {
        //��ȡ�����б�ֵ
        s = "��ѡ�����";
        box.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                if(e.getStateChange()==ItemEvent.SELECTED) {
                    s=(String)e.getItem();
                }
            }
        });

        //���������ť�¼�
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String bookname = field.getText().trim();
                String author = field2.getText().trim();
                String press = field3.getText().trim();
                Book.addbook(s, bookname, author, press);
                model.setRowCount(0);
                FindBook.allbook(model);
                JOptionPane.showMessageDialog(null, "Successfully ADD!");
            }
        });

    }
}
