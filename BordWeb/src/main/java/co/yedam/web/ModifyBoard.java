package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class ModifyBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		BoardService svc = new BoardServiceImpl();
		
		BoardVO board = new BoardVO();
		
		board.setBoardNo(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);
		
		if(svc.editBoard(board)) {
			System.out.println("정상등록...");
			resp.sendRedirect("boardList.do?page="+page+"&searchCondition="+sc+"&keyword="+kw);
		}else {
			System.out.println("등록실패");
			req.setAttribute("massage", "처리중 오류가 발생...");
			req.getRequestDispatcher("board/boradForm.tiles").forward(req, resp);
		}
	}

}
