package kr.or.bit.service.board;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;
import kr.or.bit.dto.Reply;

public class BoardRewriteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String loginMember = (String) session.getAttribute("userid");
		
		ActionForward forward = null;

		String idx = request.getParameter("idx");
		String cpage = request.getParameter("cp");
		String pagesize = request.getParameter("ps");
		String subject = request.getParameter("subject"); // 답글의 제목으로 사용
	    
		try {		
			if (idx == null || subject == null || idx.trim().equals("") || subject.trim().equals("")) {
				response.sendRedirect("BoardList.bd");
				return null;
			}
			if (cpage == null || pagesize == null) {
				cpage = "1";
				pagesize = "5";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("idx", idx);
		request.setAttribute("cp", cpage);
		request.setAttribute("ps", pagesize);
		request.setAttribute("subject", subject);
		
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/board/BoardRewrite.jsp");

		return forward;
	}
		
}