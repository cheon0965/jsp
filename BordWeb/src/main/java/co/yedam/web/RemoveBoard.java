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
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		BoardService svc = new BoardServiceImpl();
		
		if(svc.removeBoard(Integer.parseInt(bno))) {
			System.out.println("정상삭제...");
			resp.sendRedirect("boardList.do?page="+page+"&searchCondition="+sc+"&keyword="+kw);
		}else {
			System.out.println("삭제실패");
			req.setAttribute("massage", "처리중 오류가 발생...");
			req.getRequestDispatcher("board/boradForm.tiles").forward(req, resp);
		}
	}

}
