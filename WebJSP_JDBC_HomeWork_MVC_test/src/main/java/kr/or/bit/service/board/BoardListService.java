package kr.or.bit.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

public class BoardListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String loginMember = (String) session.getAttribute("userid");
		
		ActionForward forward=null;
		
		String msg = "";
		String url = "";
		
		try{
			BoardDao dao = new BoardDao();

			//currentpage
			//pagesize
			
			//상세보기 >> 다시  LIST 넘어올때  >> 현재 페이지 설정
			String ps = request.getParameter("ps"); //pagesize
			String cp = request.getParameter("cp"); //current page
			
			//List 페이지 처음 호출 ... ps, cp가 없는 경우(기본값 설정)
			if(ps == null || ps.trim().equals("")){
				//default 값 설정
				ps = "5"; //5개씩 묶음
			}
		
			if(cp == null || cp.trim().equals("")){
				//default 값 설정
				cp = "1"; // 전체 묶음 중에서 첫번째 페이지를 보겠다.
			}
			
			int pagesize = Integer.parseInt(ps);
			int cpage = Integer.parseInt(cp);
			
			//전체 목록 가져오기
			List<Board> boardlist = dao.getBoardList(cpage, pagesize); //list >> 1 , 20
			
			request.setAttribute("Boardlist", boardlist);
			
			////////////////////////////////////////////////////////
			//페이징 처리 view에서 직접 처리 방법
			
			//게시물 총 건수
			int totalboardcount = dao.totalBoardCount();

			int pagecount=0;
			
			//23건  % 5
			if(totalboardcount % pagesize == 0){
				pagecount = totalboardcount / pagesize; //  20 << 100/5
			}else{
				pagecount = (totalboardcount / pagesize) + 1; 
				//102건 : pagesize=5 >> pagecount=21페이지
			}
			
			request.setAttribute("pagesize", pagesize);
			request.setAttribute("cpage", cpage);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("totalboardcount", totalboardcount);

			
			forward = new ActionForward();
			forward.setRedirect(false); //forward
			forward.setPath("WEB-INF/views/board/BoardList.jsp");
		
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
