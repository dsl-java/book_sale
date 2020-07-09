package cn.dsl.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.dsl.dao.impl.FileDAOImpl;
import cn.dsl.util.StringUtil;
import cn.dsl.vo.Admin;
/**
 * 这是图书销售管理系统的主界面
 * @author dsl
 *
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private String Ladmin = LoginFrame.getMessage().getAdminId();
	private String Lpassword = LoginFrame.getMessage().getPassword();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setFont(new Font("Dialog", Font.PLAIN, 18));
		setTitle("\u56FE\u4E66\u9500\u552E\u7BA1\u7406\u7CFB\u7EDF-\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1044, 928);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u83DC\u5355");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
	    //修改密码
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modifyPassword();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		//用户管理
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u7528\u6237\u6DFB\u52A0");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserManagerFrame umf=new UserManagerFrame();
				umf.setVisible(true);
				desktopPane.add(umf);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		//退出系统
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "你确定要退出系统吗？");
				if(result==0) {
					dispose();
				}
			}
		});
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u8D26\u53F7\u6CE8\u9500");
		mntmNewMenuItem_9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			// 账号注销
			public void actionPerformed(ActionEvent e) {
				try {
					deleteAdmin();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_9);
		mntmNewMenuItem_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u4FE1\u606F\u7BA1\u7406");
		mnNewMenu_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);
		
		//图书入库
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u56FE\u4E66\u5165\u5E93");
		mntmNewMenuItem_7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddFrame baf=new BookAddFrame();
				baf.setVisible(true);
				desktopPane.add(baf);			
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		//图书信息维护
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u56FE\u4E66\u4FE1\u606F\u7EF4\u62A4");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManagerFrame bmf=new BookManagerFrame();
				bmf.setVisible(true);
				desktopPane.add(bmf);
			}
		});
		mntmNewMenuItem_8.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_2 = new JMenu("\u56FE\u4E66\u5206\u7C7B\u7BA1\u7406");
		mnNewMenu_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		//图书类别添加
		JMenuItem mntmNewMenuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddFrame btaf=new BookTypeAddFrame();
				btaf.setVisible(true);
				desktopPane.add(btaf);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem);
		
		//图书类别维护
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManagerFrame btmf=new BookTypeManagerFrame();
				btmf.setVisible(true);
				desktopPane.add(btmf);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("\u56FE\u4E66\u9500\u552E\u7BA1\u7406");
		mnNewMenu_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_3);
		
		//图书销售维护
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u56FE\u4E66\u9500\u552E\u67E5\u8BE2");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookSaleManagerFrame bsmf=new BookSaleManagerFrame();
				bsmf.setVisible(true);
				desktopPane.add(bsmf);
			}
		});
		
		//图书销售添加
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u9500\u552E\u9500\u552E\u6DFB\u52A0");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookSaleAddFrame bsaf=new BookSaleAddFrame();
				bsaf.setVisible(true);
				desktopPane.add(bsaf);
			}
		});
		mntmNewMenuItem_6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mnNewMenu_3.add(mntmNewMenuItem_6);
		mntmNewMenuItem_5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mnNewMenu_3.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		// 设置窗体最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 *  账号注销事件处理
	 * @throws IOException 可能出现的文件异常
	 */
	private void deleteAdmin() throws IOException {
		String oldpassword = JOptionPane.showInputDialog("请输入原始密码:");
		if(StringUtil.isEmpty(oldpassword)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
		}
		if(! oldpassword.equals(Lpassword)) {
			JOptionPane.showMessageDialog(null, "密码输入错误！");
		}else {
			int n=JOptionPane.showConfirmDialog(null, "你确定要注销您的账号吗？");
			if(n == 0) {
				// 将信息从用户文件中删除
				//判断文件是否存在，不存在就创建
				File file = new File("admin.txt");
				if(!file.exists()) {
						file.createNewFile();
				}
				FileDAOImpl fileDAOImpl = new FileDAOImpl();
				ArrayList <Admin> admin = new ArrayList <Admin> ();
				//将课程文件内容读入
				BufferedReader br = new BufferedReader(new FileReader(file));
				String ch;
				while((ch = br.readLine()) != null) {
					String[] adminData = ch.split("=");
					Admin a = new Admin();
					a.setAdminId(adminData[0]);
					a.setPassword(adminData[1]);
					
					//添加到集合中
					admin.add(a);
				}
				
				//关闭文件
				br.close();
				
				//判断是否删除成功
				if(fileDAOImpl.Delete(admin, Ladmin)) {
					JOptionPane.showMessageDialog(null, "注销成功！");
					dispose();
					new LoginFrame().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "注销失败");
				}
				// 注销当前窗口
				dispose();
				// 返回登录界面
				new LoginFrame().setVisible(true);
			}
		}
	}

	/**
	 * 修改密码事件处理
	 * @throws IOException 可能出现的文件异常
	 */
	private void modifyPassword() throws IOException {
		String oldpassword = JOptionPane.showInputDialog("请输入原始密码:");
		if(StringUtil.isEmpty(oldpassword)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
		}
		if(! oldpassword.equals(Lpassword)) {
			JOptionPane.showMessageDialog(null, "密码输入错误！");
		}else {
			while(true) {
				String newpassword = JOptionPane.showInputDialog("请输入新密码:");
				if(StringUtil.isEmpty(newpassword)) {
					JOptionPane.showMessageDialog(null, "密码不能为空！");
				}else if(newpassword.equals(oldpassword)) {
					JOptionPane.showMessageDialog(null, "新密码和旧密码一致，修改失败！");
				}else {
					//判断文件是否存在，不存在就创建
					File file = new File("admin.txt");
					if(!file.exists()) {
							file.createNewFile();
					}
					FileDAOImpl fileDAOImpl = new FileDAOImpl();
					ArrayList <Admin> admin = new ArrayList <Admin> ();
					//将管理员文件内容读入
					BufferedReader br = new BufferedReader(new FileReader(file));
					String ch;
					while((ch = br.readLine()) != null) {
						String[] adminData = ch.split("=");
						Admin a = new Admin();
						a.setAdminId(adminData[0]);
						a.setPassword(adminData[1]);
						
						//添加到集合中
						admin.add(a);
					}
					
					//关闭文件
					br.close();
					
					//判断登录是否成功
					if(fileDAOImpl.Modify(admin, Ladmin, newpassword)) {
						JOptionPane.showMessageDialog(null, "修改成功！请重新登录");
						dispose();
						new LoginFrame().setVisible(true);
						break;
					}else {
						JOptionPane.showMessageDialog(null, "修改错误");
					}
				}
			}
		}
	}
}
