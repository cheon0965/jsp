package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;

public class RemoveBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceImpl();
		
		if(svc.removeBoard(Integer.parseInt(bno))) {
			System.out.println("정상삭제...");
			resp.sendRedirect("boardList.do");
		}else {
			System.out.println("삭제실패");
			req.setAttribute("massage", "처리중 오류가 발생...");
			req.getRequestDispatcher("WEB-INF/view/boradForm.jsp").forward(req, resp);
		}
	}

}
