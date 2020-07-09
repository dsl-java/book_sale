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
 * ������ӹ���Ա�������ӽ���
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
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 25));
		
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
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 18));
		
		text_username = new JTextField();
		text_username.setFont(new Font("����", Font.PLAIN, 18));
		text_username.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1_1.setFont(new Font("����", Font.PLAIN, 18));
		
		text_password = new JPasswordField();
		text_password.setFont(new Font("����", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_1_1_1.setFont(new Font("����", Font.PLAIN, 18));
		
		q_password = new JPasswordField();
		q_password.setFont(new Font("����", Font.PLAIN, 18));
		
		// ���
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
		btnNewButton.setFont(new Font("����", Font.PLAIN, 18));
		
		//����
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_username.setText("");
				text_password.setText("");
				q_password.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 18));
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
	 * ����û���ť�¼����� 
	 * @throws IOException ���ܳ��ֵ��ļ��쳣
	 */
	private void addUser() throws IOException {
		String username=text_username.getText().trim();
		String password=String.valueOf(text_password.getPassword());
		String r_password=String.valueOf(q_password.getPassword());
		
		if(StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�");
			text_username.requestFocus();//�õ����
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
			text_password.requestFocus();
		}
		if(StringUtil.isEmpty(r_password)) {
			JOptionPane.showMessageDialog(null, "ȷ�����벻��Ϊ�գ�");
			q_password.requestFocus();
		}
		if(!password.equalsIgnoreCase(r_password)) {
			JOptionPane.showMessageDialog(null, "������ȷ�����벻һ�£�����������");
			text_password.setText("");
			q_password.setText("");
			text_password.requestFocus();
			return;
		}
		
		//�ж��ļ��Ƿ���ڣ������ھʹ���
		File file = new File("admin.txt");
		if(!file.exists()) {
				file.createNewFile();
		}
		FileDAOImpl fileDAOImpl = new FileDAOImpl();
		ArrayList <Admin> admin = new ArrayList <Admin> ();
		//������Ա�ļ����ݶ���
		BufferedReader br = new BufferedReader(new FileReader(file));
		String ch;
		while((ch = br.readLine()) != null) {
			String[] adminData = ch.split("=");
			Admin a = new Admin();
			a.setAdminId(adminData[0]);
			a.setPassword(adminData[1]);
			
			//��ӵ�������
			admin.add(a);
		}
		
		//�ر��ļ�
		br.close();
		
		// ���������Ƿ����Ҫ��ӵ���Ϣ
		int i = 0;
		for(; i < admin.size(); i++) {
			Admin a = admin.get(i);
			if(a.getAdminId().equals(username)) {
				JOptionPane.showMessageDialog(null, "�û��Ѵ��ڣ��������");
				text_username.setText("");
				text_password.setText("");
				q_password.setText("");
				text_username.requestFocus();//�õ����
				return;
			}
		}
		
		//��װ�γ���Ϣ
		Admin ad = new Admin();
		ad.setAdminId(username);
		ad.setPassword(password);
		
		//��ӵ�����
		admin.add(ad);
		
		//�ж��Ƿ���ӳɹ�
		if(fileDAOImpl.Insert(admin, "admin.txt")) {
			JOptionPane.showMessageDialog(null, "�û���ӳɹ���");
			text_username.setText("");
			text_password.setText("");
			q_password.setText("");
			text_username.requestFocus();//�õ����
		}else {
			JOptionPane.showMessageDialog(null, "�û����ʧ�ܣ�");
		}
		
	}
}
