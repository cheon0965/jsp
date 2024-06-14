package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.service.StudentService;
import co.yedam.service.StudentServiceImpl;
import co.yedam.vo.BoardVO;
import co.yedam.vo.Student;

public class AddBodard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		HttpSession session = req.getSession();
	    String logId = (String) session.getAttribute("logId");
	    
		BoardService svc = new BoardServiceImpl();
		
		BoardVO board = new BoardVO();
		
		board.setTitle(title);
		board.setWriter(logId);
		board.setContent(content);
		
		if(svc.addBoard(board)) {
			System.out.println("정상등록...");
			resp.sendRedirect("boardList.do");
		}else {
			System.out.println("등록실패");
			req.setAttribute("massage", "처리중 오류가 발생...");
			req.getRequestDispatcher("board/boradForm.tiles").forward(req, resp);
		}
		
	}

}
