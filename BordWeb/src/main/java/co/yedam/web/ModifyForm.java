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

public class ModifyForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");

		BoardService svc = new BoardServiceImpl();
		SearchVO search = new SearchVO(Integer.parseInt(page),sc,kw);

		BoardVO brd = svc.getBoard(Integer.parseInt(bno));

		req.setAttribute("board", brd);
		req.setAttribute("search", search);

		req.getRequestDispatcher("board/modifyBoardForm.tiles").forward(req, resp);
	}

}
