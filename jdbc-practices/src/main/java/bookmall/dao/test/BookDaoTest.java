package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
//		insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}

	private static void insertTest() {
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

}