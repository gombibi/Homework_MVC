package kr.dogcat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.dogcat.dto.Emp;
import kr.dogcat.dto.MemberBoard;
import kr.dogcat.dto.VisitingBoard;
import kr.dogcat.dto.WalkingBoard;
import kr.dogcat.utils.ConnectionHelper;

public class ManagerBoardDao {

	// ---------------- WalkingService ----------------

	// 게시물 총 건수 구하기
	public int wtotalBoardCount() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalcount = 0;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "select count(*) cnt from Reserv_w";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalcount = rs.getInt("cnt");
			}
		} catch (Exception e) {

		} finally {
			try {
				ConnectionHelper.close(pstmt);
				ConnectionHelper.close(rs);
				ConnectionHelper.close(conn);
			} catch (Exception e) {

			}
		}
		return totalcount;
	}

	// 게시물 목록보기 - 산책
	public List<WalkingBoard> wlist(int cpage, int pagesize) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<WalkingBoard> list = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");

			String sql = "select * from (select rownum rn, r.rnum, r.email, m.mphone, m.madd, "
					+ "r.udate, w.time, r.price, r.rdate, s.rstatus "
					+ "from Reserv_W r join Member m on r.email = m.email "
					+ "join rstatus s on r.rstatuscode = s.rstatuscode "
					+ "join Wtime w on r.wtcode = w.wtcode where rownum <= ?) " + "where rn >= ?";

			pstmt = conn.prepareStatement(sql);
			// 공식같은 로직
			int start = cpage * pagesize - (pagesize - 1); // 현재 페이지의 첫번째 번호 (cpage-1)*pagesize+1
			int end = cpage * pagesize; // 현재 페이지의 마지막 번호
			//
			pstmt.setInt(1, end);
			pstmt.setInt(2, start);

			rs = pstmt.executeQuery();
			list = new ArrayList<WalkingBoard>();
			while (rs.next()) {

				WalkingBoard board = new WalkingBoard();
				board.setRnum(rs.getInt("rnum"));
				board.setEmail(rs.getString("email"));
				board.setMphone(rs.getString("mphone"));
				board.setMadd(rs.getString("madd"));
				board.setUdate(rs.getDate("udate"));
				board.setTime(rs.getString("time"));
				board.setPrice(rs.getInt("price"));
				board.setRdate(rs.getDate("rdate"));
				board.setRstatus(rs.getString("rstatus"));

				list.add(board);
			}

		} catch (Exception e) {
			System.out.println("오류 :" + e.getMessage());
		} finally {
			try {
				ConnectionHelper.close(pstmt);
				ConnectionHelper.close(rs);
				ConnectionHelper.close(conn);// 반환
			} catch (Exception e2) {

			}
		}

		return list;
	}

	// 게시물 검색 - 산책
	public List<WalkingBoard> wSearchBoard(String[] option, int cpage, int pagesize) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<WalkingBoard> list = null;
		String sql = null;

		if (option.length == 0) {
			sql = "select * from (select rownum rn, r.rnum, r.email, m.mphone, m.madd, r.udate, w.time, r.price, r.rdate, s.rstatus "
					+ "from Reserv_W r join Member m on r.email = m.email "
					+ "join rstatus s on r.rstatuscode = s.rstatuscode " + "join Wtime w on r.wtcode = w.wtcode "
					+ "ORDER BY r.rnum DESC) where rn between ? and ?";
		} else {
			String[] optioncheck = new String[4];

			switch (option.length) {
			case 1:
				optioncheck[0] = option[0];
				break;
			case 2:
				optioncheck[0] = option[0];
				optioncheck[1] = option[1];
				break;
			case 3:
				optioncheck[0] = option[0];
				optioncheck[1] = option[1];
				optioncheck[2] = option[2];
				break;
			case 4:
				optioncheck[0] = option[0];
				optioncheck[1] = option[1];
				optioncheck[2] = option[2];
				optioncheck[3] = option[3];
				break;
			}

			sql = "select * from (select rownum rn, r.rnum, r.email, m.mphone, m.madd, r.udate, w.time, r.price, r.rdate, s.rstatus "
					+ "from Reserv_W r join Member m on r.email = m.email "
					+ "join rstatus s on r.rstatuscode = s.rstatuscode " + "join Wtime w on r.wtcode = w.wtcode "
					+ "where s.rstatus='" + optioncheck[0] + "' or s.rstatus='" + optioncheck[1] + "' or s.rstatus='"
					+ optioncheck[2] + "' or s.rstatus='" + optioncheck[3] + "'"
					+ "ORDER BY r.rnum DESC) where rn between ? and ?";

		}

		try {
			conn = ConnectionHelper.getConnection("oracle");

			pstmt = conn.prepareStatement(sql);
			// 공식같은 로직
			int start = cpage * pagesize - (pagesize - 1); // 현재 페이지의 첫번째 번호 (cpage-1)*pagesize+1
			int end = cpage * pagesize; // 현재 페이지의 마지막 번호
			//
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();
			list = new ArrayList<WalkingBoard>();
			while (rs.next()) {

				WalkingBoard board = new WalkingBoard();
				board.setRnum(rs.getInt("rnum"));
				board.setEmail(rs.getString("email"));
				board.setMphone(rs.getString("mphone"));
				board.setMadd(rs.getString("madd"));
				board.setUdate(rs.getDate("udate"));
				board.setTime(rs.getString("time"));
				board.setPrice(rs.getInt("price"));
				board.setRdate(rs.getDate("rdate"));
				board.setRstatus(rs.getString("rstatus"));

				list.add(board);
			}

		} catch (Exception e) {
			System.out.println("오류 :" + e.getMessage());
		} finally {
			try {
				ConnectionHelper.close(pstmt);
				ConnectionHelper.close(rs);
				ConnectionHelper.close(conn);
			} catch (Exception e2) {

			}
		}

		return list;
	}

	// ---------------- VisitingService ----------------

	// 게시물 총 건수 구하기
	public int vtotalBoardCount() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalcount = 0;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "select count(*) cnt from Reserv_v";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalcount = rs.getInt("cnt");
			}
		} catch (Exception e) {

		} finally {
			try {
				ConnectionHelper.close(pstmt);
				ConnectionHelper.close(rs);
				ConnectionHelper.close(conn);
			} catch (Exception e) {

			}
		}
		return totalcount;
	}

	// 게시물 목록보기 - 방문
	public List<VisitingBoard> vlist(int cpage, int pagesize) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<VisitingBoard> list = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");

			String sql = "select * from (select rownum rn, r.rnum, r.email, m.mphone, m.madd, "
					+ "r.sdate, r.edate, r.price, r.rdate, s.rstatus, r.pet, r.useday "
					+ "from Reserv_V r join Member m on r.email = m.email "
					+ "join rstatus s on r.rstatuscode = s.rstatuscode " + "where rownum <= ?) where rn >= ?";

			pstmt = conn.prepareStatement(sql);
			// 공식같은 로직
			int start = cpage * pagesize - (pagesize - 1); // 현재 페이지의 첫번째 번호 (cpage-1)*pagesize+1
			int end = cpage * pagesize; // 현재 페이지의 마지막 번호
			//
			pstmt.setInt(1, end);
			pstmt.setInt(2, start);

			rs = pstmt.executeQuery();
			list = new ArrayList<VisitingBoard>();
			while (rs.next()) {

				VisitingBoard board = new VisitingBoard();
				board.setRnum(rs.getInt("rnum"));
				board.setEmail(rs.getString("email"));
				board.setMphone(rs.getString("mphone"));
				board.setMadd(rs.getString("madd"));
				board.setSdate(rs.getDate("sdate"));
				board.setEdate(rs.getDate("edate"));
				board.setPrice(rs.getInt("price"));
				board.setRdate(rs.getDate("rdate"));
				board.setRstatus(rs.getString("rstatus"));
				board.setPet(rs.getString("pet"));
				board.setUseday(rs.getInt("useday"));

				list.add(board);
			}

		} catch (Exception e) {
			System.out.println("오류 :" + e.getMessage());
		} finally {
			try {
				ConnectionHelper.close(pstmt);
				ConnectionHelper.close(rs);
				ConnectionHelper.close(conn);// 반환
			} catch (Exception e2) {

			}
		}

		return list;
	}

	// 게시물 검색 - 방문
	public List<VisitingBoard> vSearchBoard(String[] option, String pet, int cpage, int pagesize) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<VisitingBoard> list = null;
		String sql = "";
		String petword = "";

		if (pet.equals("dog")) {
			petword = "개";
		} else if (pet.equals("cat")) {
			petword = "고양이";
		}

		if (option.length == 0) {

			if (pet.equals("all")) {
				sql = "select * from (select rownum rn, r.rnum, r.pet, r.email, m.mphone, m.madd, r.sdate, r.edate, r.price, r.rdate, s.rstatus, r.useday "
						+ "from Reserv_V r join Member m on r.email = m.email "
						+ "join rstatus s on r.rstatuscode = s.rstatuscode "
						+ "ORDER BY r.rnum DESC) where rn between ? and ?";
			} else {
				sql = "select * from (select rownum rn, r.rnum, r.pet, r.email, m.mphone, m.madd, r.sdate, r.edate, r.price, r.rdate, s.rstatus, r.useday "
						+ "from Reserv_V r join Member m on r.email = m.email "
						+ "join rstatus s on r.rstatuscode = s.rstatuscode " + "where r.pet='" + petword + "' "
						+ "ORDER BY r.rnum DESC) where rn between ? and ?";
			}

		} else {
			String[] optioncheck = new String[4];

			switch (option.length) {
			case 1:
				optioncheck[0] = option[0];
				break;
			case 2:
				optioncheck[0] = option[0];
				optioncheck[1] = option[1];
				break;
			case 3:
				optioncheck[0] = option[0];
				optioncheck[1] = option[1];
				optioncheck[2] = option[2];
				break;
			case 4:
				optioncheck[0] = option[0];
				optioncheck[1] = option[1];
				optioncheck[2] = option[2];
				optioncheck[3] = option[3];
				break;
			}

			if (pet.equals("all")) {
				sql = "select * from (select rownum rn, r.rnum, r.pet, r.email, m.mphone, m.madd, r.sdate, r.edate, r.price, r.rdate, s.rstatus, r.useday "
						+ "from Reserv_V r join Member m on r.email = m.email "
						+ "join rstatus s on r.rstatuscode = s.rstatuscode " + "where s.rstatus='" + optioncheck[0]
						+ "' or s.rstatus='" + optioncheck[1] + "' or s.rstatus='" + optioncheck[2] + "' or s.rstatus='"
						+ optioncheck[3] + "' " + "ORDER BY r.rnum DESC) where rn between ? and ?";
			} else {
				sql = "select * from (select rownum rn, r.rnum, r.pet, r.email, m.mphone, m.madd, r.sdate, r.edate, r.price, r.rdate, s.rstatus, r.useday "
						+ "from Reserv_V r join Member m on r.email = m.email "
						+ "join rstatus s on r.rstatuscode = s.rstatuscode " + "where r.pet='" + petword + "' "
						+ "AND where s.rstatus='" + optioncheck[0] + "' or s.rstatus='" + optioncheck[1]
						+ "' or s.rstatus='" + optioncheck[2] + "' or s.rstatus='" + optioncheck[3] + "' "
						+ "ORDER BY r.rnum DESC) where rn between ? and ?";
			}

		}

		try {
			conn = ConnectionHelper.getConnection("oracle");

			pstmt = conn.prepareStatement(sql);
			// 공식같은 로직
			int start = cpage * pagesize - (pagesize - 1); // 현재 페이지의 첫번째 번호 (cpage-1)*pagesize+1
			int end = cpage * pagesize; // 현재 페이지의 마지막 번호
			//
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();
			list = new ArrayList<VisitingBoard>();
			while (rs.next()) {

				VisitingBoard board = new VisitingBoard();
				board.setRnum(rs.getInt("rnum"));
				board.setEmail(rs.getString("email"));
				board.setMphone(rs.getString("mphone"));
				board.setMadd(rs.getString("madd"));
				board.setSdate(rs.getDate("sdate"));
				board.setEdate(rs.getDate("edate"));
				board.setPrice(rs.getInt("price"));
				board.setRdate(rs.getDate("rdate"));
				board.setRstatus(rs.getString("rstatus"));
				board.setPet(rs.getString("pet"));
				board.setUseday(rs.getInt("useday"));

				list.add(board);
			}

		} catch (Exception e) {
			System.out.println("오류 :" + e.getMessage());
		} finally {
			try {
				ConnectionHelper.close(pstmt);
				ConnectionHelper.close(rs);
				ConnectionHelper.close(conn);
			} catch (Exception e2) {

			}
		}

		return list;
	}

	// ---------------- MemberBoardService ----------------

	// 회원 총 건수 구하기
	public int mtotalBoardCount() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalcount = 0;
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "select count(*) cnt from Member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalcount = rs.getInt("cnt");
			}
		} catch (Exception e) {

		} finally {
			try {
				ConnectionHelper.close(pstmt);
				ConnectionHelper.close(rs);
				ConnectionHelper.close(conn);
			} catch (Exception e) {

			}
		}
		return totalcount;
	}

	// 회원 목록보기
	public List<MemberBoard> mlist(int cpage, int pagesize) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberBoard> list = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");

			String sql = "select * from (select rownum rn, m.email, m.mnic, m.mname, m.mphone, m.madd, nvl(c.count,0), nvl(c.totalp,0) "
					+ "from Member m full outer join Mcount c on m.email = c.email "
					+ "where rownum <= ?) where rn >= ?";

			pstmt = conn.prepareStatement(sql);
			// 공식같은 로직
			int start = cpage * pagesize - (pagesize - 1); // 현재 페이지의 첫번째 번호 (cpage-1)*pagesize+1
			int end = cpage * pagesize; // 현재 페이지의 마지막 번호
			//
			pstmt.setInt(1, end);
			pstmt.setInt(2, start);

			rs = pstmt.executeQuery();
			list = new ArrayList<MemberBoard>();
			while (rs.next()) {

				MemberBoard board = new MemberBoard();
				board.setEmail(rs.getString("email"));
				board.setMnic(rs.getString("mnic"));
				board.setMname(rs.getString("mname"));
				board.setMphone(rs.getString("mphone"));
				board.setMadd(rs.getString("madd"));
				board.setCount(rs.getInt(7));
				board.setTotalp(rs.getInt(8));

				list.add(board);
			}

		} catch (Exception e) {
			System.out.println("오류 :" + e.getMessage());
		} finally {
			try {
				ConnectionHelper.close(pstmt);
				ConnectionHelper.close(rs);
				ConnectionHelper.close(conn);// 반환
			} catch (Exception e2) {

			}
		}

		return list;
	}

	// 회원 검색
	public List<MemberBoard> mSearchBoard(String option, String searchword, int cpage, int pagesize) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberBoard> list = null;
		String sql = null;

		if (searchword.equals("")) {
			sql = "select * from (select rownum rn, m.email, m.mnic, m.mname, m.mphone, m.madd, nvl(c.count,0), nvl(c.totalp,0) "
					+ "from Member m full outer join Mcount c on m.email = c.email)" + "where rn BETWEEN ? and ?";
		} else {
			sql = "select * from (select rownum rn, m.email, m.mnic, m.mname, m.mphone, m.madd, nvl(c.count,0), nvl(c.totalp,0) "
					+ "from Member m full outer join Mcount c on m.email = c.email " + "where (" + option + " like '%"
					+ searchword + "' or " + option + " like '" + searchword + "%' or " + option + " like '%"
					+ searchword + "%')) " + "where rn BETWEEN ? and ?";
		}

		try {
			conn = ConnectionHelper.getConnection("oracle");

			pstmt = conn.prepareStatement(sql);
			// 공식같은 로직
			int start = cpage * pagesize - (pagesize - 1); // 현재 페이지의 첫번째 번호 (cpage-1)*pagesize+1
			int end = cpage * pagesize; // 현재 페이지의 마지막 번호
			//
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();
			list = new ArrayList<MemberBoard>();
			while (rs.next()) {

				MemberBoard board = new MemberBoard();
				board.setEmail(rs.getString("email"));
				board.setMnic(rs.getString("mnic"));
				board.setMname(rs.getString("mname"));
				board.setMphone(rs.getString("mphone"));
				board.setMadd(rs.getString("madd"));
				board.setCount(rs.getInt(7));
				board.setTotalp(rs.getInt(8));

				list.add(board);
			}

		} catch (Exception e) {
			System.out.println("오류 :" + e.getMessage());
		} finally {
			try {
				ConnectionHelper.close(pstmt);
				ConnectionHelper.close(rs);
				ConnectionHelper.close(conn);
			} catch (Exception e2) {

			}
		}

		return list;
	}

	// 회원 삭제
	public int deleteMember(String[] num) {

		Connection conn = null;
		conn = ConnectionHelper.getConnection("oracle");
		int resultrow = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from Member where email = ?";

		try {
			pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < num.length; i++) {
				pstmt.setString(1, num[i]);
				resultrow += pstmt.executeUpdate(); // 반영된 행의 수
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}

		return resultrow;
	}
	
	// 시터 조회
	public List<Emp> slist(int acode) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> list = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");

			String sql = "select e.enum, e.ename, e.ephoto, e.eintro, z.aname "
					   + "from Emp e join zipcode z on e.acode = z.acode "
					   + "where e.acode=? "
					   + "order by e.enum asc"; 

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, acode);

			rs = pstmt.executeQuery();
			list = new ArrayList<Emp>();
			
			while (rs.next()) {

				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("enum"));
				emp.setEname(rs.getString("ename"));
				emp.setEphoto(rs.getString("ephoto"));
				emp.setEintro(rs.getString("eintro"));
				emp.setAname(rs.getString("aname"));

				list.add(emp);
			}

		} catch (Exception e) {
			System.out.println("오류 :" + e.getMessage());
		} finally {
			try {
				ConnectionHelper.close(pstmt);
				ConnectionHelper.close(rs);
				ConnectionHelper.close(conn);// 반환
			} catch (Exception e2) {

			}
		}

		return list;
	}

}
