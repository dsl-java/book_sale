package cn.dsl.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import cn.dsl.dbc.DatabaseConnection;
import cn.dsl.factory.DAOFactory;
import cn.dsl.service.impl.AllTableServiceImpl;
import cn.dsl.util.StringUtil;
import cn.dsl.vo.BookCategory;
/**
 * 这是图书类别维护的操作子界面
 * @author dsl
 *
 */
@SuppressWarnings("serial")
public class BookTypeManagerFrame extends JInternalFrame {

	private JTable BookTypeTable;
	private JTextField text_bookTypeName;
	private JTextField text_id;
	private JTextField text_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManagerFrame frame = new BookTypeManagerFrame();
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
	public BookTypeManagerFrame() {
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		setToolTipText("");
		setClosable(true);
		setBounds(100, 100, 556, 633);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
					.addGap(36))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(78)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(44, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u578B\u540D\u79F0\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_bookTypeName = new JTextField();
		text_bookTypeName.setFont(new Font("宋体", Font.PLAIN, 18));
		text_bookTypeName.setColumns(10);
		
		//查询按钮
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findBookType();		
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(6)
					.addComponent(text_bookTypeName, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1))
						.addComponent(text_bookTypeName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(btnNewButton)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u56FE\u4E66\u7C7B\u578B\u7F16\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_id = new JTextField();
		text_id.setEditable(false);
		text_id.setFont(new Font("宋体", Font.PLAIN, 18));
		text_id.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u56FE\u4E66\u7C7B\u578B\u540D\u79F0\uFF1A");
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		text_name = new JTextField();
		text_name.setFont(new Font("宋体", Font.PLAIN, 18));
		text_name.setColumns(10);
		
		//修改按钮
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifyBookType();
			}
		});
		
		//删除按钮
		JButton btnNewButton_1_1 = new JButton("\u5220\u9664");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBookType();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(text_id, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(text_name, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(text_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_1_1))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		BookTypeTable = new JTable();
		BookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			//表格行单击事件
			public void mousePressed(MouseEvent e) {
				int row=BookTypeTable.getSelectedRow();
				text_id.setText((String) BookTypeTable.getValueAt(row,0));
				text_name.setText((String) BookTypeTable.getValueAt(row,1));
			}
		});
		BookTypeTable.setFont(new Font("宋体", Font.PLAIN, 18));
		BookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u56FE\u4E66\u7C7B\u578B\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u578B\u540D\u79F0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		BookTypeTable.getColumnModel().getColumn(0).setPreferredWidth(123);
		BookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(127);
		scrollPane.setViewportView(BookTypeTable);
		getContentPane().setLayout(groupLayout);
		fillTable(new BookCategory());
	}
	
	/**
	 * 修改按钮事件处理
	 */
	private void modifyBookType() {
		String id=text_id.getText();
		String name=text_name.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		if(StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "图书类型的名称不能为空！");
			return;
		}
		BookCategory bc=new BookCategory(id,name);
		try {
			if(new AllTableServiceImpl().Update(bc)) {
				JOptionPane.showMessageDialog(null, "修改成功");
				text_id.setText("");
				text_name.setText("");
				fillTable(new BookCategory());
				return;
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
				return;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

	/**
	 * 删除按钮处理事件
	 */
	private void deleteBookType() {
		//删除图书类别
		String id=text_id.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择要删除的记录");
			return;
		}
		BookCategory bc=new BookCategory();
		bc.setCategoryId(id);
		
		int n=JOptionPane.showConfirmDialog(null, "你确定要删除这条记录吗？可能对bookinfo表产生影响");
		if(n==0) {
			try {
				if(new AllTableServiceImpl().Delete(bc)) {
					JOptionPane.showMessageDialog(null, "删除成功");
					text_id.setText("");
					text_name.setText("");
					fillTable(new BookCategory());
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
	 * 查询按钮事件处理
	 */
	private void findBookType() {
		//根据图书名称查询
		String s_bookTypeName=text_bookTypeName.getText().trim();
		BookCategory bc=new BookCategory();
		bc.setcategoryName(s_bookTypeName);
		fillTable(bc);
	}

	/**
	 * 初始化表格
	 */
	private void fillTable(BookCategory bc) {
		DefaultTableModel dtm=(DefaultTableModel)BookTypeTable.getModel();
		dtm.setRowCount(0);
		try {
			ResultSet rs = DAOFactory.getIAllTableDAOInstance(new DatabaseConnection().getConn()).doFind(bc);
			while(rs.next()) {
				Vector  v=new Vector();
				v.add(rs.getString("categoryId"));
				v.add(rs.getString("categoryName"));
				dtm.addRow(v);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
