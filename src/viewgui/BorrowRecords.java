package viewgui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import database.ConnectDatabase;

/**
 * �û������¼����
 */
public class BorrowRecords extends JFrame {
	/*
	 * ���
	 */
	// ���
	private JPanel jPanel = new JPanel();
	// �ֲ㴰��
	private JLayeredPane jLayeredPane = new JLayeredPane();
	// ��ǩ
	private JLabel jLabel = new JLabel("�����¼");
	// ����
	private Font font = new Font("����", Font.BOLD, 40);
	// ���
	public DefaultTableModel model = new DefaultTableModel();

	public BorrowRecords(String user) {

		setLayout(null);
		setSize(800, 600);
		setLocationRelativeTo(null);

		jLabel.setFont(font);
		jLabel.setBounds(315, 80, 400, 100);

		jPanel.add(jLabel);
		// ���
		model.addColumn("���", new Vector<Integer>());
		model.addColumn("����", new Vector<Integer>());
		model.addColumn("��������", new Vector<Integer>());
		model.addColumn("��������", new Vector<Integer>());
		model.addColumn("״̬", new Vector<Integer>());
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

		borrow(model, user);

		jPanel.setBounds(0, 0, 800, 200);
		jPanel.setOpaque(false);
		jPanel.setLayout(null);
		setTitle("�����¼");
		// �����Ըı䴰��Ĵ�С
		setResizable(false);
		setContentPane(jLayeredPane);
		add(jPanel);
		setVisible(true);
	}

	private void borrow(DefaultTableModel model, String user) {
		Connection con = ConnectDatabase.connectDB();
		PreparedStatement preSql;
		ResultSet rs;
		String sqlStr = "select * from borrowrecords where user = ?";

		try {
			preSql = con.prepareStatement(sqlStr);
			preSql.setString(1, user);
			rs = preSql.executeQuery();
			boolean flag = false;
			while (rs.next()) {
				flag = true;
				int bookid = rs.getInt(3);
				String bookname = rs.getString(4);
				Date date = rs.getDate(5);
				Date date2 = rs.getDate(6);
				String state = rs.getString(7);
				model.addRow(new Vector<>(Arrays.asList(bookid, bookname, date, date2, state)));
			}
			if (!flag) {
				JOptionPane.showMessageDialog(null, "����û�н���Ŷ��");
			}
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
