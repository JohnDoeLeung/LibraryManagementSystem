package viewgui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import database.ConnectDatabase;

/**
 * �޸��������
 */
public class ModifyPassword extends JFrame {
	/*
	 * ������ǩ �û��� һ��ǩ һ�ı��� ������ һ��ǩ һ�ı��� ������ һ��ǩ һ�ı��� ȷ������
	 */
	// ���
	private JPanel jPanel = new JPanel();
	// ��ǩ
	private JLabel jLabel = new JLabel("�� �� ��:");
	private JLabel jLabel2 = new JLabel();
	private JLabel jLabel3 = new JLabel("ԭʼ���룺");
	private JLabel jLabel4 = new JLabel("�� �� �룺");
	private JLabel jLabel5 = new JLabel("ȷ�����룺");
	// �ı���
	private JPasswordField field = new JPasswordField(22);
	private JPasswordField field2 = new JPasswordField(22);
	private JPasswordField field3 = new JPasswordField(22);
	// ����
	private Font font = new Font("����", Font.BOLD, 24);
	private Font font1 = new Font("����", Font.BOLD, 22);
	// ��ť �޸�
	private JButton button = new JButton("��   ��");
	private JFrame frame = new JFrame();

	public ModifyPassword(String user) {
		setSize(600, 450);

		setTitle("�޸�����");
		jLabel2.setText(user);
		jLabel.setFont(font);
		jLabel2.setFont(font);
		jLabel3.setFont(font);
		jLabel4.setFont(font);
		jLabel5.setFont(font);
		field.setFont(font1);
		field2.setFont(font1);
		field3.setFont(font1);
		button.setFont(font1);

		add();

		jLabel.setBounds(120, 170, 150, 30);
		jLabel2.setBounds(260, 170, 300, 30);
		jLabel3.setBounds(120, 210, 150, 30);
		field.setBounds(260, 215, 140, 25);
		jLabel4.setBounds(120, 250, 150, 30);
		field2.setBounds(260, 255, 140, 25);
		jLabel5.setBounds(120, 290, 150, 30);
		field3.setBounds(260, 295, 140, 25);
		button.setBounds(115, 340, 285, 30);

		jPanel.add(jLabel);
		jPanel.add(jLabel2);
		jPanel.add(jLabel3);
		jPanel.add(field);
		jPanel.add(jLabel4);
		jPanel.add(field2);
		jPanel.add(jLabel5);
		jPanel.add(field3);
		jPanel.add(button);
		jPanel.setLayout(null);
		jPanel.setBounds(0, 0, 600, 400);
		jPanel.setOpaque(false);
		add(jPanel);
		// �����Ըı䴰��Ĵ�С
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	// �ȶԾ�����
	private boolean comparison(String user, String password) {

		Connection con = ConnectDatabase.connectDB();
		PreparedStatement preSql;
		ResultSet rs;
		String sqlStr = "select * from usertable where user = ?";
		
		try {
			preSql = con.prepareStatement(sqlStr);
			preSql.setString(1, user);
			rs = preSql.executeQuery();
			while (rs.next()) {
				String s = rs.getString(4);
				
				if (s.equals(password)) {
					return true;
				}
				else {
					return false;
				}
			}
			con.close();
			return false;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	// ����¼�
	private void add() {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user = jLabel2.getText().trim();
				String oldpass = field.getText().trim();
				String newpass = field2.getText().trim();
				String surepass = field3.getText().trim();
				if (comparison(user, oldpass)) {
					if(newpass.length()<6||newpass.length()>16) {
						JOptionPane.showMessageDialog(null, "����涨6-16λ�����ܺ��пո�", "����", JOptionPane.WARNING_MESSAGE);
						empty();
					}
					else {
						if (newpass.equals(surepass)) {
							database.ModifyPassword.modifypass(user, newpass);
							JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
	
							JOptionPane.showMessageDialog(null, "�����µ�½");
							dispose();
							frame.dispose();
							new Land();
						}
						else {
							JOptionPane.showMessageDialog(null, "ȷ�����벻��ͬ", "����", JOptionPane.WARNING_MESSAGE);
							empty();
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "ԭʼ���벻��ȷ", "����", JOptionPane.WARNING_MESSAGE);
					empty();
				}

			}
		});
	}

	private void empty() {
		field.setText("");
		field2.setText("");
		field3.setText("");
	}
}
