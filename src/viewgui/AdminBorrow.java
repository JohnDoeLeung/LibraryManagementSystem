package viewgui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import database.FindBorrow;

/**
 * ����Ա�����¼ҳ��
 */
public class AdminBorrow extends JFrame {
	/*
	 *  ���
	 * 
	 * ������ �ı��� ��ť
	 */
	// ���
	private JPanel jPanel = new JPanel();
	// �ֲ㴰��
	private JLayeredPane jLayeredPane = new JLayeredPane();
	// ��ǩ
	private JLabel jLabel = new JLabel("�����¼");
	private JLabel jLabel2 = new JLabel("��ѡ���ѯ��ʽ��");
	// �ı���
	private JTextField field = new JTextField(20);
	// ������
	private JComboBox<String> box = new JComboBox<String>();
	// ��ť
	private JButton button = new JButton("����");
	// ����
	private Font font = new Font("����", Font.BOLD, 40);
	private Font font2 = new Font("����", Font.BOLD, 20);
	private Font font3 = new Font("����", Font.BOLD, 18);
	private Font font4 = new Font("����", Font.BOLD, 17);
	// ���
	public DefaultTableModel model = new DefaultTableModel();
	// �洢����ѡ��
	private String s;
	private int num;

	public AdminBorrow() {

		setLayout(null);
		setSize(850, 650);
		setLocationRelativeTo(null);

		jLabel.setFont(font);
		jLabel.setBounds(345, 80, 400, 100);

		jLabel2.setFont(font4);
		jLabel2.setBounds(95, 140, 250, 30);

		// ������
		box.addItem("�����û�������");
		box.addItem("������Ų���");
		box.setFont(font3);
		box.setBounds(95, 175, 160, 30);
		// box.setBackground(Color.cyan);
		box.setOpaque(false);

		// �ı���
		field.setFont(font2);
		field.setBackground(Color.cyan);
		field.setBounds(325, 175, 200, 30);
		field.setOpaque(false);

		// ��ť
		button.setFont(font2);
		button.setBounds(590, 173, 80, 35);
		button.setBackground(Color.cyan);
		button.setOpaque(false);

		jPanel.add(jLabel);
		jPanel.add(jLabel2);
		jPanel.add(box);
		jPanel.add(field);
		jPanel.add(button);
		// ���
		model.addColumn("�û���", new Vector<Integer>());
		model.addColumn("���", new Vector<Integer>());
		model.addColumn("����", new Vector<Integer>());
		model.addColumn("��������", new Vector<Integer>());
		model.addColumn("��������", new Vector<Integer>());
		model.addColumn("״̬", new Vector<Integer>());
		JTable jTable = new JTable(model);
		JScrollPane pane = new JScrollPane(jTable);
		pane.setBounds(80, 220, 690, 340);
		jLayeredPane.add(pane);

		// ���н����¼
		FindBorrow.allborrow(model);
		
		setTitle("�����¼");
		// �����Ըı䴰��Ĵ�С
		setResizable(false);
		// ����¼�
		addEvent();
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

		// jPanel.setBackground(Color.blue);
		jPanel.setBounds(0, 0, 850, 250);
		jPanel.setOpaque(false);
		jPanel.setLayout(null);
		setContentPane(jLayeredPane);
		add(jPanel);
		setVisible(true);
	}

	private void addEvent() {

		// ��ȡ�����б�ֵ
		s = "�����û�������";
		box.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					s = (String) e.getItem();
				}
			}
		});

		// ���������ť�¼�
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.setRowCount(0);
				if (s.equals("�����û�������")) {
					try {
						String user = field.getText().trim();
						FindBorrow.userborrow(model, user);
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				else if (s.equals("������Ų���")) {
					try {
						num = Integer.parseInt(field.getText().trim());
						FindBorrow.bookidborrow(model, num);
					}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				field.setText("");
			}
		});
	}
}
