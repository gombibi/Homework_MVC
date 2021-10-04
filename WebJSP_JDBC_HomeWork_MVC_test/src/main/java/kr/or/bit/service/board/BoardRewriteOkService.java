package kr.or.bit.service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

public class BoardRewriteOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String loginMember = (String) session.getAttribute("userid");
		
		ActionForward forward = null;

		String strIdx = request.getParameter("idx").trim();		
		String subject = request.getParameter("subject");
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String content = request.getParameter("content");
		String filename = request.getParameter("filename");
		
		String msg="";
	    String url="";
	    
		try {		
			int idx = Integer.parseInt(strIdx);
			
			Board board = new Board();
			
			board.setSubject(subject);
			board.setWriter(writer);
			board.setEmail(email);
			board.setHomepage(homepage);
			board.setContent(content);
			board.setFilename(filename);
			board.setIdx(idx);

			BoardDao dao = new BoardDao();
			
			int result = dao.reWriteOk(board);

		    if(result > 0){
		    	msg ="rewrite insert success";
		    	url ="BoardList.bd";
		    }else{
		    	msg="rewrite insert fail";
		    	url="BoardContent.bd?idx="+board.getIdx();
		    }

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("board_msg",msg);
		request.setAttribute("board_url", url);
		
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/redirect.jsp");
		
		return forward;
	}
		
}