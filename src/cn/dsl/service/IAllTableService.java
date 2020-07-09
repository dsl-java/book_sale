package cn.dsl.service;

import java.sql.ResultSet;

import cn.dsl.vo.Admin;
import cn.dsl.vo.BookCategory;
import cn.dsl.vo.BookInfo;
import cn.dsl.vo.BookSale;
/**
 * 这是业务层的基本操作标准
 * @author dsl
 *
 */
public interface IAllTableService {

	/**
	 * 实现数据的增加操作，在本操作之前需要使用IAllTableDAO接口中的如下方法：<br>
	 * 首先利用IAllTableDAO.doFind_XXX()方法看要增加的信息是否存在。<br>
	 * 如果不存在，则使用IAllTableDAO.doAdd_XXX方法添加信息.
	 * @param vo 包含了要增加数据的vo对象
	 * @return 数据增加成功返回true， 否则返回false
	 * @throws Exception IAllTableDAO接口中的抛出异常
	 */
	public boolean Insert(BookCategory vo) throws Exception;
	public boolean Insert(BookInfo vo) throws Exception;
	public boolean Insert(BookSale vo) throws Exception;
	public boolean Insert(Admin vo)throws Exception;
	
	/**
	 * 实现数据的删除操作，调用的是IAllTableDAO.doRemove_XXX()方法，此操作属于删除一整条记录
	 * @param vo 包含要删除的数据信息
	 * @return 删除成功返回true， 否则返回false
	 * @throws Exception IAllTableDAO接口中的抛出异常
	 */
	public boolean Delete(BookCategory vo) throws Exception;
	public boolean Delete(BookInfo vo) throws Exception;
	
	/**
	 * 实现数据的查询操作，调用的是IAllTableDAO.doFind_XXX()方法，此操作属于查询所有有关记录
	 * @param vo 包含要查询的数据信息
	 * @return 返回的是一个结果集
	 * @throws Exception IAllTableDAO接口中的抛出异常
	 */
	public ResultSet Find(BookCategory vo) throws Exception;
	public ResultSet Find(BookInfo vo) throws Exception;
	public ResultSet Find(BookSale vo) throws Exception;
	
	/**
	 * 实现数据的修改操作，调用的是IAllTableDAO.doUpdate_XXX()方法，此操作属于全部修改
	 * @param vo 包含要修改的数据信息
	 * @return 修改成功返回true， 否则返回false
	 * @throws Exception IAllTableDAO接口中的抛出异常
	 */
	public boolean Update(BookCategory vo) throws Exception;
	public boolean Update(BookInfo vo) throws Exception;
}
