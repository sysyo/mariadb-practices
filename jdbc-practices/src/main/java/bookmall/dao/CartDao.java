package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bookmall.vo.CartVo;
import bookmall.vo.OrderCartDTO;

public class CartDao {

	// ================== Connection ===================
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			// 1. JDBC Driver 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		}

		return conn;

	}

	// ================== insert ===================
	public boolean insert(CartVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "insert into cart values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. binding
			pstmt.setInt(1, vo.getBookNo());
			pstmt.setInt(2, vo.getMemberNo());
			pstmt.setInt(3, vo.getCartQuantity());

			// 5. SQL 실행
			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// clean up
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}

	// ================== select ===================
	public List<OrderCartDTO> findAll() {
		List<OrderCartDTO> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			// 3. SQL 준비
			String sql = "select m.memberName, b.bookName, c.cartQuantity, b.bookPrice "
					+ "from cart c, book b, member m "
					+ "where c.bookNo = b.bookNo "
					+ "and c.memberNo = m.memberNo";
			
			pstmt = conn.prepareStatement(sql);
			
			//5. SQL 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String memberName = rs.getString(1);
				String bookName = rs.getString(2);
				int cartQuantity = rs.getInt(3);
				int bookPrice = rs.getInt(4);
				
				OrderCartDTO dto = new OrderCartDTO();
				dto.setMemberName(memberName);
				dto.setBookName(bookName);
				dto.setCartQuantity(cartQuantity);
				dto.setBookPrice(bookPrice);
				
				result.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
			
		} finally {
			// clean up
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}

}
