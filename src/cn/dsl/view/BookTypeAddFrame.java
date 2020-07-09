package cn.dsl.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import cn.dsl.service.impl.AllTableServiceImpl;
import cn.dsl.util.StringUtil;
import cn.dsl.vo.BookCategory;
/**
 * 这是图书类别添加的操作子界面
 * @author dsl
 *
 */
@SuppressWarnings("serial")
public class BookTypeAddFrame extends JInternalFrame {

	private JTextField text_bookTypeId;
	private JTextField text_bookTypeName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddFrame frame = new BookTypeAddFrame();
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
	public BookTypeAddFrame() {
		setClosable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 501, 381);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_bookTypeId = new JTextField();
		text_bookTypeId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_bookTypeName = new JTextField();
		text_bookTypeName.setColumns(10);
		
		//添加
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBookType();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		//重置
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_bookTypeId.setText("");
				text_bookTypeName.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(132, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addGap(83)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_bookTypeId, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_bookTypeName, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(text_bookTypeId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_bookTypeName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(71)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 添加图书类别事件
	 */
	private void addBookType() {
		String bookTypeId=text_bookTypeId.getText().trim();//获取文本框的内容  trim()移除字符串两边的空格
		String bookTypeName=text_bookTypeName.getText().trim();
		//判断是否为空
		if(StringUtil.isEmpty(bookTypeId)) {
			JOptionPane.showMessageDialog(null, "图书类型编号不能为空！");
			text_bookTypeId.requestFocus();//得到光标
			return;
		}
		
		if(StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "图书类型名称不能为空！");
			text_bookTypeId.requestFocus();//得到光标
			return;
		}
		
		BookCategory bc=new BookCategory();
		bc.setCategoryId(bookTypeId);
		bc.setcategoryName(bookTypeName);
		
		try {
			if(new AllTableServiceImpl().Insert(bc)) {
				JOptionPane.showMessageDialog(null, "添加成功！");
				text_bookTypeId.setText("");
				text_bookTypeName.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "该图书类别已存在，添加失败！");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
