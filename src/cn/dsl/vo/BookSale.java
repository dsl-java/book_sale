package cn.dsl.vo;

/**
 * 这是图书销售记录实体类
 * @author dsl
 *
 */
public class BookSale {

	private String id;
	private String bookId;
	private double salePrice;
	private String saleDate;
	private int saleCount;
	
	public BookSale() {
		super();
	}
	
	public BookSale(String id, String bookId, double salePrice, String saleDate, int saleCount) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.salePrice = salePrice;
		this.saleDate = saleDate;
		this.saleCount = saleCount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public int getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
}
