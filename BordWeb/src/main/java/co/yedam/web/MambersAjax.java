package co.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.MemberVO;

public class MambersAjax implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=UTF-8");
		// json 문자열 반환.
		// {"name":"홍길동","age":20,"phone":"010-1234-5678"}
		BoardService svc = new BoardServiceImpl();
		List<MemberVO> list = svc.memberList();
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		resp.getWriter().print(json);

	}

}
