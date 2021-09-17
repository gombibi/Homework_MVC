package kr.or.bit.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.Member;

public class MemberUpdateService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String str = (String) session.getAttribute("userid");

		
		ActionForward forward = null;
		String id = request.getParameter("id");
		try {
			 MemberDao dao = new MemberDao();
			 Member m = dao.getMemberDetailById(id);
			 m.setGender(m.getGender().trim());
			 request.setAttribute("MemberUpdate", m);
			 System.out.println(m.getId());
		
			 forward = new ActionForward();
			 forward.setRedirect(false); //forward
			 forward.setPath("MemberUpdate.jsp");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}

}






