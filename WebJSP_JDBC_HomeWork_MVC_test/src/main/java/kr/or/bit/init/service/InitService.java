package kr.or.bit.init.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;

public class InitService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao(); // POINT
		dao.createTable();
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("Main.jsp");
		return forward;
	}
}
