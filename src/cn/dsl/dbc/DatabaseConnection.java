package cn.dsl.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * ����һ���������ݿ�Ĺ�����
 * @author dsl
 *
 */
public class DatabaseConnection {

	private static final String DriverName = "com.mysql.jdbc.Driver";   // MySQL��������
	private static final String DBUrl = "jdbc:mysql://localhost:3306/book_sales?useSSL=true";   // ���ݿ����ӵ�ַ
	private static final String DBUsername = "root";   // �û���
	private static final String DBPassword = "123456";   // ����
	private Connection conn = null;
	
	/**
	 * �������ݿ�����
	 */
	public DatabaseConnection() {
		try {
			// �������ݿ���������
			Class.forName(DriverName);
			this.conn = DriverManager.getConnection(DBUrl, DBUsername, DBPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}
	
	/**
	 * ��ȡ���ݿ�����
	 * @return   �������ݿ����Ӷ���
	 */
	public Connection getConn(){
		return this.conn;
	}
	
	/**
	 * �ر����ݿ�����
	 */
	public void closeCon(){
		if(this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
