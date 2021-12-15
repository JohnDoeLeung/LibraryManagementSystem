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
import javax.swing.table.DefaultTableModel;

import database.Book;
import database.FindBook;

public class DeleteBookEn extends JFrame {
    // 面板
    private JPanel jPanel = new JPanel();
    // 标签
    private JLabel jLabel = new JLabel("ISBN：");
    private JLabel jLabel2 = new JLabel("Delete");
    // 文本框
    private JTextField field = new JTextField(22);
    // 字体
    private Font font2 = new Font("宋体", Font.BOLD, 24);
    private Font font3 = new Font("宋体", Font.BOLD, 18);
    private Font font4 = new Font("宋体", Font.BOLD, 40);
    // 按钮 修改
    private JButton button = new JButton("Confirm");

    // 表格 用于更新图书搜索界面的表格
    public DefaultTableModel model = new DefaultTableModel();

    public DeleteBookEn() {
        setSize(400, 450);
        setTitle("DeleteBook");

        jLabel.setFont(font2);
        field.setFont(font3);
        button.setFont(font3);
        jLabel2.setFont(font4);

        jLabel2.setBounds(120, 110, 200, 60);

        jLabel.setBounds(55, 210, 100, 30);
        field.setBounds(140, 210, 185, 28);

        button.setBounds(47, 300, 288, 35);

        // 添加事件
        addEvent();

        jPanel.add(jLabel2);
        jPanel.add(jLabel);
        jPanel.add(field);
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

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    private void addEvent() {

        // 添加确定按钮事件
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    int bookid = Integer.parseInt(field.getText().trim());
                    Book.deletebook(bookid);
                    model.setRowCount(0);
                    FindBook.allbook(model);
                    JOptionPane.showMessageDialog(null, "Done !");
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });
    }

}
