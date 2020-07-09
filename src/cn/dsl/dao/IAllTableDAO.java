package cn.dsl.dao;

import java.sql.ResultSet;

import cn.dsl.vo.Admin;
import cn.dsl.vo.BookCategory;
import cn.dsl.vo.BookInfo;
import cn.dsl.vo.BookSale;

/**
 * ���Ƕ������ݱ�����ݲ�����׼
 * @author dsl
 *
 */
public interface IAllTableDAO {

	/**
	 * ���ݵ����Ӳ�����ִ�е���insert���
	 * @param vo ������Ҫ���ӵ�������Ϣ
	 * @return ����������ӳɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ�����֡�NullPointerException�������SQL�������׳���SQLException��
	 */
	public boolean doCreate(BookCategory vo) throws Exception;
	public boolean doCreate(BookInfo vo) throws Exception;
	public boolean doCreate(BookSale vo) throws Exception;
	public boolean doCreate(Admin vo) throws Exception;
	
	/**
	 * ���ݵ�ɾ��������ִ�е���delete���
	 * @param vo ������Ҫɾ����������Ϣ
	 * @return �������ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ�����֡�NullPointerException�������SQL�������׳���SQLException��
	 */
	public boolean doRemove(BookCategory vo) throws Exception;
	public boolean doRemove(BookInfo vo) throws Exception;
	
	/**
	 * ���ݵĲ��Ҳ�����ִ�е���select���
	 * @param vo ������Ҫ���ҵ�������Ϣ
	 * @return ����һ���������
	 * @throws Exception ������ݿ�û�����ӣ�����֡�NullPointerException�������SQL�������׳���SQLException��
	 */
	public ResultSet doFind(BookCategory vo) throws Exception;
	public ResultSet doFind(BookInfo vo) throws Exception;
	public ResultSet doFind(BookSale vo) throws Exception;
	public ResultSet dofind(BookInfo vo) throws Exception;
	public ResultSet dofind(BookSale vo) throws Exception;
	public ResultSet doFind2(BookInfo vo) throws Exception;
	
	/**
	 * ���ݵ��޸Ĳ�����ִ�е���update��䣬���ε��޸ĻὫ�������ݽ��б��
	 * @param vo ������Ҫ�޸ĵ�������Ϣ
	 * @return �����޸ĳɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ�����֡�NullPointerException�������SQL�������׳���SQLException��
	 */
	public boolean doUpdate(BookCategory vo) throws Exception;
	public boolean doUpdate(BookInfo vo) throws Exception;
	
}
