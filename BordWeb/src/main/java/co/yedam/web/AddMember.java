package co.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class AddMember implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Multipart 요청(1.요청정보 2.저장위치 3.최대크기 4.인코딩방식 5.리네임정책
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1024 * 5;
		String encoString = "UTF-8";		
		
		MultipartRequest mr = new MultipartRequest(req, savePath, maxSize, encoString, new DefaultFileRenamePolicy());
		
		String id = mr.getParameter("id");
		String pw = mr.getParameter("pw");
		String name = mr.getParameter("name");
		String img = mr.getFilesystemName("myImage");
		
		MemberVO mvo = new MemberVO();
		mvo.setUserId(id);
		mvo.setUserPw(pw);
		mvo.setUserName(name);
		mvo.setResponsibility("User");
		mvo.setImg(img);
		
		BoardService svc = new BoardServiceImpl();
		
		if(svc.insertMember(mvo)) { // {"retCod":"OK","retMsg":"Success"}
//			resp.getWriter().print("{\"retCod\":\"OK\",\"retMsg\":\"Success\"}");
			resp.sendRedirect("memberList.do");
		}else { // {"retCod":"NG","retMsg":"Fail"}
			resp.getWriter().print("{\"retCod\":\"NG\",\"retMsg\":\"Fail\"}");
			
		}

	}

}
