package kr.or.bit.service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

public class BoardWriteService implements Action {

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
				int idx = Integer.parseInt(request.getParameter("idx")); 
				String writer = request.getParameter("writer"); 
				String subject = request.getParameter("subject"); 
				String content = request.getParameter("content"); 
				String writedate = request.getParameter("writedate"); 
		    	
				Board b = new Board();
				b.setIdx(idx);
				b.setWriter(writer);
				b.setSubject(subject);
				b.setContent(content);
				b.setWritedate(writedate);
				
				BoardDao dao = new BoardDao();
				int result = dao.boardWrite(b);
		    	
				    if(result > 0){
				    	msg ="등록되었습니다.";
				    	url ="/board/BoardList.jsp";
				    	
				    	request.setAttribute("board_msg",msg);
					    request.setAttribute("board_url", url);
					
					    forward = new ActionForward();
					    forward.setRedirect(true);
					    forward.setPath("/WEB-INF/views/redirect.jsp");
					    
				    }else{
				    	msg="등록 실패";
				    	url="/board/BoardList.jsp";
				    	
				    	request.setAttribute("board_msg",msg);
					    request.setAttribute("board_url", url);
					
					    forward = new ActionForward();
					    forward.setRedirect(false);
					    forward.setPath("/WEB-INF/views/redirect.jsp");
				    }
				    
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