package cn.dsl.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import cn.dsl.dao.impl.FileDAOImpl;
import cn.dsl.util.StringUtil;
import cn.dsl.vo.Admin;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
/**
 * 这是添加管理员操作的子界面
 * @author dsl
 *
 */
@SuppressWarnings("serial")
public class UserManagerFrame extends JInternalFrame {
	private JTextField text_username;
	private JPasswordField text_password;
	private JPasswordField q_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagerFrame frame = new UserManagerFrame();
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
	public UserManagerFrame() {
		setClosable(true);
		setTitle("\u7528\u6237\u6DFB\u52A0");
		setBounds(100, 100, 771, 309);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u6DFB\u52A0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u6DFB\u52A0\u7528\u6237", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 625, Short.MAX_VALUE)
					.addGap(15))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(250, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_username = new JTextField();
		text_username.setFont(new Font("宋体", Font.PLAIN, 18));
		text_username.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_password = new JPasswordField();
		text_password.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		q_password = new JPasswordField();
		q_password.setFont(new Font("宋体", Font.PLAIN, 18));
		
		// 添加
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addUser();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		//重置
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_username.setText("");
				text_password.setText("");
				q_password.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(text_username, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(text_password, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(q_password, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(16))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(138)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(202))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(text_username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(text_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1_1)
							.addComponent(lblNewLabel_1_1_1)
							.addComponent(q_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 添加用户按钮事件处理 
	 * @throws IOException 可能出现的文件异常
	 */
	private void addUser() throws IOException {
		String username=text_username.getText().trim();
		String password=String.valueOf(text_password.getPassword());
		String r_password=String.valueOf(q_password.getPassword());
		
		if(StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			text_username.requestFocus();//得到光标
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			text_password.requestFocus();
		}
		if(StringUtil.isEmpty(r_password)) {
			JOptionPane.showMessageDialog(null, "确认密码不能为空！");
			q_password.requestFocus();
		}
		if(!password.equalsIgnoreCase(r_password)) {
			JOptionPane.showMessageDialog(null, "密码与确认密码不一致！请重新输入");
			text_password.setText("");
			q_password.setText("");
			text_password.requestFocus();
			return;
		}
		
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
		
		// 看集合中是否存在要添加的信息
		int i = 0;
		for(; i < admin.size(); i++) {
			Admin a = admin.get(i);
			if(a.getAdminId().equals(username)) {
				JOptionPane.showMessageDialog(null, "用户已存在！不能添加");
				text_username.setText("");
				text_password.setText("");
				q_password.setText("");
				text_username.requestFocus();//得到光标
				return;
			}
		}
		
		//封装课程信息
		Admin ad = new Admin();
		ad.setAdminId(username);
		ad.setPassword(password);
		
		//添加到集合
		admin.add(ad);
		
		//判断是否添加成功
		if(fileDAOImpl.Insert(admin, "admin.txt")) {
			JOptionPane.showMessageDialog(null, "用户添加成功！");
			text_username.setText("");
			text_password.setText("");
			q_password.setText("");
			text_username.requestFocus();//得到光标
		}else {
			JOptionPane.showMessageDialog(null, "用户添加失败！");
		}
		
	}
}
