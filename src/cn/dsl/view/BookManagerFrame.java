package cn.dsl.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import cn.dsl.dbc.DatabaseConnection;
import cn.dsl.factory.DAOFactory;
import cn.dsl.service.impl.AllTableServiceImpl;
import cn.dsl.util.StringUtil;
import cn.dsl.vo.BookCategory;
import cn.dsl.vo.BookInfo;
/**
 * 这是图书信息维护的操作子界面
 * @author dsl
 *
 */
@SuppressWarnings("serial")
public class BookManagerFrame extends JInternalFrame {

	private JTable table;
	private JTextField text_name;
	private JTextField text_author;
	private JTable table_bookinfo;
	private JTextField text_bookid;
	private JTextField text_bookName;
	private JTextField te_author;
	private JTextField text_publisher;
	private JTextField text_publishDate;
	private JTextField text_purchase;
	private JTextField text_price;
	private JTextField text_stock;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_bookType;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_category;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManagerFrame frame = new BookManagerFrame();
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
	public BookManagerFrame() {
		setClosable(true);
		setTitle("\u56FE\u4E66\u4FE1\u606F\u7EF4\u62A4");
		setBounds(100, 100, 918, 817);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u4FE1\u606F\u7EF4\u62A4");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setEnabled(true);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		
		table = new JTable();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(194)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(641, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_bookid = new JTextField();
		text_bookid.setFont(new Font("宋体", Font.PLAIN, 18));
		text_bookid.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_bookName = new JTextField();
		text_bookName.setFont(new Font("宋体", Font.PLAIN, 18));
		text_bookName.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B\uFF1A");
		lblNewLabel_2_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2_3 = new JLabel("\u4F5C\u8005\uFF1A");
		lblNewLabel_2_3.setFont(new Font("宋体", Font.PLAIN, 18));
		
		te_author = new JTextField();
		te_author.setFont(new Font("宋体", Font.PLAIN, 18));
		te_author.setColumns(10);
		
		JLabel lblNewLabel_2_4 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		lblNewLabel_2_4.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_publisher = new JTextField();
		text_publisher.setFont(new Font("宋体", Font.PLAIN, 18));
		text_publisher.setColumns(10);
		
		JLabel lblNewLabel_2_5 = new JLabel("\u51FA\u7248\u65E5\u671F\uFF1A");
		lblNewLabel_2_5.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_publishDate = new JTextField();
		text_publishDate.setFont(new Font("宋体", Font.PLAIN, 18));
		text_publishDate.setColumns(10);
		
		JLabel lblNewLabel_2_6 = new JLabel("\u8FDB\u4EF7\uFF1A");
		lblNewLabel_2_6.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_purchase = new JTextField();
		text_purchase.setFont(new Font("宋体", Font.PLAIN, 18));
		text_purchase.setColumns(10);
		
		JLabel lblNewLabel_2_6_1 = new JLabel("\u552E\u4EF7\uFF1A");
		lblNewLabel_2_6_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_price = new JTextField();
		text_price.setFont(new Font("宋体", Font.PLAIN, 18));
		text_price.setColumns(10);
		
		JLabel lblNewLabel_2_6_2 = new JLabel("\u5E93\u5B58\uFF1A");
		lblNewLabel_2_6_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_stock = new JTextField();
		text_stock.setFont(new Font("宋体", Font.PLAIN, 18));
		text_stock.setColumns(10);
		
		//修改按钮
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifyBook();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		//删除按钮
		JButton btnNewButton_1_1 = new JButton("\u5220\u9664");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBook();
			}
		});
		btnNewButton_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		comboBox_category = new JComboBox();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_bookid, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_bookName))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(te_author, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2_4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_publisher, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_2_6, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(text_purchase, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_2_6_1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_price)))
							.addGap(27)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_2_5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_publishDate, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_2_6_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(text_stock))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_category, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(196)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addGap(106)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(67, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(text_bookName, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_category, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2)
							.addComponent(text_bookid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(49)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(te_author, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2_4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(text_publisher, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2_5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(text_publishDate, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel_2_6_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel_2_6, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addComponent(text_purchase, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel_2_6_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addComponent(text_price, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(42)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton_1)
								.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
						.addComponent(text_stock, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		table_bookinfo = new JTable();
		table_bookinfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//表格点击行事件
				int row=table_bookinfo.getSelectedRow();
				text_bookid.setText((String) table_bookinfo.getValueAt(row,0));
				text_bookName.setText((String) table_bookinfo.getValueAt(row,1));
				
				String bookTypeName=((String) table_bookinfo.getValueAt(row,2));
				int n=comboBox_category.getItemCount();
				for(int i=0;i<n;i++) {
					BookCategory item=(BookCategory) comboBox_category.getItemAt(i);
					if(item.getcategoryName().equals(bookTypeName)) {
						comboBox_category.setSelectedIndex(i);
					}
				}				
				te_author.setText((String) table_bookinfo.getValueAt(row,3));
				text_publisher.setText((String) table_bookinfo.getValueAt(row,4));
				text_publishDate.setText((Date) table_bookinfo.getValueAt(row,5)+"");
				text_purchase.setText((Double) table_bookinfo.getValueAt(row,6)+"");
				text_price.setText((Double) table_bookinfo.getValueAt(row,7)+"");
				text_stock.setText((Integer) table_bookinfo.getValueAt(row,8)+"");	
			}
		});
		table_bookinfo.setFont(new Font("宋体", Font.PLAIN, 18));
		table_bookinfo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B", "\u4F5C\u8005", "\u51FA\u7248\u793E", "\u51FA\u7248\u65F6\u95F4", "\u8FDB\u4EF7", "\u552E\u4EF7", "\u5E93\u5B58"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_bookinfo.getColumnModel().getColumn(0).setPreferredWidth(110);
		table_bookinfo.getColumnModel().getColumn(1).setPreferredWidth(114);
		table_bookinfo.getColumnModel().getColumn(2).setPreferredWidth(105);
		table_bookinfo.getColumnModel().getColumn(3).setPreferredWidth(90);
		table_bookinfo.getColumnModel().getColumn(4).setPreferredWidth(118);
		table_bookinfo.getColumnModel().getColumn(5).setPreferredWidth(114);
		scrollPane.setViewportView(table_bookinfo);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_name = new JTextField();
		text_name.setFont(new Font("宋体", Font.PLAIN, 18));
		text_name.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u4F5C\u8005\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_author = new JTextField();
		text_author.setFont(new Font("宋体", Font.PLAIN, 18));
		text_author.setColumns(10);
		
		//查询按钮
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findBook();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u7C7B\u522B\uFF1A");
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		comboBox_bookType = new JComboBox();
		comboBox_bookType.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(47)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(text_name, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(text_author, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox_bookType, 0, 99, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(text_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_author, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton)
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_bookType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		fillTable(new BookInfo());
		fillBookType("search");
		fillBookType("modify");
	}
	
	/**
	 * 修改按钮事件处理
	 */
	private void modifyBook() {
		//图书修改
		String bookId=text_bookid.getText();
		if(StringUtil.isEmpty(bookId)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		String bookName=text_bookName.getText();
		BookCategory bookType=(BookCategory)comboBox_category.getSelectedItem();
		String categoryId=bookType.getCategoryId();
		
		String author=te_author.getText();
		String publisher=text_publisher.getText();
		String publishDate=text_publishDate.getText();
		String purchase=text_purchase.getText();
		String price=text_price.getText();
		String stock=text_stock.getText();
		
		if(StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书的名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(categoryId)) {
			JOptionPane.showMessageDialog(null, "图书类型的编号不能为空！");
			return;
		}
		if(StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "作者不能为空！");
			return;
		}
		if(StringUtil.isEmpty(publisher)) {
			JOptionPane.showMessageDialog(null, "出版社不能为空！");
			return;
		}
		if(StringUtil.isEmpty(publishDate)) {
			JOptionPane.showMessageDialog(null, "出版日期不能为空！");
			return;
		}
		if(StringUtil.isEmpty(purchase)) {
			JOptionPane.showMessageDialog(null, "进价不能为空！");
			return;
		}
		if(StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "售价不能为空！");
			return;
		}
		if(StringUtil.isEmpty(stock)) {
			JOptionPane.showMessageDialog(null, "库存不能为空！");
			return;
		}
		
		BookInfo bk=new BookInfo();
		bk.setBookId(bookId);
		bk.setBookName(bookName);
		bk.setCategoryId(categoryId);
		bk.setAuthor(author);
		bk.setPublisher(publisher);
		bk.setPublishDate(publishDate);
		bk.setPurchase(Double.parseDouble(purchase));
		bk.setPrice(Double.parseDouble(price));
		bk.setStock(Integer.parseInt(stock));
		try {
			if(new AllTableServiceImpl().Update(bk)) {
				JOptionPane.showMessageDialog(null, "修改成功");
				text_bookid.setText("");
				text_bookName.setText("");
				if(comboBox_category.getItemCount()>0) {
					comboBox_category.setSelectedIndex(0);
				}
				te_author.setText("");
				text_publisher.setText("");
				text_publishDate.setText("");
				text_purchase.setText("");
				text_price.setText("");
				text_stock.setText("");
				fillTable(new BookInfo());
				return;
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
				return;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	/**
	 * 删除按钮事件处理
	 */
	private void deleteBook() {
		//图书删除
		String bookId=text_bookid.getText();
		if(StringUtil.isEmpty(bookId)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		BookInfo bk=new BookInfo();
		bk.setBookId(bookId);
		
		int n=JOptionPane.showConfirmDialog(null, "你确定要删除这条记录吗?");
		if(n==0) {
			try {
				if(new AllTableServiceImpl().Delete(bk)) {
					JOptionPane.showMessageDialog(null, "删除成功");
					text_bookid.setText("");
					text_bookName.setText("");
					if(comboBox_category.getItemCount()>0) {
						comboBox_category.setSelectedIndex(0);
					}
					te_author.setText("");
					text_publisher.setText("");
					text_publishDate.setText("");
					text_purchase.setText("");
					text_price.setText("");
					text_stock.setText("");
					fillTable(new BookInfo());
					return;
				}else {
					JOptionPane.showMessageDialog(null, "删除失败");
					return;
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 查询按钮处理事件
	 */
	private void findBook() {
		//图书查询
		String bookName=text_name.getText();
		String author=text_author.getText();
		BookCategory bookType=(BookCategory) comboBox_bookType.getSelectedItem();
		String categoryId=bookType.getCategoryId();
		
		BookInfo book=new BookInfo();
		book.setBookName(bookName);
		book.setAuthor(author);
		book.setCategoryId(categoryId);
		
		fillTable(book);
	}

	
	/**
	 * 初始化下拉框
	 * @param type 下拉框类型
	 */
	@SuppressWarnings("unchecked")
	private void fillBookType(String type) {
		BookCategory bc=null;
		try {
			ResultSet rs=DAOFactory.getIAllTableDAOInstance(new DatabaseConnection().getConn()).doFind(new BookCategory());
			if("search".equals(type)) {
				bc=new BookCategory();
				bc.setCategoryId("-1");
				bc.setcategoryName("请选择...");
				this.comboBox_bookType.addItem(bc);
			}
			while(rs.next()) {
				bc=new BookCategory();
				bc.setCategoryId(rs.getString("categoryId"));
				bc.setcategoryName(rs.getString("categoryName"));
				if("search".equals(type)) {
					this.comboBox_bookType.addItem(bc);
				}else 
					if("modify".equals(type)) {
					this.comboBox_category.addItem(bc);
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	
	/**
	 * 填充表格
	 * @param bk
	 */
	private void fillTable(BookInfo bk) {
		DefaultTableModel dtm=(DefaultTableModel)table_bookinfo.getModel();
		dtm.setRowCount(0);
		try {
			ResultSet rs = DAOFactory.getIAllTableDAOInstance(new DatabaseConnection().getConn()).doFind(bk);
			while(rs.next()) {
				Vector  v=new Vector();
				v.add(rs.getString("bookId"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("categoryName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("publisher"));
				v.add(rs.getDate("publishDate"));
				v.add(rs.getDouble("purchase"));
				v.add(rs.getDouble("price"));
				v.add(rs.getInt("stock"));	
				dtm.addRow(v);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
