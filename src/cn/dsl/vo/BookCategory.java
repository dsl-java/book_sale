package cn.dsl.vo;
/**
 * ����ͼ�����͵�ʵ����
 * @author dsl
 *
 */
public class BookCategory {

	private String categoryId;//ͼ�����ͱ��
	private String categoryName;//ͼ����������
	
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
