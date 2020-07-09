package cn.dsl.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.dsl.dao.impl.FileDAOImpl;
import cn.dsl.util.StringUtil;
import cn.dsl.vo.Admin;
/**
 * 这是管理员登录的界面
 * @author dsl
 *
 */
@SuppressWarnings("serial")
public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private static JTextField jtfUserName;
	private static JPasswordField jpfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setFont(new Font("Dialog", Font.PLAIN, 18));
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(38, 52, 108, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6    \u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(38, 109, 92, 18);
		contentPane.add(lblNewLabel_1);
		
		jtfUserName = new JTextField();
		jtfUserName.setFont(new Font("宋体", Font.PLAIN, 18));
		jtfUserName.setBounds(147, 49, 178, 24);
		contentPane.add(jtfUserName);
		jtfUserName.setColumns(10);
		
		//登录
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Login();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(69, 170, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			// 重置按钮事件
			public void actionPerformed(ActionEvent e) {
				jtfUserName.setText("");
				jpfPassword.setText("");
				jtfUserName.requestFocus();//得到光标
			}
		});
		btnNewButton_1.setBounds(234, 170, 113, 27);
		contentPane.add(btnNewButton_1);
		
		jpfPassword = new JPasswordField();
		jpfPassword.setFont(new Font("宋体", Font.PLAIN, 18));
		jpfPassword.setBounds(147, 106, 178, 24);
		contentPane.add(jpfPassword);
		
		// 设置当前窗体居中显示
		this.setLocationRelativeTo(null);
	}

	/**
	 * 登录事件处理
	 * @throws IOException 可能出现的文件异常
	 */
	private void Login() throws IOException {
		String name = jtfUserName.getText();
		String key = String.valueOf(jpfPassword.getPassword());
		//校验
		if(StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			jtfUserName.requestFocus();//得到光标
			return;
		}
		
		if(StringUtil.isEmpty(key)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			jtfUserName.requestFocus();//得到光标
			return;
		}
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
		
		//判断登录是否成功
		if(fileDAOImpl.Find(admin, name, key)) {
			JOptionPane.showMessageDialog(null, "恭喜你登录成功！");
			dispose();
			new MainFrame().setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "用户名或密码错误");
			jtfUserName.setText("");
			jpfPassword.setText("");
			jtfUserName.requestFocus();//得到光标
		}
	}
	
	/**
	 * 获取当前界面的用户名和密码
	 * @return   返回管理员信息（此方法是为了进入主界面后记住管理员的信息）
	 */
	public static Admin getMessage() {
		String admin = jtfUserName.getText();
		String password = String.valueOf(jpfPassword.getPassword());
		return new Admin(admin,password);
	}
}
