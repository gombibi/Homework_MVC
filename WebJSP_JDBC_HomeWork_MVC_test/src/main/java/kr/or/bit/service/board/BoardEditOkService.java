package kr.or.bit.service.board;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;

public class BoardEditOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String loginMember = (String) session.getAttribute("userid");
		
		ActionForward forward = null;
		
		String msg = "";
		String url = "";

		String idx = request.getParameter("idx");
		
		try {
			BoardDao dao = new BoardDao();
			
			if (idx == null || idx.trim().equals("")) {
				msg = "글번호 입력 오류";
				url = "BoardList.bd";
				
			}else {
								
				int result = dao.boardEdit(request);
				
				if (result > 0) {
					msg = "edit success";
					url = "BoardList.bd";
				} else {
					msg = "edit fail";
					url = "BoardEdit.bd?idx=" + idx;
				}
				
			}
			request.setAttribute("board_msg", msg);
			request.setAttribute("board_url", url);
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/redirect.jsp");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return forward;
	}
}