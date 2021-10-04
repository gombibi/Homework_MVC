package kr.or.bit.service.board;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;

public class ReplyDeleteOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String loginMember = (String) session.getAttribute("userid");
		
		ActionForward forward = null;
		
		String msg = "";
		String url = "";

		String idx_fk = request.getParameter("idx");// 댓글의 원본 게시글 번호
		String no = request.getParameter("no");// 댓글의 순번(PK)
		
		if (idx_fk == null || no == null || no.trim().equals("")) {
			msg = "이상한 링크 입니다.";
			url = "BoardContent.bd?idx=" + idx_fk;
		} else {

			try {
				BoardDao dao = new BoardDao();

				int result = dao.replyDelete(no);
				
				if (result > 0) {
					msg = "댓글 삭제 성공";
					url = "BoardContent.bd?idx=" + idx_fk;
				} else {
					msg = "댓글 삭제 실패";
					url = "BoardContent.bd?idx=" + idx_fk;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		request.setAttribute("board_msg", msg);
		request.setAttribute("board_url", url);
		
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/redirect.jsp");

		return forward;
	}
}