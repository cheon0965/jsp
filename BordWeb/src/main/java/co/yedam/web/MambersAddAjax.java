/**
 * 
 */
package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

/**
 * 
 */
public class MambersAddAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 파라미터 4개 -> DB입력 -> OK 반환.
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String responsibility = req.getParameter("duty");
		
		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		mvo.setUserName(name);
		mvo.setResponsibility(responsibility);
		
		BoardService svc = new BoardServiceImpl();
		if(svc.insertMember(mvo)) { // {"retCod":"OK","retMsg":"Success"}
			resp.getWriter().print("{\"retCod\":\"OK\",\"retMsg\":\"Success\"}");
		}else { // {"retCod":"NG","retMsg":"Fail"}
			resp.getWriter().print("{\"retCod\":\"NG\",\"retMsg\":\"Fail\"}");
			
		}
	}
}



