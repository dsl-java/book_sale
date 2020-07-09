package cn.dsl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.dsl.dao.IAllTableDAO;
import cn.dsl.util.StringUtil;
import cn.dsl.vo.Admin;
import cn.dsl.vo.BookCategory;
import cn.dsl.vo.BookInfo;
import cn.dsl.vo.BookSale;
/**
 * 这是数据层所有标准操作的实现类
 * @author dsl
 *
 */
public class AllTableDAOImpl implements IAllTableDAO {

	private Connection conn;   // 数据库连接对象
	/**
	 * 实例化数据层子类对象， 同时传入一个数据库连接对象
	 * @param conn Connection连接对象，如果为null表示数据库没有打开
	 */
	public AllTableDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean doCreate(BookCategory vo) throws Exception {
		String sql = "insert into bookcategory values(?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getCategoryId());
		pstmt.setString(2, vo.getcategoryName());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doCreate(BookInfo vo) throws Exception {
		String sql = "insert into bookinfo values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getBookId());
		pstmt.setString(2, vo.getBookName());
		pstmt.setString(3, vo.getCategoryId());
		pstmt.setString(4, vo.getAuthor());
		pstmt.setString(5, vo.getPublisher());
		pstmt.setString(6, vo.getPublishDate());
		pstmt.setDouble(7, vo.getPurchase());
		pstmt.setDouble(8, vo.getPrice());
		pstmt.setInt(9, vo.getStock());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doCreate(BookSale vo) throws Exception {
		String sql = "insert into booksale values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getBookId());
		pstmt.setDouble(3, vo.getSalePrice());
		pstmt.setString(4, vo.getSaleDate());
		pstmt.setInt(5, vo.getSaleCount());
		return pstmt.executeUpdate() > 0;
	}
	
	@Override
	public boolean doCreate(Admin vo) throws Exception {
		String sql = "insert into admin values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getAdminId());
		pstmt.setString(3, vo.getPassword());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemove(BookCategory vo) throws Exception {
		String sql = "delete from bookcategory where categoryId =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getCategoryId());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doRemove(BookInfo vo) throws Exception {
		String sql = "delete from bookinfo where bookId =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getBookId());
		return pstmt.executeUpdate() > 0;
	}


	@Override
	public ResultSet doFind(BookCategory vo) throws Exception {
		StringBuffer sb = new StringBuffer("select * from bookcategory");
		if(StringUtil.isNotEmpty(vo.getcategoryName())) {
			sb.append(" where categoryName like '%"+vo.getcategoryName()+"%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}

	@Override
	public ResultSet doFind(BookInfo vo) throws Exception {
		StringBuffer sql=new StringBuffer("select * from bookinfo b,bookcategory bt where b.categoryId=bt.categoryId");
		if(StringUtil.isNotEmpty(vo.getBookName())){
			sql. append(" and bookName like '%"+vo.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(vo.getAuthor())) {
			sql. append(" and author like '%"+vo.getAuthor()+"%'");
		}
		if(vo.getCategoryId()!=null&&vo.getCategoryId()!="-1") {
			sql. append(" and b.categoryId='"+vo.getCategoryId()+"'");
		}
		System.out.println(sql);
		PreparedStatement pstmt=conn.prepareStatement(sql.toString());
		return pstmt.executeQuery();
	}
	
	@Override
	public ResultSet doFind2(BookInfo vo) throws Exception {
		StringBuffer sql=new StringBuffer("select * from booksale bs,bookinfo b where bs.bookId=b.bookId");
		if(vo.getBookId()!=null&&vo.getBookId()!="-1") {
			sql. append(" and bs.bookId='"+vo.getBookId()+"'");
		}
		System.out.println(sql);
		PreparedStatement pstmt=conn.prepareStatement(sql.toString());
		return pstmt.executeQuery();
	}

	
	@Override
	public ResultSet dofind(BookInfo vo) throws Exception{   
		StringBuffer sb = new StringBuffer("select * from bookinfo");
		if(StringUtil.isNotEmpty(vo.getBookId())) {
			sb.append(" where bookid like '%"+vo.getBookId()+"%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}

	@Override
    public ResultSet dofind(BookSale vo) throws Exception {
    	StringBuffer sb = new StringBuffer("select * from booksale");
		if(StringUtil.isNotEmpty(vo.getId())) {
			sb.append(" where id like '%"+vo.getId()+"%'");
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	@Override
	public ResultSet doFind(BookSale vo) throws Exception {
		StringBuffer sql=new StringBuffer("select * from booksale bs,bookinfo b where bs.bookId=b.bookId");
		if(vo.getBookId()!=null&&vo.getBookId()!="-1") {
			sql. append(" and bs.bookId='"+vo.getBookId()+"'");
		}
		System.out.println(sql);
		PreparedStatement pstmt=conn.prepareStatement(sql.toString());
		return pstmt.executeQuery();
	}

	@Override
	public boolean doUpdate(BookCategory vo) throws Exception {
		String sql = "update bookcategory set categoryName =? where categoryId =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getcategoryName());
		pstmt.setString(2, vo.getCategoryId());
		return pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doUpdate(BookInfo vo) throws Exception {
		String sql = "update bookinfo set bookName =?, categoryId =?, author =?, publisher =?, publishDate =?, purchase =?, price =?, stock =? where bookId =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getBookName());
		pstmt.setString(2, vo.getCategoryId());
		pstmt.setString(3, vo.getAuthor());
		pstmt.setString(4, vo.getPublisher());
		pstmt.setString(5, vo.getPublishDate());
		pstmt.setDouble(6, vo.getPurchase());
		pstmt.setDouble(7, vo.getPrice());
		pstmt.setInt(8, vo.getStock());
		pstmt.setString(9, vo.getBookId());
		return pstmt.executeUpdate() > 0;
	}
}
