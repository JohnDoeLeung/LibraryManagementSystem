package viewgui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * ͼ���������
 */
public class BookAdmin {
	/*
	 * ��ǩ
	 *
	 * �����ť ����ͼ����Ϣ �޸�ͼ����Ϣ ɾ��ͼ����Ϣ ����ͼ����� �޸�ͼ�����
	 * 
	 */
	// ���
	public JPanel jPanel2 = new JPanel();
	// ��ǩ
	private JLabel jLabel = new JLabel("ͼ�����");
	// ��ť
	private JButton button = new JButton("����ͼ����Ϣ");
	private JButton button2 = new JButton("�޸�ͼ����Ϣ");
	private JButton button3 = new JButton("ɾ��ͼ����Ϣ");
	private JButton button4 = new JButton("����ͼ�����");
	private JButton button5 = new JButton("�޸�ͼ�����");
	// ����
	private Font font = new Font("����", Font.BOLD, 60);
	private Font font1 = new Font("����", Font.BOLD, 25);
	// ���� ���ڸ���ͼ����������ı���
	public DefaultTableModel model = new DefaultTableModel();

	public BookAdmin() {
		// ��岼��Ϊ��
		jPanel2.setLayout(null);
		// ��ǩ
		jLabel.setFont(font);
		jLabel.setBounds(460, 50, 800, 70);
		// ��ť
		button.setFont(font1);
		button2.setFont(font1);
		button3.setFont(font1);
		button4.setFont(font1);
		button5.setFont(font1);
		button.setBounds(150, 190, 250, 50);
		button2.setBounds(150, 250, 250, 50);
		button3.setBounds(150, 310, 250, 50);
		button4.setBounds(150, 370, 250, 50);
		button5.setBounds(150, 430, 250, 50);

		button.setBackground(Color.cyan);
		button2.setBackground(Color.cyan);
		button3.setBackground(Color.cyan);
		button4.setBackground(Color.cyan);
		button5.setBackground(Color.cyan);

		button.setOpaque(false);
		button2.setOpaque(false);
		button3.setOpaque(false);
		button4.setOpaque(false);
		button5.setOpaque(false);
		
		//�����¼�
		add();
		
		jPanel2.add(button);
		jPanel2.add(button2);
		jPanel2.add(button3);
		jPanel2.add(button4);
		jPanel2.add(button5);
		jPanel2.add(jLabel);
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	
	// �����¼�
	private void add() {
		// ����ͼ����Ϣ
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddBook addBook = new AddBook();
				addBook.setModel(model);
			}
		});

		// �޸�ͼ����Ϣ
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ModifyBook modifyBook = new ModifyBook();
				modifyBook.setModel(model);
			}
		});

		// ɾ��ͼ����Ϣ
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteBook deleteBook = new DeleteBook();
				deleteBook.setModel(model);
			}
		});

		// ����ͼ�����
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddCategory();
			}
		});

		// �޸�ͼ�����
		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ModifyCategory();
			}
		});

	}
}