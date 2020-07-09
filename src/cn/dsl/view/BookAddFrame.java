package cn.dsl.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import cn.dsl.dbc.DatabaseConnection;
import cn.dsl.factory.DAOFactory;
import cn.dsl.service.impl.AllTableServiceImpl;
import cn.dsl.util.StringUtil;
import cn.dsl.vo.BookCategory;
import cn.dsl.vo.BookInfo;
/**
 * 这是添加图书操作的子界面
 * @author dsl
 *
 */
@SuppressWarnings("serial")
public class BookAddFrame extends JInternalFrame {

	private JTextField text_bookid;
	private JTextField text_bookName;
	private JTextField text_author;
	private JTextField text_publisher;
	private JTextField text_publishDate;
	private JTextField text_purchase;
	private JTextField text_price;
	private JTextField text_stock;
	@SuppressWarnings("rawtypes")
	private JComboBox com_booktyp;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddFrame frame = new BookAddFrame();
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
	public BookAddFrame() {
		setClosable(true);
		setTitle("\u56FE\u4E66\u4FE1\u606F\u6DFB\u52A0");
		setBounds(100, 100, 601, 516);
		
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u4FE1\u606F\u6DFB\u52A0");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_bookid = new JTextField();
		text_bookid.setFont(new Font("宋体", Font.PLAIN, 18));
		text_bookid.setColumns(10);
		
		text_bookName = new JTextField();
		text_bookName.setFont(new Font("宋体", Font.PLAIN, 18));
		text_bookName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_author = new JTextField();
		text_author.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_3 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		lblNewLabel_1_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
	    com_booktyp = new JComboBox();
		
		JLabel lblNewLabel_1_2_1 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		lblNewLabel_1_2_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_publisher = new JTextField();
		text_publisher.setFont(new Font("宋体", Font.PLAIN, 18));
		text_publisher.setColumns(10);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("\u51FA\u7248\u65E5\u671F\uFF1A");
		lblNewLabel_1_2_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_publishDate = new JTextField();
		text_publishDate.setFont(new Font("宋体", Font.PLAIN, 18));
		text_publishDate.setColumns(10);
		
		JLabel lblNewLabel_1_2_2_2 = new JLabel("\u8FDB  \u4EF7\uFF1A");
		lblNewLabel_1_2_2_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_purchase = new JTextField();
		text_purchase.setFont(new Font("宋体", Font.PLAIN, 18));
		text_purchase.setColumns(10);
		
		JLabel lblNewLabel_1_2_2_3 = new JLabel("\u552E  \u4EF7\uFF1A");
		lblNewLabel_1_2_2_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_price = new JTextField();
		text_price.setFont(new Font("宋体", Font.PLAIN, 18));
		text_price.setColumns(10);
		
		JLabel lblNewLabel_1_2_2_4 = new JLabel("\u5E93  \u5B58\uFF1A");
		lblNewLabel_1_2_2_4.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_stock = new JTextField();
		text_stock.setFont(new Font("宋体", Font.PLAIN, 18));
		text_stock.setColumns(10);
		
		//添加按钮
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBook();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		//重置按钮
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_bookid.setText("");
				text_bookName.setText("");
				text_author.setText("");
				text_publisher.setText("");
				text_publishDate.setText("");
				text_purchase.setText("");
				text_price.setText("");
				text_stock.setText("");
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1_2_2_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(592, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1_2_2_4, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(592, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1_2_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(text_publisher, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(com_booktyp, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(text_bookid, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
						.addComponent(text_purchase, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_stock, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
					.addGap(81)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(text_bookName, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblNewLabel_1_2_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblNewLabel_1_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addComponent(lblNewLabel_1_2_2_3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(text_price, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addComponent(text_author, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addComponent(text_publishDate, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))))
					.addGap(136))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(153)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(71)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(241, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 586, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(95, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(text_bookid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(text_bookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2)
						.addComponent(com_booktyp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_3)
						.addComponent(text_author, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1_2_2)
							.addComponent(text_publishDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1_2_1)
							.addComponent(text_publisher, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1_2_2_2)
							.addComponent(text_purchase, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1_2_2_3)
							.addComponent(text_price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2_2_4)
						.addComponent(text_stock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(50))
		);
		getContentPane().setLayout(groupLayout);
		fillBookType();
	}
	
	/**
	 * 添加按钮事件处理
	 */
	private void addBook() {
		String bookId=text_bookid.getText().trim();
		String bookName=text_bookName.getText().trim();
		//下拉列表选择了哪一项
		BookCategory bc=(BookCategory) com_booktyp.getSelectedItem();
		String categoryId=bc.getCategoryId();
		
		String author=text_author.getText().trim();
		String publisher=text_publisher.getText().trim();
		String publishDate=text_publishDate.getText().trim();
		Double purchase=Double.parseDouble(text_purchase.getText());
		Double price=Double.parseDouble(text_price.getText());		
		Integer stock=Integer.parseInt(text_stock.getText().trim());
		
		if(StringUtil.isEmpty(bookId)) {
			JOptionPane.showMessageDialog(null, "图书编号不能为空");
			text_bookid.requestFocus();//得到光标
			return;
		}
		
		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名不能为空");
			text_bookid.requestFocus();//得到光标
			return;
		}
		if(StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "图书作者不能为空");
			text_bookid.requestFocus();//得到光标
			return;
		}
		if(StringUtil.isEmpty(publisher)) {
			JOptionPane.showMessageDialog(null, "出版社不能为空");
			text_bookid.requestFocus();//得到光标
			return;
		}
		if(StringUtil.isEmpty(publishDate)) {
			JOptionPane.showMessageDialog(null, "出版日期不能为空");
			text_bookid.requestFocus();//得到光标
			return;
		}
		if(StringUtil.isEmpty(text_purchase.getText())) {
			JOptionPane.showMessageDialog(null, "进价不能为空");
			text_bookid.requestFocus();//得到光标
			return;
		}
		if(StringUtil.isEmpty(text_price.getText())) {
			JOptionPane.showMessageDialog(null, "售价不能为空");
			text_bookid.requestFocus();//得到光标
			return;
		}
		if(StringUtil.isEmpty(text_stock.getText())) {
			JOptionPane.showMessageDialog(null, "库存不能为空");
			text_bookid.requestFocus();//得到光标
			return;
		}
		
		BookInfo bk=new BookInfo();
		bk.setBookId(bookId);
		bk.setBookName(bookName);
		bk.setCategoryId(categoryId);
		bk.setAuthor(author);
		bk.setPublisher(publisher);
		bk.setPublishDate(publishDate);
		bk.setPurchase(purchase);
		bk.setPrice(price);
		bk.setStock(stock);
		try {
			if(new AllTableServiceImpl().Insert(bk)) {
				JOptionPane.showMessageDialog(null, "添加成功");
				text_bookid.setText("");
				text_bookName.setText("");
				text_author.setText("");
				text_publisher.setText("");
				text_publishDate.setText("");
				text_purchase.setText("");
				text_price.setText("");
				text_stock.setText("");
			}else {
				JOptionPane.showMessageDialog(null, "该图书编号已存在，添加失败");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}


	/**
	 * 填充图书类别
	 */
	@SuppressWarnings("unchecked")
	private void fillBookType() {
		BookCategory bc= null;
		try {
			ResultSet rs=DAOFactory.getIAllTableDAOInstance(new DatabaseConnection().getConn()).doFind(new BookCategory());
			while(rs.next()) {
				bc=new BookCategory();
				bc.setCategoryId(rs.getString("categoryId"));
				bc.setcategoryName(rs.getString("categoryName"));
				this.com_booktyp.addItem(bc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
