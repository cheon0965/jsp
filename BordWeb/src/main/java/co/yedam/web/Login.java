package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class Login implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		BoardService svc = new BoardServiceImpl();
		HttpSession session = req.getSession();
		MemberVO mvo = svc.checkMember(id, pw);
		
		
		if(mvo != null) {
			// 로그인.
			System.out.println("로그인됨");
			session.setAttribute("logId", id);
			
			if(mvo.getResponsibility().equals("User")) {
				resp.sendRedirect("main.do");
			}else if(mvo.getResponsibility().equals("Admin")) {
				resp.sendRedirect("memberList.do");
			}
			
		}else {
			resp.sendRedirect("loginForm.do");
		}

	}

}
