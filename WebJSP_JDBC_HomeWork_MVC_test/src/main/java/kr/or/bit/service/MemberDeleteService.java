package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;

public class MemberDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String str = (String) session.getAttribute("userid");
		
		String id = request.getParameter("id");
		
    	MemberDao dao = new MemberDao(); //POINT
    	int result = dao.deleteMember(id);
    	
		 	String msg="";
		 	String url="";
		    if(result > 0){
		    	msg ="삭제되었습니다";
		    	url ="Memberlist.me";
		    }else{
		    	msg="삭제 실패";
		    	url="Memberlist.me";
		    }
		    
		    request.setAttribute("board_msg",msg);
		    request.setAttribute("board_url", url);
		
		    ActionForward forward = new ActionForward();
		    forward.setRedirect(false);
		    forward.setPath("/WEB-INF/views/redirect.jsp");
		    
		return forward;
	}
}
