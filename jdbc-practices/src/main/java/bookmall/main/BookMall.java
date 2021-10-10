package bookmall.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderBookDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderBookDTO;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderCartDTO;
import bookmall.vo.OrderVo;

public class BookMall {

	public static void main(String[] args) {
//		insertMember();
//		insertCategory();
//		insertBook();
//		insertOrder();
//		insertCart();
//		insertOrderBook();

		displayMemberInfo();
		displayCategoryInfo();
		displayBookInfo();
		dispalyOrderInfo();
		displayCartInfo();
		displayOrderBookInfo();
	}

	// ===================== insert ============================
	// --------------- insertMember() ----------------------
	private static void insertMember() {
		MemberVo vo = null;
		MemberDao dao = new MemberDao();

		vo = new MemberVo();
		vo.setMemberName("둘리");
		vo.setMemberEmail("dooli@gmail.com");
		vo.setMemberPass("1234");
		vo.setMemberPhone("01012345678");
		dao.insert(vo);

		vo = new MemberVo();
		vo.setMemberName("또치");
		vo.setMemberEmail("ddochi@gmail.com");
		vo.setMemberPass("4567");
		vo.setMemberPhone("01023457865");
		dao.insert(vo);

	}

	// --------------- insertCategory() ----------------------
	private static void insertCategory() {
		CategoryVo vo = null;
		CategoryDao dao = new CategoryDao();

		vo = new CategoryVo();
		vo.setCategoryName("인문");
		dao.insert(vo);

		vo = new CategoryVo();
		vo.setCategoryName("소설");
		dao.insert(vo);

		vo = new CategoryVo();
		vo.setCategoryName("경제/경영");
		dao.insert(vo);

		vo = new CategoryVo();
		vo.setCategoryName("정치/사회");
		dao.insert(vo);

		vo = new CategoryVo();
		vo.setCategoryName("컴퓨터/IT");
		dao.insert(vo);

	}

	// --------------- insertBook() ----------------------
	private static void insertBook() {
		BookVo vo = null;
		BookDao dao = new BookDao();

		vo = new BookVo();
		vo.setBookName("소크라테스 익스프레스");
		vo.setBookPrice(16200);
		vo.setCategoryNo(1);
		dao.insert(vo);

		vo = new BookVo();
		vo.setBookName("작별하지 않는다");
		vo.setBookPrice(12600);
		vo.setCategoryNo(2);
		dao.insert(vo);

		vo = new BookVo();
		vo.setBookName("트렌드 코리아 2022");
		vo.setBookPrice(16200);
		vo.setCategoryNo(3);
		dao.insert(vo);

		vo = new BookVo();
		vo.setBookName("지구를 위한다는 착각");
		vo.setBookPrice(19800);
		vo.setCategoryNo(4);
		dao.insert(vo);

		vo = new BookVo();
		vo.setBookName("해커와 화가");
		vo.setBookPrice(16200);
		vo.setCategoryNo(5);
		dao.insert(vo);

	}

	// --------------- insertOrder() ----------------------
	private static void insertOrder() {
		OrderVo vo = null;
		OrderDao dao = new OrderDao();
		vo = new OrderVo();
		vo.setBookNo(1);
		vo.setPayment(16200);
		vo.setAddress("부산시 해운대구 중동 132");
		vo.setMemberNo(1);
		dao.insert(vo);
	}

	// --------------- insertCart() ----------------------
	private static void insertCart() {
		CartVo vo = null;
		CartDao dao = new CartDao();

		vo = new CartVo();
		vo.setBookNo(3);
		vo.setMemberNo(1);
		vo.setCartQuantity(1);
		dao.insert(vo);

	}

	// --------------- insertOrderBook() ----------------------
	private static void insertOrderBook() {
		OrderBookVo vo = null;
		OrderBookDao dao = new OrderBookDao();

		vo = new OrderBookVo();
		vo.setOrderNo(1);
		vo.setBookNo(1);
		vo.setOrderQuantity(1);
		vo.setBookPrice(16200);
		dao.insert(vo);
	}

	// ===================== select ============================
	// --------------- selectMember ----------------------
	private static void displayMemberInfo() {
		System.out.println("****** 회원 정보 출력 ******");
		List<MemberVo> list = new MemberDao().findAll();

		for (MemberVo member : list) {
			String info = String.format("[%d] 이름 : %s, 이메일 : %s, 전화번호 : %s", member.getMemberNo(),
					member.getMemberName(), member.getMemberEmail(), member.getMemberPhone());

			System.out.println(info);
		}
		System.out.println();
	}
	

	// --------------- selectCategory ----------------------
	private static void displayCategoryInfo() {
		System.out.println("****** 카테고리 정보 출력 ******");
		List<CategoryVo> list = new CategoryDao().findAll();

		for (CategoryVo vo : list) {
			String info = String.format("[%d] 카테고리 : %s", vo.getCategoryNo(), vo.getCategoryName());
			System.out.println(info);
		}
		System.out.println();
	}

	
	// --------------- selectBook ----------------------
	private static void displayBookInfo() {
		System.out.println("***** 도서 정보 출력 *****");

		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			String info = String.format("[%d] 제목 : %s, 가격 : %d원", vo.getBookNo(), vo.getBookName(), vo.getBookPrice());
			System.out.println(info);
		}
		System.out.println();
	}
	
	
	// --------------- selectOrder ----------------------
	private static void dispalyOrderInfo() {
		System.out.println("****** 주문 정보 출력 ******");
		List<OrderVo> list = new OrderDao().findAll();
		for (OrderVo vo : list) {
			String info = String.format("주문번호 : %d, 책번호 : %d, 가격 : %d원, 주소 : %s, 회원번호 : %d", vo.getOrderNo(),
					vo.getBookNo(), vo.getPayment(), vo.getAddress(), vo.getMemberNo());
			System.out.println(info);
		}
		System.out.println();
	}

	
	// --------------- selectCart ----------------------
	private static void displayCartInfo() {
		System.out.println("****** 장바구니 정보 출력 ******");
		List<OrderCartDTO> list = new CartDao().findAll();
		for (OrderCartDTO dto : list) {
			String info = String.format("이름 : %s, 책 제목 : %s, 수량 : %d개, 총가격 : %d", dto.getMemberName(), dto.getBookName(),
					dto.getCartQuantity(), dto.getCartQuantity() * dto.getBookPrice());
			System.out.println(info);
		}
		System.out.println();
	}

	
	// --------------- selectOrderBook ----------------------
	private static void displayOrderBookInfo() {
		System.out.println("****** 주문 도서 정보 출력 ******");
		List<OrderBookDTO> list = new OrderBookDao().findAll();
		for (OrderBookDTO dto : list) {
			String info = String.format("도서번호 : %d, 도서제목 : %s, 수량 : %d개", dto.getBookNo(), dto.getBookName(),
					dto.getOrderQuantity());
			System.out.println(info);
		}
		System.out.println();
	}
}
