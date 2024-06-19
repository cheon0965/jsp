package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class CheckIdAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		
		BoardService svc = new BoardServiceImpl();
		if(svc.selectMemberAjax(id)) {
			resp.getWriter().print("{\"returnCod\":\"Exist\"}"); // {"returnCod":"Exist"}
		}else {
			resp.getWriter().print("{\"returnCod\":\"Not Exist\"}"); // {"returnCod":"Not Exist"}
		}
	}

}
