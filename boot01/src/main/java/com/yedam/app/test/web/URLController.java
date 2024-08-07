package com.yedam.app.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yedam.app.emp.service.EmpVO;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Bran 등록, web과 관련된 부분
public class URLController {
//	@RequestMapping(path = "/test", method=RequestMethod.GET)
	@GetMapping("/test")
	@ResponseBody
	public String urlGetTest(String keyword) {
		return "Server Response : Get Method\n Selevt - " + keyword;
	}

	@PostMapping("/test")
	@ResponseBody
	public String urlPostTest( EmpVO empVO) {
		return "id : " + empVO.getEmployeeId() + " name : " + empVO.getLastName();
	}

}
