package co.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.web.AddBodard;
import co.yedam.web.AddFrom;
import co.yedam.web.AddStudent;
import co.yedam.web.BoardList;
import co.yedam.web.GetBoard;
import co.yedam.web.LoginForm;
import co.yedam.web.Logout;
import co.yedam.web.MainControl;
import co.yedam.web.ModifyBoard;
import co.yedam.web.ModifyForm;
import co.yedam.web.ProductControl;
import co.yedam.web.RemoveBoard;
import co.yedam.web.RemoveForm;
import co.yedam.web.StudentForm;
import co.yedam.web.Login;

// front -> 요청url(*.do) - 실행컨트롤 매칭.
// main.do -> FrontController -> /WEB-INF/public/main.jsp
// 객체생성 -> init -> service -> destroy
public class FrontController extends HttpServlet {
	private Map<String, Control> map; // key: url, value: control
	
	public FrontController() {
		map = new HashMap<>();
	}
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/product.do", new ProductControl());
		// 학생등록화면 studentFrom.do
		map.put("/studentForm.do", new StudentForm()); // 등록화면
		map.put("/addStudent.do", new AddStudent()); // 정보db에 저장.
		
		// 게시글 목록.
		map.put("/boardList.do", new BoardList());
		
		// 상세화면
		map.put("/getBoard.do", new GetBoard());
		map.put("/addForm.do", new AddFrom());
		map.put("/addBodard.do", new AddBodard());
		//
		map.put("/removeForm.do", new RemoveForm());
		map.put("/removeBoard.do", new RemoveBoard());
		//
		map.put("/modifyForm.do", new ModifyForm());
		map.put("/modifyBoard.do", new ModifyBoard());
		// 로그인
		map.put("/loginForm.do", new LoginForm());
		map.put("/login.do", new Login());
		// 로그아웃
		map.put("/logout.do", new Logout());
		
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI(); // http://localhost/BoardWeb/main.do
//		System.out.println("uri: " + uri); // /BoardWeb/main.do
		String context = req.getContextPath(); // /BoardWeb => project name.
//		System.out.println("context: " + context);
		String page = uri.substring(context.length());
//		System.out.println("page: " + page);
		
		Control result = map.get(page);
		result.exec(req, resp);
		System.out.println("result: " + result);
	}
}
