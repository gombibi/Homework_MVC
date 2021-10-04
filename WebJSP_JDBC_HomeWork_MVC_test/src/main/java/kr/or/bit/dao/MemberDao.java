package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.bit.dto.Member;
import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SqlManager;

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
		String sql = "insert into koreamember(id,pwd,name,age,gender,email,ip) values(?,?,?,?,?,?,?)";
		return SqlManager.run(sql, pstmt -> {
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setInt(4, m.getAge());
			pstmt.setString(5, m.getGender());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getIp());
			return pstmt.executeUpdate();
		});
	}
	
//	public int insertMember(Member m) {
//		Connection conn = null;// 추가
//		int resultrow = 0;
//		PreparedStatement pstmt = null;
//
//		try {
//			conn = ConnectionHelper.getConnection("oracle");// 추가
//
//			String sql = "insert into koreamember(id,pwd,name,age,gender,email,ip) values(?,?,?,?,?,?,?)";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, m.getId());
//			pstmt.setString(2, m.getPwd());
//			pstmt.setString(3, m.getName());
//			pstmt.setInt(4, m.getAge());
//			pstmt.setString(5, m.getGender());
//			pstmt.setString(6, m.getEmail());
//			pstmt.setString(7, m.getIp());
//
//			resultrow = pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			System.out.println("Insert : " + e.getMessage());
//		} finally {
//			ConnectionHelper.close(pstmt);
//			ConnectionHelper.close(conn);
//			try {
//				conn.close(); // 반환하기
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return resultrow;
//	}

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

	// 회원 목록(리스트) 출력
	// 목록 (select id, ip from koreamember)
	public ArrayList<Member> getMemberList() throws SQLException {

		Connection conn = ConnectionHelper.getConnection("oracle"); // 객체 얻기

		PreparedStatement pstmt = null;
		String sql = "select id, ip from koreamember";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		ArrayList<Member> memberlist = new ArrayList<>();
		while (rs.next()) {
			Member m = new Member();
			m.setId(rs.getString("id"));
			m.setEmail(rs.getString("ip"));
			memberlist.add(m);
		}

		ConnectionHelper.close(rs);
		ConnectionHelper.close(pstmt);
		ConnectionHelper.close(conn); // 반환하기

		return memberlist;
	}
	
	//Delete
	//delete from koreamember where id=?
	public int deleteMember(String id) {
		Connection conn = null;
		int resultrow=0;
		PreparedStatement pstmt = null;
		try {
				conn= ConnectionHelper.getConnection("oracle");
				String sql = "delete from koreamember where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				resultrow = pstmt.executeUpdate();
				
		}catch(Exception e) {
			System.out.println("delete : " + e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
			try {
				conn.close(); //반환하기
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultrow;
	}
	
	//Update
	//update koreamember set name=? , age=? , email=? , gender=?
    //where id=?
	public int updateMember(Member m) {
		Connection conn = null;//추가
		int resultrow=0;
		PreparedStatement pstmt = null;
		try {
			conn= ConnectionHelper.getConnection("oracle");//추가
			String sql = "update koreamember set name=? , age=? , email=? , gender=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getName());
			pstmt.setInt(2, m.getAge());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getGender());
			pstmt.setString(5, m.getId());
			resultrow = pstmt.executeUpdate();
				
		}catch(Exception e) {
			System.out.println("update : " + e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
			try {
				conn.close(); //반환하기
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultrow;
	}
	
	//1건의 데이터 read (where 조건으로 사용되는 컬럼은 반드시 unique , primary key)
	public Member getMemberDetailById(String id) {

		Connection conn =null;//추가
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		
		try {
				conn= ConnectionHelper.getConnection("oracle");//추가
				String sql = "select id,pwd,name,age,gender,email from koreamember where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					m = new Member();
					m.setId(rs.getString("id"));
					m.setPwd(rs.getString("pwd"));
					m.setName(rs.getString("name"));
					m.setAge(rs.getInt("age"));
					m.setGender(rs.getString("gender"));
					m.setEmail(rs.getString("email"));
				}
				
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
			try {
				conn.close();//반환하기
			} catch (SQLException e) {
				
				e.printStackTrace();
			} 
		}
		return m;
	}
	
	//select count(*) from koreamember where name like ?
	public ArrayList<Member> getSearchListByName(String name) {

		Connection conn =null;//추가
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		ArrayList<Member> searchlist= new ArrayList<Member>();
		try {
				conn= ConnectionHelper.getConnection("oracle");//추가
				String sql = "select * from koreamember where name=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					m = new Member();
					m.setId(rs.getString("id"));
					m.setName(rs.getString("name"));
					m.setEmail(rs.getString("email"));
					searchlist.add(m);
				}
				
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
			try {
				conn.close();//반환하기
			} catch (SQLException e) {
				
				e.printStackTrace();
			} 
		}
		return searchlist;
	}
}
