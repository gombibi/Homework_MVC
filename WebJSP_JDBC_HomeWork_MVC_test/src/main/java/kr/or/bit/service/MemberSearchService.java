package kr.or.bit.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.Member;

public class MemberSearchService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String str = (String) session.getAttribute("userid");


		ActionForward forward = null;

		String msg = "";
		String url = "";

		try {
			String name = request.getParameter("search");
			
			MemberDao dao = new MemberDao();
			List<Member> searchlist = dao.getSearchListByName(name);

			if (searchlist.size() > 0) {
				request.setAttribute("searchlist", searchlist);

				forward = new ActionForward();
				forward.setRedirect(false); // forward
				forward.setPath("MemberSearch.jsp");
			} else {

				msg = "조회결과가 없습니다";
				url = "Memberlist.jsp";

				request.setAttribute("board_msg", msg);
				request.setAttribute("board_url", url);

				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/WEB-INF/views/redirect.jsp");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
