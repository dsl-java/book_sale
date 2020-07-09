package cn.dsl.vo;
/**
 * 这是管理员的实体类
 * @author dsl
 *
 */
public class Admin {

	private String id;
	private String adminId;
	private String password;
	
	public Admin() {
		super();
	}
	
	public Admin(String id, String adminId, String password) {
		super();
		this.id = id;
		this.adminId = adminId;
		this.password = password;
	}
	
	public Admin(String adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
