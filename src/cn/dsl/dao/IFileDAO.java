package cn.dsl.dao;

import java.io.IOException;
import java.util.ArrayList;
/**
 * 这是文件的的操作方法，增删改查
 * @author dsl
 *
 * @param <T>  要操作的数据类型
 */
public interface IFileDAO<T> {

	 /**
	  * 添加功能:添加信息到文件  
	  * @param vo   T类的集合
	  * @param filename   存储信息的文件
	  * @throws IOException   可能的抛出异常
	  */
	public abstract boolean Insert(ArrayList<T> vo,String filename) throws IOException;
	
	/**
	 * 删除功能：将指定的记录从文件内删除
	 * @param vo   T类的集合
	 * @param key  要指定删除的主键信息
	 * @return   删除成功返回true，否则返回false
	 * @throws IOException   可能的抛出异常
	 */
	public abstract boolean Delete(ArrayList <T> vo, String key) throws IOException;
	
	/**
	 * 修改功能：将指定的记录在文件内进行修改
	 * @param vo   T类的集合
	 * @param name   要修改的用户名
	 * @param key   要修改的密码
	 * @throws IOException   可能的抛出异常
	 */
	public abstract boolean Modify(ArrayList <T> vo,String name, String key) throws IOException;
	
	/**
	 * 查询功能：根据用户名，从文件内查询相应内容
	 * @param vo   T类的集合
	 * @param name 要查询的用户名
	 * @param key  要查询的密码
	 * @return   查询到记录返回true，否则返回false
	 */
	public abstract boolean Find(ArrayList <T> vo, String name, String key);
}
