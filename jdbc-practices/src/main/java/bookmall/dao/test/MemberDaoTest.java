package bookmall.dao.test;

import java.util.List;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {
		public static void main(String[] args) {
//			insertTest();
			findAllTest();
		}
		
		private static void findAllTest() {
			List<MemberVo> list = new MemberDao().findAll();
			for (MemberVo vo : list) {
				System.out.println(vo);
			}
		}
		
		private static void insertTest() {
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
	}
