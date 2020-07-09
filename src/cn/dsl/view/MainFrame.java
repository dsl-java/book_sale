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
 * ����ͼ�����۹���ϵͳ��������
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
		
	    //�޸�����
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
		
		//�û�����
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
		
		//�˳�ϵͳ
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ�˳�ϵͳ��");
				if(result==0) {
					dispose();
				}
			}
		});
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u8D26\u53F7\u6CE8\u9500");
		mntmNewMenuItem_9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			// �˺�ע��
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
		
		//ͼ�����
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
		
		//ͼ����Ϣά��
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
		
		//ͼ��������
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
		
		//ͼ�����ά��
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
		
		//ͼ������ά��
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u56FE\u4E66\u9500\u552E\u67E5\u8BE2");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookSaleManagerFrame bsmf=new BookSaleManagerFrame();
				bsmf.setVisible(true);
				desktopPane.add(bsmf);
			}
		});
		
		//ͼ���������
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
		
		// ���ô������
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 *  �˺�ע���¼�����
	 * @throws IOException ���ܳ��ֵ��ļ��쳣
	 */
	private void deleteAdmin() throws IOException {
		String oldpassword = JOptionPane.showInputDialog("������ԭʼ����:");
		if(StringUtil.isEmpty(oldpassword)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
		}
		if(! oldpassword.equals(Lpassword)) {
			JOptionPane.showMessageDialog(null, "�����������");
		}else {
			int n=JOptionPane.showConfirmDialog(null, "��ȷ��Ҫע�������˺���");
			if(n == 0) {
				// ����Ϣ���û��ļ���ɾ��
				//�ж��ļ��Ƿ���ڣ������ھʹ���
				File file = new File("admin.txt");
				if(!file.exists()) {
						file.createNewFile();
				}
				FileDAOImpl fileDAOImpl = new FileDAOImpl();
				ArrayList <Admin> admin = new ArrayList <Admin> ();
				//���γ��ļ����ݶ���
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
				
				//�ж��Ƿ�ɾ���ɹ�
				if(fileDAOImpl.Delete(admin, Ladmin)) {
					JOptionPane.showMessageDialog(null, "ע���ɹ���");
					dispose();
					new LoginFrame().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "ע��ʧ��");
				}
				// ע����ǰ����
				dispose();
				// ���ص�¼����
				new LoginFrame().setVisible(true);
			}
		}
	}

	/**
	 * �޸������¼�����
	 * @throws IOException ���ܳ��ֵ��ļ��쳣
	 */
	private void modifyPassword() throws IOException {
		String oldpassword = JOptionPane.showInputDialog("������ԭʼ����:");
		if(StringUtil.isEmpty(oldpassword)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
		}
		if(! oldpassword.equals(Lpassword)) {
			JOptionPane.showMessageDialog(null, "�����������");
		}else {
			while(true) {
				String newpassword = JOptionPane.showInputDialog("������������:");
				if(StringUtil.isEmpty(newpassword)) {
					JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
				}else if(newpassword.equals(oldpassword)) {
					JOptionPane.showMessageDialog(null, "������;�����һ�£��޸�ʧ�ܣ�");
				}else {
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
					
					//�жϵ�¼�Ƿ�ɹ�
					if(fileDAOImpl.Modify(admin, Ladmin, newpassword)) {
						JOptionPane.showMessageDialog(null, "�޸ĳɹ��������µ�¼");
						dispose();
						new LoginFrame().setVisible(true);
						break;
					}else {
						JOptionPane.showMessageDialog(null, "�޸Ĵ���");
					}
				}
			}
		}
	}
}
