package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bookmall.vo.OrderVo;

public class OrderDao {

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
	public boolean insert(OrderVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "insert into orders values(null,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			// 4. binding
			pstmt.setInt(1, vo.getBookNo());
			pstmt.setInt(2, vo.getPayment());
			pstmt.setString(3, vo.getAddress());
			pstmt.setInt(4, vo.getMemberNo());

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
	public List<OrderVo> findAll() {
		List<OrderVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "select o.orderNo, o.bookNo, o.payment, o.address, o.memberNo "
					+ "from orders o, member m "
					+ "where o.memberNo = m.memberNo";

			pstmt = conn.prepareStatement(sql);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int orderNo = rs.getInt(1);
				int bookNo = rs.getInt(2);
				int payment = rs.getInt(3);
				String address = rs.getString(4);
				int memberNo = rs.getInt(5);

				OrderVo vo = new OrderVo();
				vo.setOrderNo(orderNo);
				vo.setBookNo(bookNo);
				vo.setPayment(payment);
				vo.setAddress(address);
				vo.setMemberNo(memberNo);

				result.add(vo);

			}

		} catch (SQLException e) {
			System.out.println("error:" + e);

		} finally {
			// clean up
			try {
				if (rs != null) {
					rs.close();
				}
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

}
