package viewgui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import database.Landing;

/**
 * 主界面
 */

public class MainInterface extends JFrame{
	/*
	 * 选项卡     主界面       图书查询          图书借还       账号管理
	 * 
	 * */
	//选项卡
	public  JTabbedPane jTabbedPane = new JTabbedPane();
	//主界面面板
	private JPanel jPanel = new JPanel();
	//标签
	private JLabel jLabel = new JLabel("欢迎登录图书管理系统");
	// 字体
	private Font font = new Font("宋体", Font.BOLD, 70);
	private Font font2 = new Font("宋体", Font.BOLD, 20);
	
	private Container con = getContentPane();
	public MainInterface(String user) {

		jPanel.setLayout(null);
		jLabel.setFont(font);
		
		jLabel.setBounds(230, 50, 1000,200);
		jLabel.setForeground(Color.blue);
		jPanel.add(jLabel);

		jTabbedPane.setFont(font2);
		jTabbedPane.add("主 界 面", jPanel);
		BookSearch search = new BookSearch();
		jTabbedPane.add("图书查询",search.jLayeredPane);
		
		BorrowingReturning returning = new BorrowingReturning();
		returning.setUser(user);
		returning.setModel(search.model);
		jTabbedPane.add("图书借还", returning.jLayeredPane);

		if(Landing.sureadmin(user)) {
			Admin admin = new Admin();
			admin.setUser(user);
			admin.setFrame(this);
			jTabbedPane.add("账户管理", admin.jPanel2);
			
			BookAdmin bookAdmin = new BookAdmin();
			bookAdmin.setModel(search.model);
			jTabbedPane.add("图书管理",bookAdmin.jPanel2);
			
		}
		else {
			AccountManagement management = new AccountManagement();
			management.setUser(user);
			management.setFrame(this);
			jTabbedPane.add("账户管理", management.jPanel2);
		}

		con.add(jTabbedPane);
		// 可以改变窗体的大小
		setResizable(true);
		setTitle("图书管理系统");
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
