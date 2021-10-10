package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;
import bookmall.vo.OrderCartDTO;

public class CartDaoTest {
	public static void main(String[] args) {
		insertTest();
//		findAllTest();
	}
	
	private static void findAllTest() {
		List<OrderCartDTO> list = new CartDao().findAll();
		for (OrderCartDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	private static void insertTest() {
		CartVo vo = null;
		CartDao dao = new CartDao();
	
		vo = new CartVo();
		vo.setBookNo(3);
		vo.setMemberNo(1);
		vo.setCartQuantity(1);
		dao.insert(vo);
		
	}
}