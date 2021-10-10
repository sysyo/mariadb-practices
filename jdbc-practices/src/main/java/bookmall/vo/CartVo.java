package bookmall.vo;

public class CartVo {
	private int bookNo;
	private int memberNo;
	private int cartQuantity;
	
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getCartQuantity() {
		return cartQuantity;
	}
	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	@Override
	public String toString() {
		return "CartVo [bookNo=" + bookNo + ", memberNo=" + memberNo + ", cartQuantity=" + cartQuantity + "]";
	}
	
	
}
