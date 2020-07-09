package cn.dsl.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import cn.dsl.dbc.DatabaseConnection;
import cn.dsl.factory.DAOFactory;
import cn.dsl.service.impl.AllTableServiceImpl;
import cn.dsl.util.StringUtil;
import cn.dsl.vo.BookInfo;
import cn.dsl.vo.BookSale;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
/**
 * 这是添加图书销售操作的子界面
 * @author dsl
 *
 */
@SuppressWarnings("serial")
public class BookSaleAddFrame extends JInternalFrame {
	private JTextField text_saleId;
	private JTextField text_salePrice;
	private JTextField text_saleDate;
	private JTextField text_saleCount;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_bookName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookSaleAddFrame frame = new BookSaleAddFrame();
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
	@SuppressWarnings("rawtypes")
	public BookSaleAddFrame() {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u9500\u552E\u6DFB\u52A0");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("\u9500\u552E\u8BB0\u5F55\u7F16\u53F7:");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_saleId = new JTextField();
		text_saleId.setFont(new Font("宋体", Font.PLAIN, 18));
		text_saleId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u56FE\u4E66\u540D\u79F0:");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u5B9E\u9645\u552E\u4EF7:");
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_salePrice = new JTextField();
		text_salePrice.setFont(new Font("宋体", Font.PLAIN, 18));
		text_salePrice.setColumns(10);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("\u9500\u552E\u65E5\u671F:");
		lblNewLabel_1_1_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_saleDate = new JTextField();
		text_saleDate.setFont(new Font("宋体", Font.PLAIN, 18));
		text_saleDate.setColumns(10);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("\u9500\u552E\u6570\u91CF:");
		lblNewLabel_1_1_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_saleCount = new JTextField();
		text_saleCount.setFont(new Font("宋体", Font.PLAIN, 18));
		text_saleCount.setColumns(10);
		
		comboBox_bookName = new JComboBox();
		comboBox_bookName.setFont(new Font("宋体", Font.PLAIN, 18));
		
		//添加按钮
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addBookSale();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		//重置按钮
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_saleId.setText("");
				text_salePrice.setText("");
				text_saleDate.setText("");
				text_saleCount.setText("");
				if(comboBox_bookName.getItemCount()>0) {
					comboBox_bookName.setSelectedIndex(0);
				}
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(text_saleCount, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(368))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_saleId, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(text_salePrice, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
							.addGap(39)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1_2)
									.addGap(18)
									.addComponent(text_saleDate, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_bookName, 0, 193, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addGap(151)))
							.addGap(38))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(180)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(385, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(text_saleId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1)
								.addComponent(comboBox_bookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_1_1))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(text_salePrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_1_1_2)
							.addComponent(text_saleDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1_3)
						.addComponent(text_saleCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		setTitle("\u56FE\u4E66\u9500\u552E\u6DFB\u52A0");
		setClosable(true);
		setBounds(100, 100, 674, 441);
		 fillBookName();
	}

	/**
	 * 添加按钮处理事件
	 */
	private void addBookSale() {
		String saleId=text_saleId.getText().trim();
		BookInfo bk=(BookInfo)comboBox_bookName.getSelectedItem();
		String bookId=bk.getBookId();
		
	    String salePrice=text_salePrice.getText().trim();
	    String saleDate=text_saleDate.getText().trim(); 
	    String saleCount=text_saleCount.getText().trim();
	    
	    if(StringUtil.isEmpty(saleId)) {
			JOptionPane.showMessageDialog(null, "销售记录编号不能为空");
			text_saleId.requestFocus();//得到光标
			return;
		}
	    if(StringUtil.isEmpty(salePrice)) {
			JOptionPane.showMessageDialog(null, "实际售价不能为空");
			text_saleId.requestFocus();//得到光标
			return;
		}
	    if(StringUtil.isEmpty(saleDate)) {
			JOptionPane.showMessageDialog(null, "销售记日期不能为空");
			text_saleId.requestFocus();//得到光标
			return;
		}
	    if(StringUtil.isEmpty(saleCount)) {
			JOptionPane.showMessageDialog(null, "销售数量不能为空");
			text_saleId.requestFocus();//得到光标
			return;
		}
	    
	    BookSale bs=new BookSale();
	    bs.setId(saleId);
	    bs.setBookId(bookId);
	    bs.setSalePrice(Double.parseDouble(salePrice));
	    bs.setSaleDate(saleDate);
	    bs.setSaleCount(Integer.parseInt(saleCount));
	    
	    try {
			if(new AllTableServiceImpl().Insert(bs)) {
				JOptionPane.showMessageDialog(null, "添加成功");
				text_saleId.setText("");
				text_salePrice.setText("");
				text_saleDate.setText("");
				text_saleCount.setText("");
				if(comboBox_bookName.getItemCount()>0) {
					comboBox_bookName.setSelectedIndex(0);
				}
			}else {
				JOptionPane.showMessageDialog(null, "该销售记录编号已存在，添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}
	
	/**
	 * 填充图书名称
	 */
	@SuppressWarnings("unchecked")
	private void fillBookName() {
		BookInfo bk= null;
		try {
			ResultSet rs=DAOFactory.getIAllTableDAOInstance(new DatabaseConnection().getConn()).doFind(new BookInfo());
			while(rs.next()) {
				bk=new BookInfo();
				bk.setBookId(rs.getString("bookId"));
				bk.setBookName(rs.getString("bookName"));
				this.comboBox_bookName.addItem(bk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
