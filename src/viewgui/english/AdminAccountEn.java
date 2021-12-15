package viewgui.english;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import database.ConnectDatabase;

/**
 * �˻���Ϣ����
 *
 */
public class AdminAccountEn extends JFrame {
    /*
     *  ���
     */
    // ���
    private JPanel jPanel = new JPanel();
    // �ֲ㴰��
    private JLayeredPane jLayeredPane = new JLayeredPane();
    // ��ǩ
    private JLabel jLabel = new JLabel("AccountInfo");
    // ����
    private Font font = new Font("����", Font.BOLD, 40);
    // ���
    public DefaultTableModel model = new DefaultTableModel();

    public AdminAccountEn() {

        setLayout(null);
        setSize(800, 600);
        setLocationRelativeTo(null);

        jLabel.setFont(font);
        jLabel.setBounds(315, 80, 400, 100);

        jPanel.add(jLabel);
        // ���
        model.addColumn("Username", new Vector<Integer>());
        model.addColumn("ID", new Vector<Integer>());
        model.addColumn("Name", new Vector<Integer>());
        model.addColumn("Librarian", new Vector<Integer>());
        JTable jTable = new JTable(model);
        JScrollPane pane = new JScrollPane(jTable);
        pane.setBounds(80, 160, 640, 350);
        jLayeredPane.add(pane);

        JTableHeader head = jTable.getTableHeader();
        // ���ñ�ͷ�Ĵ�С
        head.setPreferredSize(new Dimension(head.getWidth(), 30));
        // ���ñ�ͷ�����С
        head.setFont(new Font("����", Font.BOLD, 20));
        // head.setForeground(Color.cyan);
        head.setBackground(Color.cyan);
        // ���ñ����п�
        jTable.setRowHeight(30);
        // ���ñ�����������С
        jTable.setFont(new Font("����", Font.ROMAN_BASELINE, 17));
        /* ���ñ���е����ݾ��� */
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        jTable.setDefaultRenderer(Object.class, renderer);

        borrow(model);

        jPanel.setBounds(0, 0, 800, 200);
        jPanel.setOpaque(false);
        jPanel.setLayout(null);
        setContentPane(jLayeredPane);
        setTitle("AccountInfo");
        // �����Ըı䴰��Ĵ�С
        setResizable(false);
        add(jPanel);
        setVisible(true);
    }

    private void borrow(DefaultTableModel model) {

        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        ResultSet rs;
        String sqlStr = "select * from usertable";

        try {
            preSql = con.prepareStatement(sqlStr);
            rs = preSql.executeQuery();
            while (rs.next()) {
                String user = rs.getString(1);
                String studentid = rs.getString(2);
                String name = rs.getString(3);
                int flag = rs.getInt(5);
                String admin;
                if (flag == 1) {
                    admin = "��";
                }
                else {
                    admin = "��";
                }
                model.addRow(new Vector<>(Arrays.asList(user, studentid, name, admin)));
            }
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
