package kr.dogcat.board.reviewservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.dogcat.action.Action;
import kr.dogcat.action.ActionForward;
import kr.dogcat.dao.ReviewBoardDao;
import kr.dogcat.dto.ReviewBoard;

public class ReviewBoardRewriteOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String strrbnum = request.getParameter("rbnum").trim();		
		String rbsubj = request.getParameter("rbsubj");
		String rbcont = request.getParameter("rbcont");
		String msg="";
	    String url="";
		
				
		try {
			int rbnum = Integer.parseInt(strrbnum);
			
			ReviewBoard board = new ReviewBoard();
			
			board.setRbnum(rbnum);
			board.setRbsubj(rbsubj);
			board.setRbcont(rbcont);

			ReviewBoardDao rbd = new ReviewBoardDao();
			
			int result = rbd.reWriteOk(board);

		    if(result > 0){
		    	msg ="답글 달기 성공";
		    	url ="ReviewBoardList.bd";
		    }else{
		    	msg="답글 달기 실패 !";
		    	url="ReviewBoardContent.bd?idx="+board.getRbnum();
		    }
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("board_msg",msg);
		request.setAttribute("board_url", url);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/redirect.jsp");
		
		return forward;
	}

}
