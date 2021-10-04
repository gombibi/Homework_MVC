package kr.or.bit.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;

public class MemberIdCheckService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
		String idCheck = null;
		
		try {
			String id = request.getParameter("id");
	       	MemberDao dao = new MemberDao();
	    	idCheck = dao.isCheckById(id);
	    	request.setAttribute("message", idCheck);
	    	
	    	forward = new ActionForward();
	    	forward.setRedirect(false);
	    	forward.setPath("WEB-INF/views/member/uservalid.jsp");
	    	
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
	
}
