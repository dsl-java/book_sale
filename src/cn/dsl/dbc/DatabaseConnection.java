package cn.dsl.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 这是一个连接数据库的工具类
 * @author dsl
 *
 */
public class DatabaseConnection {

	private static final String DriverName = "com.mysql.jdbc.Driver";   // MySQL驱动程序
	private static final String DBUrl = "jdbc:mysql://localhost:3306/book_sales?useSSL=true";   // 数据库连接地址
	private static final String DBUsername = "root";   // 用户名
	private static final String DBPassword = "123456";   // 密码
	private Connection conn = null;
	
	/**
	 * 加载数据库驱动
	 */
	public DatabaseConnection() {
		try {
			// 加载数据库驱动程序
			Class.forName(DriverName);
			this.conn = DriverManager.getConnection(DBUrl, DBUsername, DBPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}
	
	/**
	 * 获取数据库连接
	 * @return   返回数据库连接对象
	 */
	public Connection getConn(){
		return this.conn;
	}
	
	/**
	 * 关闭数据库连接
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
