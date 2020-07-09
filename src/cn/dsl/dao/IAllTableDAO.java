package cn.dsl.dao;

import java.sql.ResultSet;

import cn.dsl.vo.Admin;
import cn.dsl.vo.BookCategory;
import cn.dsl.vo.BookInfo;
import cn.dsl.vo.BookSale;

/**
 * 这是定义数据表的数据操作标准
 * @author dsl
 *
 */
public interface IAllTableDAO {

	/**
	 * 数据的增加操作，执行的是insert语句
	 * @param vo 包含了要增加的数据信息
	 * @return 如果数据增加成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现“NullPointerException”，如果SQL语句错误抛出“SQLException”
	 */
	public boolean doCreate(BookCategory vo) throws Exception;
	public boolean doCreate(BookInfo vo) throws Exception;
	public boolean doCreate(BookSale vo) throws Exception;
	public boolean doCreate(Admin vo) throws Exception;
	
	/**
	 * 数据的删除操作，执行的是delete语句
	 * @param vo 包含了要删除的数据信息
	 * @return 如果数据删除成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现“NullPointerException”，如果SQL语句错误抛出“SQLException”
	 */
	public boolean doRemove(BookCategory vo) throws Exception;
	public boolean doRemove(BookInfo vo) throws Exception;
	
	/**
	 * 数据的查找操作，执行的是select语句
	 * @param vo 包含了要查找的数据信息
	 * @return 返回一个结果集合
	 * @throws Exception 如果数据库没有连接，则出现“NullPointerException”，如果SQL语句错误抛出“SQLException”
	 */
	public ResultSet doFind(BookCategory vo) throws Exception;
	public ResultSet doFind(BookInfo vo) throws Exception;
	public ResultSet doFind(BookSale vo) throws Exception;
	public ResultSet dofind(BookInfo vo) throws Exception;
	public ResultSet dofind(BookSale vo) throws Exception;
	public ResultSet doFind2(BookInfo vo) throws Exception;
	
	/**
	 * 数据的修改操作，执行的是update语句，本次的修改会将所有数据进行变更
	 * @param vo 包含了要修改的数据信息
	 * @return 数据修改成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现“NullPointerException”，如果SQL语句错误抛出“SQLException”
	 */
	public boolean doUpdate(BookCategory vo) throws Exception;
	public boolean doUpdate(BookInfo vo) throws Exception;
	
}
