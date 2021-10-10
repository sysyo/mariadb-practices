package bookmall.vo;

public class OrderBookDTO {
	private int bookNo;
	private String bookName;
	private int orderQuantity;
	
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
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	@Override
	public String toString() {
		return "OrderBookDTO [bookNo=" + bookNo + ", bookName=" + bookName + ", orderQuantity=" + orderQuantity + "]";
	}
	
	
}
