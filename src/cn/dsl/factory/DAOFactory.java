package cn.dsl.factory;

import java.sql.Connection;

import cn.dsl.dao.IAllTableDAO;
import cn.dsl.dao.impl.AllTableDAOImpl;
/**
 * �������ݲ�Ĺ�����
 * @author dsl
 *
 */
public class DAOFactory {

	/**
	 * �õ�IAllTableDAO�ӿڵ����в�����������ӿ�ʵ���ִ࣬����Ӧ������ʵ�ֶ����ݿ����ɾ��Ĳ���
	 * @param conn  ���ݿ�����
	 * @return   ����IAllTableDAO�ӿڵ�ʵ����
	 */
	public static IAllTableDAO getIAllTableDAOInstance(Connection conn) {
		return new AllTableDAOImpl(conn);
	}
}
