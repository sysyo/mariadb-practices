package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrderBookDao;
import bookmall.vo.OrderBookDTO;
import bookmall.vo.OrderBookVo;

public class OrderBookDaoTest {
	public static void main(String[] args) {
//		insertTest();
		findAllTest();
	}
	
	private static void findAllTest() {
		List<OrderBookDTO> list = new OrderBookDao().findAll();
		for (OrderBookDTO dto : list) {
			System.out.println(dto);
		}
	} 
	
	private static void insertTest() {
		OrderBookVo vo = null;
		OrderBookDao dao = new OrderBookDao();	
		
		vo = new OrderBookVo();
		vo.setOrderNo(1);
		vo.setBookNo(1);
		vo.setOrderQuantity(1);
		vo.setBookPrice(16200);
		dao.insert(vo);
	}
	
}