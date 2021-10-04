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

public class BoardEditService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String loginMember = (String) session.getAttribute("userid");
		
		ActionForward forward = null;

		String idx = request.getParameter("idx");
		
		String msg="";
	    String url="";
		
	    BoardDao dao;
	    
		try {		
			if(idx == null || idx.trim().equals("")){
				response.sendRedirect("BoardList.bd"); //cpage=1 , ps=5
				return null;
			}

			dao = new BoardDao();
			
			//BoardService service = BoardService.getInBoardService();
			Board board = dao.getEditContent(idx);
			
			if(board == null){
				msg ="데이터 오류";
				url ="BoardList.bd";
				
				request.setAttribute("board_msg", msg);
				request.setAttribute("board_url", url);
				
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("WEB-INF/views/redirect.jsp");
				
			}else {
				request.setAttribute("idx", idx);
				request.setAttribute("board", board);
				
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/WEB-INF/views/board/BoardEdit.jsp");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}
		
}