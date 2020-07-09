package cn.dsl.factory;

import java.sql.Connection;

import cn.dsl.dao.IAllTableDAO;
import cn.dsl.dao.impl.AllTableDAOImpl;
/**
 * 这是数据层的工厂类
 * @author dsl
 *
 */
public class DAOFactory {

	/**
	 * 得到IAllTableDAO接口的所有操作，调用其接口实现类，执行相应操作以实现对数据库的增删查改操作
	 * @param conn  数据库连接
	 * @return   返回IAllTableDAO接口的实现类
	 */
	public static IAllTableDAO getIAllTableDAOInstance(Connection conn) {
		return new AllTableDAOImpl(conn);
	}
}
