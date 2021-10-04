package kr.or.bit.service.board;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;

public class BoardReplyOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String loginMember = (String) session.getAttribute("userid");
		
		ActionForward forward = null;
		
		String msg = "";
		String url = "";

		String writer = request.getParameter("reply_writer");
		String content = request.getParameter("reply_content");
		String idx = request.getParameter("idx");
		System.out.println("writer : "+writer);
		System.out.println("content : " + content);
		System.out.println("idx :" + idx);
		
		try {
			BoardDao dao = new BoardDao();
			int idx_fk = Integer.parseInt(idx);
			
			System.out.println(idx_fk);
			/*
			reply.setWriter(writer);
			reply.setContent(content);
			reply.setPwd(pwd);
			reply.setIdx_fk(idx_fk);
			reply.setUserid(userid);
			*/
			
			int result = dao.replywrite(idx_fk, writer, content);
			
			if(result > 0){
		    	msg ="댓글 입력 성공";
		    	url ="BoardContent.bd?idx="+idx_fk;
		    }else{
		    	msg="댓글 입력 실패";
		    	url="BoardContent.bd?idx="+idx_fk;
		    }
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		request.setAttribute("board_msg", msg);
		request.setAttribute("board_url", url);

		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/redirect.jsp");

		return forward;
	}
}