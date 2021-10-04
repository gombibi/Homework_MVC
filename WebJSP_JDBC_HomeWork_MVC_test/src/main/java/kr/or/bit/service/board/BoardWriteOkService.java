package kr.or.bit.service.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

public class BoardWriteOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String loginMember = (String) session.getAttribute("userid");
		
		ActionForward forward=null;
		
		String msg = "";
		String url = "";
		
		try{
			//로그인 되어 있지 않을 경우, 접근 불가
			if(!(loginMember==null)) {
				String subject = request.getParameter("subject");
				String writer = request.getParameter("writer");
				String email = request.getParameter("email");
				String homepage = request.getParameter("homepage");
				String content = request.getParameter("content");
				String filename = request.getParameter("filename");
				
				System.out.println(subject);
		    	
				Board b = new Board();
				
				b.setSubject(subject);
				b.setWriter(writer);
				b.setEmail(email);
				b.setHomepage(homepage);
				b.setContent(content);
				b.setFilename(filename);
				
				BoardDao dao = new BoardDao();
					
				int result = dao.writeok(b);
					
				// write.jsp 화면 >> writeok.jsp 처리 >> service >> dao > DB 작업 >
				// return dao > return service > writeok.jsp 결과처리 >> 이동 (공통) >> redirect.jsp
		    	
			    if(result > 0){
			    	msg ="등록되었습니다.";
			    	url ="BoardList.bd";
			    	
			    }else{
			    	msg="등록 실패";
			    	url="BoardWrite.bd";;
			    }
		    	request.setAttribute("board_msg",msg);
			    request.setAttribute("board_url", url);
			
			    forward = new ActionForward();
			    forward.setRedirect(false);
			    forward.setPath("/WEB-INF/views/redirect.jsp");
				    
			}else {
				msg = "로그인 후 이용 가능합니다";
				url = "Login.jsp";
				
				request.setAttribute("board_msg",msg);
			    request.setAttribute("board_url", url);
			
			    forward = new ActionForward();
			    forward.setRedirect(false);
			    forward.setPath("/WEB-INF/views/redirect.jsp");
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}