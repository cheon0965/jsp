package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class DeleteAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");

		BoardService svc = new BoardServiceImpl();
		if (svc.deleteMemberAjax(id)) {
			resp.getWriter().print("{\"returnCod\":\"success\"}"); 
		} else {
			resp.getWriter().print("{\"returnCod\":\"Not success\"}"); 
		}

	}

}
