package cn.dsl.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import cn.dsl.dbc.DatabaseConnection;
import cn.dsl.factory.DAOFactory;
import cn.dsl.vo.BookInfo;
import cn.dsl.vo.BookSale;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

/**
 * 这是图书销售查询操作的子界面
 * @author dsl
 *
 */
@SuppressWarnings("serial")
public class BookSaleManagerFrame extends JInternalFrame {
	private JTable table_bookSale;
	@SuppressWarnings("rawtypes")
	private JComboBox S_bookName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookSaleManagerFrame frame = new BookSaleManagerFrame();
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
	public BookSaleManagerFrame() {
		setClosable(true);
		setTitle("\u56FE\u4E66\u9500\u552E\u67E5\u8BE2");
		setBounds(100, 100, 714, 470);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u9500\u552E\u67E5\u8BE2");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(306, Short.MAX_VALUE))
		);
		
		table_bookSale = new JTable();
		table_bookSale.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u9500\u552E\u8BB0\u5F55\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u5B9E\u9645\u552E\u4EF7", "\u9500\u552E\u65E5\u671F", "\u9500\u552E\u6570\u91CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_bookSale.getColumnModel().getColumn(0).setPreferredWidth(148);
		table_bookSale.getColumnModel().getColumn(1).setPreferredWidth(202);
		table_bookSale.getColumnModel().getColumn(2).setPreferredWidth(111);
		table_bookSale.getColumnModel().getColumn(3).setPreferredWidth(177);
		table_bookSale.getColumnModel().getColumn(4).setPreferredWidth(131);
		table_bookSale.setFont(new Font("宋体", Font.PLAIN, 18));
		scrollPane.setViewportView(table_bookSale);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
	    S_bookName = new JComboBox();
		S_bookName.setFont(new Font("宋体", Font.PLAIN, 18));
		
		//查询
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FindSaleBook();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(114)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(S_bookName, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(89))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(S_bookName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		fillBookName("search");
		fillTable(new BookSale());
	}

	/**
	 * 查询事件处理
	 */
	private void FindSaleBook() {
		BookInfo bookName=(BookInfo) S_bookName.getSelectedItem();
		String bookId=bookName.getBookId();
		
		BookSale bs=new BookSale();
		bs.setBookId(bookId);
		
		fillTable(bs);
	}
	
	/**
	 * 初始化下拉框
	 * @param type 下拉框类型
	 */
	@SuppressWarnings("unchecked")
	private void fillBookName(String type) {
		BookInfo bk=null;
		try {
			ResultSet rs=DAOFactory.getIAllTableDAOInstance(new DatabaseConnection().getConn()).doFind2(new BookInfo());
			if("search".equals(type)) {
				bk=new  BookInfo();
				bk.setBookId("-1");
				bk.setBookName("请选择...");
				this.S_bookName.addItem(bk);
			}
			while(rs.next()) {
				bk=new BookInfo();
				bk.setBookId(rs.getString("bookId"));
				bk.setBookName(rs.getString("bookName"));
				if("search".equals(type)) {
					this.S_bookName.addItem(bk);
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
	private void fillTable(BookSale bs) {
		DefaultTableModel dtm=(DefaultTableModel)table_bookSale.getModel();
		dtm.setRowCount(0);
		try {
			ResultSet rs = DAOFactory.getIAllTableDAOInstance(new DatabaseConnection().getConn()).doFind(bs);
			while(rs.next()) {
				Vector  v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getDouble("salePrice"));
				v.add(rs.getString("saleDate"));
				v.add(rs.getInt("saleCount"));
				dtm.addRow(v);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
