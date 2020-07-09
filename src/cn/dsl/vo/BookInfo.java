package cn.dsl.vo;
/**
 * 这是图书基本信息的实体类
 * @author dsl
 *
 */
public class BookInfo {

	private String bookId;//图书编号
	private String bookName;//图书名称
	private String categoryId;//图书类型编号
	private String author;//作者
	private String publisher;//出版社
	private String publishDate;//出版日期
	private double purchase;//进价
	private double price;//售价
	private int stock;//库存
	
	public BookInfo() {
		super();
	}
	public BookInfo(String bookId, String bookName, String categoryId, String author, String publisher,
			String publishDate, Double purchase, Double price, Integer stock) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.categoryId = categoryId;
		this.author = author;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.purchase = purchase;
		this.price = price;
		this.stock = stock;
	}
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public Double getPurchase() {
		return purchase;
	}
	public void setPurchase(Double purchase) {
		this.purchase = purchase;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return bookName;
	}
}
