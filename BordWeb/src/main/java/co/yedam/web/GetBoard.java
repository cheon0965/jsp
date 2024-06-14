package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.common.SearchVO;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;

public class GetBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 파라미터정보를 읽어서 게시들번호 조회.
		// board.jsp 페이지에 출력.
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		BoardService svc = new BoardServiceImpl();
		SearchVO search = new SearchVO(Integer.parseInt(page),sc,kw);
		
		BoardVO brd = svc.getBoard(Integer.parseInt(bno));
		
		brd.setClickCnt(brd.getClickCnt() + 1);
		svc.editBoard(brd);
		
		req.setAttribute("page", page);
		req.setAttribute("board", brd);
		req.setAttribute("search", search);
		
		req.getRequestDispatcher("board/board.tiles").forward(req, resp);
		

	}

}
