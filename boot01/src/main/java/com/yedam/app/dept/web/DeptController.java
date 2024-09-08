package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller // rout : 사용자의 요청(endpoint)와 그에 대한 처리
            // : URL + METHOD => Service -> View
public class DeptController {
	
	// 해당 컨트롤러에서 제공하는 서비스
	private DeptService deptService;
		
	@Autowired
	DeptController(DeptService deptService){
		this.deptService = deptService;
	}
	
	// GET : 조회 빈페이지
	// POST : 데이터 조회(등록, 수정, 삭제)
	
	// 전체조회 : GET
	@GetMapping("deptList")
	public String deptList(Model model) {
		// 1) 해당 기능 수행
		List<DeptVO> list = deptService.deptList();
		
		// 2) 클라이언트에 전달할 데이터 담기
		model.addAttribute("depts", list);		
		
		return "dept/list";
	}
	
	// 단건조회 : GET => QueryString
	@GetMapping("deptInfo")
	public String deptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.deptInfo(deptVO);
		
		model.addAttribute("dept", findVO);
		
		return "dept/info"; 
	}
	
	
	
	// 등록 - 페이지 : GET
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert"; 
	}
	
	
	// 등록 - 처리 : POST
	@PostMapping("deptInsert")
	public String deptInsertProcess(DeptVO deptVO) {
		int eid = deptService.deptInsert(deptVO);
		String url = null;
		if(eid > -1) {
			// 정상적으로 등록된 경우
			url = "redirect:deptInfo?deptloyeeId=" +eid;
		}else {
			// 등록되지 않은 경우
			url = "redirect:deptList";
		}
		return url; 
	}
	
	
	// 수정 - 페이지 : GET <=> 단건조회
	@GetMapping("deptUpdate")
	public String deptUpdateForm(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.deptInfo(deptVO);		
		model.addAttribute("dept", findVO);		
		return "dept/update"; 
	}	
	
	// 수정 - 처리 : AJAX => QueryString
//	@PostMapping("deptUpdate")
//	@ResponseBody // AJAX
//	public Map<String, Object> deptUpdateAJAXQueryString(deptVO deptVO){
//		return deptService.deptUpdate(deptVO);
//	}
	
	// 수정 - 처리 : AJAX => JSON(@RequestBody)
	@PostMapping("deptUpdate")
	@ResponseBody // AJAX
	public Map<String, Object> deptUpdateAJAXJSON(@RequestBody DeptVO deptVO){
		return deptService.deptUpdate(deptVO);
	}
	
	// 삭제 - 처리 : GET
	@GetMapping("deptDelete")
	public String deptDelete(Integer deptloyeeId) {
		deptService.deptDelete(deptloyeeId);
		return "redirect:deptList";
	}
	
}
