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
 * 修改图书类别界面
 */
public class ModifyCategoryEn extends JFrame{

    // 面板
    private JPanel jPanel = new JPanel();
    // 标签
    private JLabel jLabel = new JLabel("Category：");
    private JLabel jLabel2 = new JLabel("ModifyAs：");
    // 文本框
    private JTextField field = new JTextField(22);
    private JTextField field2 = new JTextField(22);
    // 字体
    private Font font2 = new Font("宋体", Font.BOLD, 22);
    private Font font3 = new Font("宋体", Font.BOLD, 18);
    // 按钮 修改
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

        //添加事件
        addEvent();
        // 不可以改变窗体的大小
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

        // 添加确定按钮事件
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
