package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVo;

public class OrderDaoTest {
	public static void main(String[] args) {
//		insertTest();
		findAllTest();
	}
	
	private static void findAllTest() {
		List<OrderVo> list = new OrderDao().findAll();
		for (OrderVo vo : list) {
			System.out.println(vo);
		}
	} 
	
	private static void insertTest() {
		OrderVo vo = null;
		OrderDao dao = new OrderDao();	
		vo = new OrderVo();
		vo.setBookNo(1);
		vo.setPayment(16200); 
		vo.setAddress("부산시 해운대구 중동 132");
		vo.setMemberNo(1);
		dao.insert(vo);
	}
	
}