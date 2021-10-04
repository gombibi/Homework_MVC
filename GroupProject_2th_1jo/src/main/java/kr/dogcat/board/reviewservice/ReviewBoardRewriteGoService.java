package kr.dogcat.board.reviewservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.dogcat.action.Action;
import kr.dogcat.action.ActionForward;
import kr.dogcat.dto.Member;

public class ReviewBoardRewriteGoService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String rbnum = request.getParameter("rbnum");
		String cpage = request.getParameter("cp");
		String pagesize = request.getParameter("ps");
		String rbsubj = request.getParameter("rbsubj"); // 답글의 제목으로 사용
		
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginuser");
		String useremail = m.getEmail();
		String msg="";
		String url="";
		
		if(!useremail.equals("admin@dogcat.com")) {
			msg="관리자만 작성할 수 있습니다 !";
			url="ReviewBoardContent.bd?cp="+cpage+"&ps="+pagesize+"&rbnum="+rbnum;
			
			request.setAttribute("board_msg", msg);
			request.setAttribute("board_url", url);
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/redirect.jsp");
			
		}else {

		try {
			if (rbnum == null || rbsubj == null || rbnum.trim().equals("") || rbsubj.trim().equals("")) {
				response.sendRedirect("ReviewBoardList.bd");
				return null;
			}
			if (cpage == null || pagesize == null) {
				cpage = "1";
				pagesize = "10";
			}
		
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		request.setAttribute("rbnum", rbnum);
		request.setAttribute("cp", cpage);
		request.setAttribute("ps", pagesize);
		request.setAttribute("rbsubj", rbsubj);
		

		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/rboard/reviewupload.jsp");
		
		}
		
		return forward;
	}

}
