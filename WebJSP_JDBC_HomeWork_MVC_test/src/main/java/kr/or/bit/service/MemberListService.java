package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.Member;

public class MemberListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward=null;
		
		try{
			MemberDao dao = new MemberDao();
			List<Member> memberlist = dao.getMemberList();
			request.setAttribute("Memberlist", memberlist);
			
			forward = new ActionForward();
			forward.setRedirect(false); //forward
			forward.setPath("Memberlist.jsp");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
