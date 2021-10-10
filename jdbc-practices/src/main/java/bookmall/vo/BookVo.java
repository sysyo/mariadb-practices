package bookmall.vo;

public class BookVo {
	private int bookNo;
	private String bookName;
	private int bookPrice;
	private int categoryNo;
	
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	@Override
	public String toString() {
		return "BookVo [bookNo=" + bookNo + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", categoryNo="
				+ categoryNo + "]";
	}
	
	
	
}
