package cn.dsl.dao;

import java.io.IOException;
import java.util.ArrayList;
/**
 * �����ļ��ĵĲ�����������ɾ�Ĳ�
 * @author dsl
 *
 * @param <T>  Ҫ��������������
 */
public interface IFileDAO<T> {

	 /**
	  * ��ӹ���:�����Ϣ���ļ�  
	  * @param vo   T��ļ���
	  * @param filename   �洢��Ϣ���ļ�
	  * @throws IOException   ���ܵ��׳��쳣
	  */
	public abstract boolean Insert(ArrayList<T> vo,String filename) throws IOException;
	
	/**
	 * ɾ�����ܣ���ָ���ļ�¼���ļ���ɾ��
	 * @param vo   T��ļ���
	 * @param key  Ҫָ��ɾ����������Ϣ
	 * @return   ɾ���ɹ�����true�����򷵻�false
	 * @throws IOException   ���ܵ��׳��쳣
	 */
	public abstract boolean Delete(ArrayList <T> vo, String key) throws IOException;
	
	/**
	 * �޸Ĺ��ܣ���ָ���ļ�¼���ļ��ڽ����޸�
	 * @param vo   T��ļ���
	 * @param name   Ҫ�޸ĵ��û���
	 * @param key   Ҫ�޸ĵ�����
	 * @throws IOException   ���ܵ��׳��쳣
	 */
	public abstract boolean Modify(ArrayList <T> vo,String name, String key) throws IOException;
	
	/**
	 * ��ѯ���ܣ������û��������ļ��ڲ�ѯ��Ӧ����
	 * @param vo   T��ļ���
	 * @param name Ҫ��ѯ���û���
	 * @param key  Ҫ��ѯ������
	 * @return   ��ѯ����¼����true�����򷵻�false
	 */
	public abstract boolean Find(ArrayList <T> vo, String name, String key);
}
