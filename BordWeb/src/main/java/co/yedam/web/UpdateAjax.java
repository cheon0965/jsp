package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class UpdateAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		System.out.println(id + "id");
		MemberVO mvo = new MemberVO();
		BoardService svc = new BoardServiceImpl();
		
		mvo.setUserId(id);
		mvo.setUserName(name);
		mvo.setUserPw(pass);
		
		if (svc.updateMemberAjax(mvo)) {
			resp.getWriter().print("{\"returnCod\":\"success\"}"); 
		} else {
			resp.getWriter().print("{\"returnCod\":\"Not success\"}"); 
		}

		
	}

}
