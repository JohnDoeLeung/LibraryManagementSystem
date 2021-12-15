package viewgui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.Adduser;

/**
 * ע�����
 */
public class Register {

	/*
	 * �߸���ǩ ������ı��� һ����ť �߸����
	 */
	// ��ǩ
	private JLabel jLabel = new JLabel("ע ��");
	private JLabel jLabel2 = new JLabel("�� �� ����");
	private JLabel jLabel3 = new JLabel(" ѧ  �ţ�");
	private JLabel jLabel4 = new JLabel(" ��  ����");
	private JLabel jLabel5 = new JLabel(" ��  �룺");
	private JLabel jLabel6 = new JLabel("ȷ������:");
	private JLabel jLabel7 = new JLabel("                                       ���볤�ȣ�6~16λ�����ܺ��пո� ");

	private String user;
	private String studentid;
	private String name;
	private String password;
	private String password2;
	// ����
	private Font font = new Font("����", Font.BOLD, 40);
	private Font font2 = new Font("����", Font.BOLD, 25);
	private Font font3 = new Font("����", Font.BOLD, 20);
	private Font font4 = new Font("С׭", Font.ITALIC, 13);
	private Font font5 = new Font("����", Font.BOLD, 17);
	// �ı���
	private JTextField field = new JTextField(18);
	private JTextField field2 = new JTextField(18);
	private JTextField field3 = new JTextField(18);
	private JPasswordField field4 = new JPasswordField(18);
	private JPasswordField field5 = new JPasswordField(18);

	// ��ť
	private JButton button = new JButton("ע ��");
	private JButton button2 = new JButton("����");
	// ��С
	private Dimension dimension = new Dimension(350, 40);
	// ���
	private JPanel jPanel = new JPanel();
	private JPanel jPanel2 = new JPanel();
	private JPanel jPanel3 = new JPanel();
	private JPanel jPanel4 = new JPanel();
	private JPanel jPanel5 = new JPanel();
	private JPanel jPanel6 = new JPanel();
	private JPanel jPanel7 = new JPanel();

	// ����
	private JFrame frame = new JFrame("ע��");

	public Register() {
		// �����С
		frame.setSize(450, 600);
		// ����Ϊ��
		frame.setLayout(null);
		// ����
		frame.setLocationRelativeTo(null);

		addassembly();
		transparent();
		addEvent();

		// ���ɸı��С
		frame.setResizable(false);
		// ���ڹر�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ڿɼ�
		frame.setVisible(true);
	}

	private void addassembly() {
		// �������
		jLabel.setFont(font);
		jLabel2.setFont(font2);
		jLabel3.setFont(font2);
		jLabel4.setFont(font2);
		jLabel5.setFont(font2);
		jLabel6.setFont(font2);
		jLabel7.setFont(font4);
		jLabel7.setForeground(Color.red);
		
		jLabel.setBounds(170, 30, 150, 60);
		button.setFont(font2);
		field.setFont(font3);
		field2.setFont(font3);
		field3.setFont(font3);
		field4.setFont(font3);
		field5.setFont(font3);
		field.setForeground(Color.blue);
		field2.setForeground(Color.blue);
		field3.setForeground(Color.blue);
		field4.setForeground(Color.blue);
		field5.setForeground(Color.blue);
		// ��ť���ô�С
		button.setPreferredSize(dimension);
		button2.setFont(font5);
		button2.setBounds(2, 2, 70, 30);
		button2.setBackground(Color.cyan);
		button2.setOpaque(false);
		// �������
		jPanel.add(button2);
		jPanel.add(jLabel);
		jPanel2.add(jLabel2);
		jPanel2.add(field);
		jPanel3.add(jLabel3);
		jPanel3.add(field2);
		jPanel4.add(jLabel4);
		jPanel4.add(field3);
		jPanel5.add(jLabel5);
		jPanel5.add(field4);
		jPanel5.add(jLabel7);
		jPanel6.add(jLabel6);
		jPanel6.add(field5);
		jPanel7.add(button);
		jPanel.setLayout(null);
		// ���λ��
		jPanel.setBounds(0, 0, 450, 110);
		jPanel2.setBounds(0, 110, 450, 50);
		jPanel3.setBounds(0, 180, 450, 50);
		jPanel4.setBounds(0, 250, 450, 50);
		jPanel5.setBounds(0, 320, 450, 70);
		jPanel6.setBounds(0, 390, 450, 50);
		jPanel7.setBounds(0, 460, 450, 60);
		// ��ӵ�����
		frame.add(jPanel);
		frame.add(jPanel2);
		frame.add(jPanel3);
		frame.add(jPanel4);
		frame.add(jPanel5);
		frame.add(jPanel6);
		frame.add(jPanel7);
	}

	private void transparent() {
		// ��ǩ͸��
		jLabel.setOpaque(false);
		jLabel2.setOpaque(false);
		jLabel3.setOpaque(false);
		jLabel4.setOpaque(false);
		jLabel5.setOpaque(false);
		jLabel6.setOpaque(false);
		// �ı���͸��
		field.setOpaque(false);
		field2.setOpaque(false);
		field3.setOpaque(false);
		field4.setOpaque(false);
		field5.setOpaque(false);
		// ���͸��
		jPanel.setOpaque(false);
		jPanel2.setOpaque(false);
		jPanel3.setOpaque(false);
		jPanel4.setOpaque(false);
		jPanel5.setOpaque(false);
		jPanel6.setOpaque(false);
		jPanel6.setOpaque(false);
		jPanel7.setOpaque(false);
	}

	private void addEvent() {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				user = field.getText().trim();
				studentid = field2.getText().trim();
				name = field3.getText().trim();
				password = field4.getText().trim();
				password2 = field5.getText().trim();
				if (user.length() == 0) {
					JOptionPane.showMessageDialog(null, "�û�������Ϊ��", "����", JOptionPane.WARNING_MESSAGE);
					empty();
				}
				else if (studentid.length() == 0) {
					JOptionPane.showMessageDialog(null, "ѧ�Ų���Ϊ��", "����", JOptionPane.WARNING_MESSAGE);
					empty();
				}
				else if (name.length() == 0) {
					JOptionPane.showMessageDialog(null, "��������Ϊ��", "����", JOptionPane.WARNING_MESSAGE);
					empty();
				}
				else if (password.length() < 6 || password.length() > 12) {
					JOptionPane.showMessageDialog(null, "�������벻��ȷ", "����", JOptionPane.WARNING_MESSAGE);
					empty();
				}
				else if (!(password.equals(password2))) {
					JOptionPane.showMessageDialog(null, "�����������벻��ͬ", "����", JOptionPane.WARNING_MESSAGE);
					empty();
				}
				else {
					if (Adduser.adduser(user, studentid, name, password)) {
						JOptionPane.showMessageDialog(null, "ע��ɹ�");
						//frame.setVisible(false);
						frame.dispose();
						new Land();
					}
					else {
						empty();
					}

				}
			}
		});
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new Land();
			}
		});
	}

	private void empty() {
		field.setText("");
		field2.setText("");
		field3.setText("");
		field4.setText("");
		field5.setText("");
	}
}
