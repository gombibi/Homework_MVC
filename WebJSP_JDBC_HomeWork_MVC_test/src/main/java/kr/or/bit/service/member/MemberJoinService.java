package kr.or.bit.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.Member;

public class MemberJoinService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id"); 
		String pwd = request.getParameter("pwd"); 
		String name = request.getParameter("name"); 
		int age = Integer.parseInt(request.getParameter("age")); 
		String gender = request.getParameter("gender"); 
		String email = request.getParameter("email"); 
		String ip = request.getRemoteAddr();
    	
    	//memo m = new memo();  //권장사항
    	//m.setId(id);
    	
		Member m = new Member();
		m.setId(id);
		m.setPwd(pwd);
		m.setName(name);
		m.setAge(age);
		m.setGender(gender);
		m.setEmail(email);
		m.setIp(ip);
		
    	MemberDao dao = new MemberDao(); //POINT
		int result = dao.insertMember(m);
    	
		 	String msg="";
		 	String url="";
		    if(result > 0){
		    	msg ="가입성공";
			  request.setAttribute("main", id);
		    	url ="Main.jsp";
		    }else{
		    	msg="가입실패";
		    	url="Main.jsp";
		    }
		    
		    request.setAttribute("board_msg",msg);
		    request.setAttribute("board_url", url);
		
		    ActionForward forward = new ActionForward();
		    forward.setRedirect(false);
		    forward.setPath("/WEB-INF/views/redirect.jsp");
		    
		return forward;
	}

}






