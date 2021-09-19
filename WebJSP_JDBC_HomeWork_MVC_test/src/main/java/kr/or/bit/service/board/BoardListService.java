package kr.or.bit.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.Board;
import kr.or.bit.dto.Member;

public class BoardListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String loginMember = (String) session.getAttribute("userid");
		
		ActionForward forward=null;
		
		String msg = "";
		String url = "";
		
		try{
			//로그인 되어 있지 않을 경우, 접근 불가
			if(!(request.getSession().getAttribute("userid")==null)) {
				BoardDao dao = new BoardDao();
				List<Board> boardlist = dao.getBoardList();
				request.setAttribute("Boardlist", boardlist);
				
				forward = new ActionForward();
				forward.setRedirect(false); //forward
				forward.setPath("BoardList.jsp");
			
			}else {
				msg = "로그인 후 이용 가능합니다";
				url = "Login.jsp";
				
				request.setAttribute("board_msg",msg);
			    request.setAttribute("board_url", url);
			
			    forward = new ActionForward();
			    forward.setRedirect(false);
			    forward.setPath("/WEB-INF/views/redirect.jsp");
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
