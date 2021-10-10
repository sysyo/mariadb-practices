package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrderBookDTO;
import bookmall.vo.OrderBookVo;

public class OrderBookDao {

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
	public boolean insert(OrderBookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "insert into orderBook values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩(binding)
			pstmt.setInt(1, vo.getOrderNo());
			pstmt.setInt(2, vo.getBookNo());
			pstmt.setInt(3, vo.getOrderQuantity());
			pstmt.setInt(4, vo.getBookPrice());

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
	public List<OrderBookDTO> findAll() {
		List<OrderBookDTO> result = new ArrayList<OrderBookDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "select b.bookNo, b.bookName, o.orderQuantity " 
					+ "from book b, orderBook o "
					+ "where b.bookNo = o.bookNo ";
			pstmt = conn.prepareStatement(sql);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int bookNo = rs.getInt(1);
				String bookName = rs.getString(2);
				int orderQuantity = rs.getInt(3);

				OrderBookDTO obDTO = new OrderBookDTO();
				obDTO.setBookNo(bookNo);
				obDTO.setBookName(bookName);
				obDTO.setOrderQuantity(orderQuantity);
				result.add(obDTO);
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