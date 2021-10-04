package kr.or.bit.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.Member;

public class MemberUpdateOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String str = (String) session.getAttribute("userid");

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		Member m = new Member();
    	m.setId(id);
    	m.setName(name);
    	m.setAge(age);
    	m.setEmail(email);
    	m.setGender(gender);
    	MemberDao dao = new MemberDao(); //POINT
    	int result = dao.updateMember(m);
    	
		 	String msg="";
		 	String url="";
		    if(result > 0){
		    	msg ="수정성공";
		    	url ="Memberlist.me";
		    }else{
		    	msg="수정실패";
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
