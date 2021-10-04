package kr.dogcat.board.reviewservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.dogcat.action.Action;
import kr.dogcat.action.ActionForward;
import kr.dogcat.dao.ReviewBoardDao;
import kr.dogcat.dto.Member;

public class ReviewBoardDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		int rbnum = Integer.parseInt(request.getParameter("rbnum"));
		String cpage = request.getParameter("cp"); // 현재 페이지
		
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginuser");
		String useremail = m.getEmail();
		
		String msg="";
		String url="";
		
		if(!useremail.equals("admin@dogcat.com")) {
			msg="관리자만 삭제할 수 있습니다 !";
			url="ReviewBoardList.bd?cp="+cpage;
			
			request.setAttribute("board_msg", msg);
			request.setAttribute("board_url", url);
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/board/redirect.jsp");
			
		}else {
		
		}
		ReviewBoardDao rbd = new ReviewBoardDao();
		try {
			
			int result = rbd.deleteOk(rbnum);
			
			if(result > 0){
				msg="삭제 성공 !";
				url="ReviewBoardList.bd?cp="+cpage;
			}else{
				msg="삭제 실패 !";
				url="ReviewBoardList.bd?cp="+cpage;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("board_msg",msg);
		request.setAttribute("board_url",url);
		
		

		forward.setRedirect(false); // forward
		forward.setPath("/WEB-INF/views/redirect.jsp");

		return forward;
		
	}

}
