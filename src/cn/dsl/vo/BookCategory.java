package cn.dsl.vo;
/**
 * 这是图书类型的实体类
 * @author dsl
 *
 */
public class BookCategory {

	private String categoryId;//图书类型编号
	private String categoryName;//图书类型名称
	
	public BookCategory() {
		super();
	}
	
	public BookCategory(String categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getcategoryName() {
		return categoryName;
	}
	public void setcategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return categoryName;
	}
}
