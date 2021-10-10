package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.BookVo;

public class BookDao {

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
	public boolean insert(BookVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "insert into book values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. binding
			pstmt.setString(1, vo.getBookName());
			pstmt.setInt(2, vo.getBookPrice());
			pstmt.setInt(3, vo.getCategoryNo());

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
	public List<BookVo> findAll() {
		List<BookVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			// 3. SQL 준비
			String sql = "select b.bookNo, b.bookName, b.bookPrice, b.categoryNo "
					+ "from book b, category c " 
					+ "where b.categoryNo = c.categoryNo";
		
			pstmt = conn.prepareStatement(sql);

			//5. SQL 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bookNo = rs.getInt(1);
				String bookName = rs.getString(2);
				int bookPrice = rs.getInt(3);
				int categoryNo = rs.getInt(4);
				
				BookVo vo = new BookVo();
				vo.setBookNo(bookNo);
				vo.setBookName(bookName);
				vo.setBookPrice(bookPrice);
				vo.setCategoryNo(categoryNo);
				
				result.add(vo);
				
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
