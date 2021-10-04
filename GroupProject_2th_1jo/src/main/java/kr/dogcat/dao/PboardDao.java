package kr.dogcat.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.dogcat.dto.Pboard;
import kr.dogcat.dto.Memo;
import kr.dogcat.utils.ConnectionHelper;

public class PboardDao {

	// 글쓰기
	public int pboardwrite(Pboard pbdata) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = ConnectionHelper.getConnection("oracle");// 추가
			String sql = "insert into Pboard(pbnum, email, pbdate, pbsubj, pbcont, pfilename, pfilesize, heart)"
					+ "values(Pboard_pbnum.nextval,?,sysdate,?,?,?,0,0)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pbdata.getEmail());
			pstmt.setString(2, pbdata.getPbsubj());
			pstmt.setString(3, pbdata.getPbcont());
			pstmt.setString(4, pbdata.getPfilename());

			row = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();// 반환하기
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return row;
	}

	// 게시물 총 건수 구하기
	public int totalBoardCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalcount = 0;
		try {
			conn = ConnectionHelper.getConnection("oracle");// 추가
			String sql = "select count(*) cnt from Pboard";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalcount = rs.getInt("cnt");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();// 반환 connection pool 에 반환하기
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return totalcount;
	}

	// 게시판 리스트(최신 글이 위로)
	public List<Pboard> lists(int cpage, int pagesize) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Pboard> lists = null;

		try {
			conn = ConnectionHelper.getConnection("oracle");// 추가
			String sql = "select * from "
					+ "(select rownum rn, pbnum, email, pbdate, pbsubj, pbcont, pfilename, pfilesize, heart, mnic "
					+ "from ( SELECT A.*, B.mnic FROM Pboard A join MEMBER B ON A.email = B.email ORDER BY A.pbdate DESC) "
					+ "where rownum <= ?" + ")where rn >= ?"; // startrow
			pstmt = conn.prepareStatement(sql);

			int start = cpage * pagesize - (pagesize - 1); // 1 * 9 - (9 - 1) >> 1
			int end = cpage * pagesize; // 1 * 9 >> 9

			pstmt.setInt(1, end);
			pstmt.setInt(2, start);

			rs = pstmt.executeQuery();

			lists = new ArrayList<Pboard>();

			while (rs.next()) {
				Pboard p = new Pboard();
				p.setPbnum(rs.getInt("pbnum"));
				p.setEmail(rs.getString("email"));
				p.setPbdate(rs.getDate("pbdate"));
				p.setPbsubj(rs.getString("pbsubj"));
				p.setPbcont(rs.getString("pbcont"));
				p.setPfilename(rs.getString("pfilename"));
				p.setPfilesize(rs.getInt("pfilesize"));
				p.setHeart(rs.getInt("heart"));
				p.setMnic(rs.getString("mnic"));

				lists.add(p);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		return lists;
	}

	// 게시판 리스트(하트 많은 게시글 3개 불러오기 for Main의 Best Photo)
	public List<Pboard> bestList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Pboard> bestList = null;

		try {
			conn = ConnectionHelper.getConnection("oracle");// 추가
			String sql = "select * from "
					+ "(select rownum rn, pbnum, email, pbdate, pbsubj, pbcont, pfilename, pfilesize, heart, mnic "
					+ "from ( SELECT A.*, B.mnic FROM Pboard A join MEMBER B ON A.email = B.email ORDER BY A.heart DESC) "
					+ "where rownum <= ?" + ")where rn >= ?"; // startrow
			pstmt = conn.prepareStatement(sql);

			int start = 1;
			int end = 3;

			pstmt.setInt(1, end);
			pstmt.setInt(2, start);

			rs = pstmt.executeQuery();

			bestList = new ArrayList<Pboard>();

			while (rs.next()) {
				Pboard p = new Pboard();
				p.setPbnum(rs.getInt("pbnum"));
				p.setEmail(rs.getString("email"));
				p.setPbdate(rs.getDate("pbdate"));
				p.setPbsubj(rs.getString("pbsubj"));
				p.setPbcont(rs.getString("pbcont"));
				p.setPfilename(rs.getString("pfilename"));
				p.setPfilesize(rs.getInt("pfilesize"));
				p.setHeart(rs.getInt("heart"));
				p.setMnic(rs.getString("mnic"));

				bestList.add(p);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		return bestList;
	}

	// 게시물 상세보기
	public Pboard getContent(int pbnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Pboard pboard = null;
		System.out.println(11111);
		try {
			conn = ConnectionHelper.getConnection("oracle");// 추가
			String sql = "select B.pbnum,B.email,B.pbdate,B.pbsubj,B.pbcont,B.pfilename,B.pfilesize,B.heart,A.mnic FROM MEMBER A JOIN Pboard B ON A.email = B.email where pbnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pbnum);
			System.out.println(222);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				String email = rs.getString("email");
				java.sql.Date pbdate = rs.getDate("pbdate");
				String pbsubj = rs.getString("pbsubj");
				String pbcont = rs.getString("pbcont");
				String pfilename = rs.getString("pfilename");
				int pfilesize = rs.getInt("pfilesize");
				int heart = rs.getInt("heart");
				String mnic = rs.getString("mnic");

				System.out.println("dao nic : " + mnic);
				pboard = new Pboard(pbnum, email, pbdate, pbsubj, pbcont, pfilename, pfilesize, heart, mnic);
			}
		} catch (Exception e) {
			System.out.println(444);
			System.out.println("content: " + e.getMessage());
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();// 반환하기
			} catch (Exception e2) {
			}
		}
		return pboard;
	}

	// 게시글 수정하기 화면 가져오기
	public Pboard getEditContent(String pbnum) {
		return this.getContent(Integer.parseInt(pbnum));
		// 조회화면과 동일 (기존에 있는 함수 재활용)
	}

	// 게시글 수정하기 처리
	public int pboardEdit(Pboard boarddata) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		try {
			int pbnum = boarddata.getPbnum();
			String email = boarddata.getEmail();
			String pbsubj = boarddata.getPbsubj();
			String pbcont = boarddata.getPbcont();

			String pfilename = boarddata.getPfilename();

			conn = ConnectionHelper.getConnection("oracle");// 추가
			String sql_udpate = "update Pboard set email=? , pbsubj=? , pbcont=? ," + "filename=? where pbnum=?";

			// 업데이트
			pstmt = conn.prepareStatement(sql_udpate);
			pstmt.setString(1, email);
			pstmt.setString(2, pbsubj);
			pstmt.setString(3, pbcont);
			pstmt.setString(4, pfilename);
			pstmt.setInt(5, pbnum);
			row = pstmt.executeUpdate();
			// System.out.println("row : " + row);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				pstmt.close();
				conn.close();// 반환
			} catch (Exception e2) {

			}
		}

		return row;
	}

	// 게시글 삭제하기
	public int deleteOk(String pbnum) {
		// 일반게시판 : 삭제 ...
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = ConnectionHelper.getConnection("oracle");

			String sql = "delete from Pboard where pbnum=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pbnum);
			row = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Insert : " + e.getMessage());
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
			try {
				conn.close(); // 받환하기
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}

	// 하트수 증가
	public boolean getHeart(String pbnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = ConnectionHelper.getConnection("oracle");// 추가
			String sql = "update Pboard set heart = heart + 1 where pbnum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pbnum);

			int row = pstmt.executeUpdate();
			if (row > 0) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();// 반환
			} catch (Exception e) {

			}
		}
		return result;
	}

	// 댓글 입력하기 (Table Memo : fk(Pboard pbnum) )
	public int replywrite(int pbnum_fk, String email, String mmcont) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = ConnectionHelper.getConnection("oracle");// 추가
			String sql = "insert into Memo(memonum,email,mmdate,mmcont,pbnum_fk) "
					+ " values(Memo_memonum.nextval,?,sysdate,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, mmcont);
			pstmt.setInt(3, pbnum_fk);

			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();// 반환
			} catch (Exception e) {
			}
		}
		return row;
	}

	// 댓글 조회하기
	public List<Memo> replylist(String pbnum_fk) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Memo> list = null;

		try {
			conn = ConnectionHelper.getConnection("oracle");// 추가
			String reply_sql = "select B.memonum, B.email, B.mmdate, B.mmcont, B.pbnum_fk, A.mnic\r\n"
					+ "from Member A\r\n" + "JOIN Memo B\r\n" + "ON A.email = B.email\r\n" + "where pbnum_fk=2\r\n"
					+ "order by memonum desc;";

			pstmt = conn.prepareStatement(reply_sql);
			pstmt.setString(1, pbnum_fk);

			rs = pstmt.executeQuery();

			list = new ArrayList<>();

			while (rs.next()) {

				int memonum = Integer.parseInt(rs.getString("memonum"));
				String email = rs.getString("email");
				java.sql.Date mmdate = rs.getDate("mmdate");
				String mmcont = rs.getString("mmcont");
				int pbnum = Integer.parseInt(rs.getString("pbnum_fk"));
				String mnic = rs.getString("mnic");

				Memo replydto = new Memo(memonum, email, mmdate, mmcont, pbnum, mnic);
				list.add(replydto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();// 반환
			} catch (Exception e) {

			}
		}

		return list;
	}

	// 댓글 삭제하기
	public int replyDelete(String memonum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		System.out.println(memonum);

		try {

			String sql = "delete from Memo where memonum=?";

			conn = ConnectionHelper.getConnection("oracle");// 추가
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memonum);
			row = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				pstmt.close();
				conn.close();// 반환
			} catch (Exception e) {

			}
		}

		return row;
	}

	// 하트 체크
	public int giveHeart(int board_num, String rec_email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;

		try {
			conn = ConnectionHelper.getConnection("oracle");// 추가

			String sql = "update Heart set hnum = hnum + 1 where board_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			row = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();// 반환
			} catch (Exception e) {

			}
		}

		return row;
	}
	
	// 하트 체크
	public int noHeart(int board_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;

		try {
			conn = ConnectionHelper.getConnection("oracle");// 추가

			String sql = "update Heart set hnum = hnum - 1 where board_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			row = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQL 에러 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();// 반환
			} catch (Exception e) {

			}
		}

		return row;
	}
	

}