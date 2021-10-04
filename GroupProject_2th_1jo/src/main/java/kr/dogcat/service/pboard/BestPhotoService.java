package kr.dogcat.service.pboard;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.dogcat.action.Action;
import kr.dogcat.action.ActionForward;
import kr.dogcat.dao.PboardDao;
import kr.dogcat.dto.Pboard;
import kr.dogcat.utils.ThePager;

public class BestPhotoService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/html; charset=UTF-8");
		
		ActionForward forward = null;
		
		try {

			PboardDao dao = new PboardDao();
			
			//베스트 포토 리스트 가져오기(하트 많은 순으로 3개)
			List<Pboard> list = dao.bestList();
			
			PrintWriter out = response.getWriter();
			
			if(list == null || list.size() == 0){
     			out.print("<tr><td colspan='5'>데이터가 없습니다</td></tr>");
     		}
			
			request.setAttribute("list", list);
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("Main.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return forward;
	}

}
