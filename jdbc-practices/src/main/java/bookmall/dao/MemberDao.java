package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.MemberVo;

public class MemberDao {
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
	public boolean insert(MemberVo vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "insert into member values (null,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			// 4. binding
			pstmt.setString(1, vo.getMemberName());
			pstmt.setString(2, vo.getMemberEmail());
			pstmt.setString(3, vo.getMemberPass());
			pstmt.setString(4, vo.getMemberPhone());
			
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
	public List<MemberVo> findAll() {
		List<MemberVo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			// 3. SQL 준비
			String sql = "select memberNo, memberName, memberEmail, memberPass, memberPhone " 
					+ "from member";

			pstmt = conn.prepareStatement(sql);

			// 5. SQL 실행
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int memberNo = rs.getInt(1);
				String memberName = rs.getString(2);
				String memberEmail = rs.getString(3);
				String memberPass = rs.getString(4);
				String memberPhone = rs.getString(5);
				
				MemberVo vo = new MemberVo();
				vo.setMemberNo(memberNo);
				vo.setMemberName(memberName);
				vo.setMemberEmail(memberEmail);
				vo.setMemberPass(memberPass);
				vo.setMemberPhone(memberPhone);

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
