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
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import database.FindBook;

/**
 * ͼ���ѯ����
 * */
public class BookSearch {
	/*
	 * һ�����ǩ
	 * 
	 * һ�������� һ���ı��� һ����ť
	 * 
	 * һ�����
	 */
	// �ֲ㴰��
	public JLayeredPane jLayeredPane = new JLayeredPane();
	// ��ǩ
	private JLabel jLabel = new JLabel("ͼ���ѯ");
	private JLabel jLabel2 = new JLabel("��ѡ���ѯ��ʽ��");
	// �ı���
	private JTextField field = new JTextField(25);
	// ��С
	private Dimension dimension = new Dimension(220, 30);
	// ������
	private JComboBox<String> box = new JComboBox<String>();
	// ��ť
	private JButton button = new JButton("����");
	// ���
	public DefaultTableModel model = new DefaultTableModel();
	// ����
	private Font font = new Font("����", Font.BOLD, 60);
	private Font font1 = new Font("����", Font.BOLD, 25);
	private Font font2 = new Font("����", Font.BOLD, 20);
	// �洢����ѡ��
	private String s;
	private String book;
	private int id;

	public BookSearch() {

		// ��ǩ
		jLabel.setFont(font);
		jLabel.setBounds(485, 35, 800, 100);
		jLabel.setForeground(Color.black);

		jLabel2.setFont(font1);
		jLabel2.setBounds(180, 130, 250, 30);
		jLabel2.setForeground(Color.black);

		// ������
		box.setSize(dimension);
		box.addItem("����������");
		box.addItem("������������");
		box.addItem("�������߲���");
		box.addItem("������Ų���");
		box.setFont(font2);
		box.setBounds(180, 170, 200, 40);
		box.setBackground(Color.white);
		box.setOpaque(false);

		// �ı���
		field.setFont(font2);
		field.setSize(dimension);
		field.setBackground(Color.black);
		field.setBounds(480, 173, 250, 35);
		field.setForeground(Color.black);
		field.setOpaque(false);

		// ��ť
		button.setFont(font1);
		button.setBounds(850, 170, 100, 40);
		button.setForeground(Color.black);
		button.setBackground(Color.cyan);
		button.setOpaque(false);

		// ���
		model.addColumn("���", new Vector<Integer>());
		model.addColumn("���", new Vector<Integer>());
		model.addColumn("����", new Vector<Integer>());
		model.addColumn("����", new Vector<Integer>());
		model.addColumn("������", new Vector<Integer>());
		model.addColumn("״̬", new Vector<Integer>());
		JTable jTable = new JTable(model);

		JScrollPane pane = new JScrollPane(jTable);
		pane.setBounds(180, 250, 800, 400);

//	for(int k = 0; k < 30; k++) {
//		model.addRow(new Vector<Integer>());
//	}
		FindBook.allbook(model);

		JTableHeader head = jTable.getTableHeader();
		// ���ñ�ͷ�Ĵ�С
		head.setPreferredSize(new Dimension(head.getWidth(), 30));
		// ���ñ�ͷ�����С
		head.setFont(new Font("����", Font.BOLD, 20));
		head.setForeground(Color.darkGray);
		head.setBackground(Color.yellow);
		// ���ñ����п�
		jTable.setRowHeight(30);
		// ���ñ�����������С
		jTable.setFont(new Font("����", Font.ROMAN_BASELINE, 17));
		/* ���ñ���е����ݾ��� */
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		jTable.setDefaultRenderer(Object.class, renderer);
		
		//����¼�
		addEvent();
		
		// ����ֲ㴰��
		jLayeredPane.add(jLabel, new Integer(100), 0);
		jLayeredPane.add(jLabel2, new Integer(100), 1);
		jLayeredPane.add(box, new Integer(100), 2);
		jLayeredPane.add(field, new Integer(100), 3);
		jLayeredPane.add(button, new Integer(100), 4);
		jLayeredPane.add(pane, new Integer(100), 5);
	}

	private void addEvent() {
		
		//��ȡ�����б�ֵ
		s = "����������";
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
				model.setRowCount(0);
				if(s.equals("����������")) {
					book=field.getText().trim();
					FindBook.findcategory(model, book);
				}
				else if(s.equals("������������")) {
					book=field.getText().trim();
					FindBook.findbookname(model, book);
				}
				else if(s.equals("�������߲���")) {
					book=field.getText().trim();
					FindBook.findauthor(model, book);
				}
				else if(s.equals("������Ų���")) {
					try {
						id= Integer.parseInt(field.getText().trim());
						FindBook.findbookid(model, id);
					}
					catch(Exception e1) {
						e1.printStackTrace();
					}
				}
				field.setText("");
			}
		});
	}
}
