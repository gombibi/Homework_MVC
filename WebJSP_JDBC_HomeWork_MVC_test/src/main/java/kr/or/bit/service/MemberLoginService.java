package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.Member;

public class MemberLoginService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward=null;
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		try{
			MemberDao dao = new MemberDao(); // POINT
			Boolean result = dao.checkIdPwd(id, pwd);
			
			String msg = "";
			String url = "";
			if (result) {
				//Top.jsp 정보 로그인 상태 ...
				  request.setAttribute("main", id);

				//이동처리
				  url = "Main.jsp";
				  
				 forward = new ActionForward();
				 forward.setRedirect(false); //forward
				 forward.setPath("Main.jsp");
				
			} else {
				msg = "로그인 실패";
				url = "Login.jsp";
				request.setAttribute("board_msg", msg);
				request.setAttribute("board_url", url);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}return forward;
	}
}
