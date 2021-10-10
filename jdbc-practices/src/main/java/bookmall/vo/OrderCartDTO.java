package bookmall.vo;

public class OrderCartDTO {

	// orderBook 과 cart join문 써야하기 때문에
	// DTO가 따로 필요하다
	private String memberName;
	private String bookName;
	private int cartQuantity;
	private int bookPrice;
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getCartQuantity() {
		return cartQuantity;
	}
	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "OrderCartDTO [memberName=" + memberName + ", bookName=" + bookName + ", cartQuantity=" + cartQuantity
				+ ", bookPrice=" + bookPrice + "]";
	}
	
	
}
