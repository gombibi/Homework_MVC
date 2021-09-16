package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.bit.dto.Member;
import kr.or.bit.utils.ConnectionHelper;

/*
DB작업
CRUD 작업을 하기위한 함수를 생성하는 곳

memo table 에 데이터 에 대해서
전제조회 : select id, email ,content from memo
조건조회 : select id, email ,content from memo where id=?
수정 : update memo set email=? , content=? where id=?
삭제 : delete from memo where id=?
삽입 : insert into memo(id,email,content) values(?,?,?)
*/
public class MemberDao {

	// Insert
	public int insertMember(Member m) {
		Connection conn = null;// 추가
		int resultrow = 0;
		PreparedStatement pstmt = null;

		try {
			conn = ConnectionHelper.getConnection("oracle");// 추가

			String sql = "insert into koreamember(id,pwd,name,age,gender,email,ip) values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setInt(4, m.getAge());
			pstmt.setString(5, m.getGender());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getIp());

			resultrow = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Insert : " + e.getMessage());
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
			try {
				conn.close(); // 반환하기
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultrow;
	}

	public boolean checkIdPwd(String id, String pwd) {
		Connection conn = null;// 추가
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean loginok = false;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");// 추가
			String sql = "select id, pwd from koreamember where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (pwd.equals(rs.getString("pwd"))) {
					// ID 존재
					loginok = true;
				} else {
					loginok = false;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		try {
			conn.close();// 반환하기
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return loginok;
	}
	
	//회원 목록(리스트) 출력
	//목록 (select id, ip from koreamember)
public ArrayList<Member> getMemberList() throws SQLException{
		
		Connection conn = ConnectionHelper.getConnection("oracle"); //객체 얻기
		
		PreparedStatement pstmt = null;
		String sql="select id, ip from koreamember";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Member> memberlist = new ArrayList<>();
		while(rs.next()) {
			Member m = new Member();
			m.setId(rs.getString("id"));
			m.setEmail(rs.getString("ip"));
			memberlist.add(m);
		}
		
		ConnectionHelper.close(rs);
		ConnectionHelper.close(pstmt);
		ConnectionHelper.close(conn); //반환하기
		
		return memberlist;
	}
}
