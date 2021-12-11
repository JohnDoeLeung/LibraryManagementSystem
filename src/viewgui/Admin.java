package viewgui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ����Ա�˻�����
 */
public class Admin {
	/*
	 * ��ǩ
	 *
	 * �ĸ���ť �޸��˺� �޸����� �����¼ �˳�����
	 * 
	 */
	// ���
	public JPanel jPanel2 = new JPanel();
	// ��ǩ
	private JLabel jLabel = new JLabel("�˻�����");
	// ��ť
	private JButton button = new JButton("�޸���Ϣ");
	private JButton button2 = new JButton("�޸�����");
	private JButton button3 = new JButton("�����¼");
	private JButton button4 = new JButton("�˳���½");
	private JButton button5 = new JButton("�˻���Ϣ");
	private JButton button6 = new JButton("�޸�Ȩ��");
	private JButton button7 = new JButton("�趨����");
	// ����
	private Font font = new Font("����", Font.BOLD, 60);
	private Font font1 = new Font("����", Font.BOLD, 25);
	private String user;
	private JFrame frame;

	public Admin() {
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
		button6.setFont(font1);
		button7.setFont(font1);
		button.setBounds(150, 250, 250, 50);
		button2.setBounds(150, 310, 250, 50);
		button3.setBounds(150, 370, 250, 50);
		button4.setBounds(150, 430, 250, 50);
		button5.setBounds(420, 250, 250, 50);
		button6.setBounds(420, 310, 250, 50);
		button7.setBounds(420, 370, 250, 50);

		button.setBackground(Color.cyan);
		button2.setBackground(Color.cyan);
		button3.setBackground(Color.cyan);
		button4.setBackground(Color.cyan);
		button5.setBackground(Color.cyan);
		button6.setBackground(Color.cyan);
		button7.setBackground(Color.cyan);

		//����¼�
		add();
		
		button.setOpaque(false);
		button2.setOpaque(false);
		button3.setOpaque(false);
		button4.setOpaque(false);
		button5.setOpaque(false);
		button6.setOpaque(false);
		button7.setOpaque(false);

		jPanel2.add(button);
		jPanel2.add(button2);
		jPanel2.add(button3);
		jPanel2.add(button4);
		jPanel2.add(button5);
		jPanel2.add(button6);
		jPanel2.add(button7);
		jPanel2.add(jLabel);
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	// ����¼�
	private void add() {
		// �޸���Ϣ
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ModifyInformation(user);
			}
		});

		// �޸�����
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ModifyPassword password = new ModifyPassword(user);
				password.setFrame(frame);
			}
		});
		
		//�����¼
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminBorrow();
			}
		});
		
		//�˳���½
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new Land();
			}
		});
		
		//�˻���Ϣ
		button5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminAccount();
			}
		});
		
		//�޸�Ȩ��
		button6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Permissions();
			}
		});
		
		//�趨����
		button7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminSetPass();
			}
		});
	}
}
