package cn.dsl.service;

import java.sql.ResultSet;

import cn.dsl.vo.Admin;
import cn.dsl.vo.BookCategory;
import cn.dsl.vo.BookInfo;
import cn.dsl.vo.BookSale;
/**
 * ����ҵ���Ļ���������׼
 * @author dsl
 *
 */
public interface IAllTableService {

	/**
	 * ʵ�����ݵ����Ӳ������ڱ�����֮ǰ��Ҫʹ��IAllTableDAO�ӿ��е����·�����<br>
	 * ��������IAllTableDAO.doFind_XXX()������Ҫ���ӵ���Ϣ�Ƿ���ڡ�<br>
	 * ��������ڣ���ʹ��IAllTableDAO.doAdd_XXX���������Ϣ.
	 * @param vo ������Ҫ�������ݵ�vo����
	 * @return �������ӳɹ�����true�� ���򷵻�false
	 * @throws Exception IAllTableDAO�ӿ��е��׳��쳣
	 */
	public boolean Insert(BookCategory vo) throws Exception;
	public boolean Insert(BookInfo vo) throws Exception;
	public boolean Insert(BookSale vo) throws Exception;
	public boolean Insert(Admin vo)throws Exception;
	
	/**
	 * ʵ�����ݵ�ɾ�����������õ���IAllTableDAO.doRemove_XXX()�������˲�������ɾ��һ������¼
	 * @param vo ����Ҫɾ����������Ϣ
	 * @return ɾ���ɹ�����true�� ���򷵻�false
	 * @throws Exception IAllTableDAO�ӿ��е��׳��쳣
	 */
	public boolean Delete(BookCategory vo) throws Exception;
	public boolean Delete(BookInfo vo) throws Exception;
	
	/**
	 * ʵ�����ݵĲ�ѯ���������õ���IAllTableDAO.doFind_XXX()�������˲������ڲ�ѯ�����йؼ�¼
	 * @param vo ����Ҫ��ѯ��������Ϣ
	 * @return ���ص���һ�������
	 * @throws Exception IAllTableDAO�ӿ��е��׳��쳣
	 */
	public ResultSet Find(BookCategory vo) throws Exception;
	public ResultSet Find(BookInfo vo) throws Exception;
	public ResultSet Find(BookSale vo) throws Exception;
	
	/**
	 * ʵ�����ݵ��޸Ĳ��������õ���IAllTableDAO.doUpdate_XXX()�������˲�������ȫ���޸�
	 * @param vo ����Ҫ�޸ĵ�������Ϣ
	 * @return �޸ĳɹ�����true�� ���򷵻�false
	 * @throws Exception IAllTableDAO�ӿ��е��׳��쳣
	 */
	public boolean Update(BookCategory vo) throws Exception;
	public boolean Update(BookInfo vo) throws Exception;
}
