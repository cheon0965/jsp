package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController // Controller + ResponseBody ( 모든 하위메소드에 )
				// ResponseBody : AJAX
public class DeptRestController {

	private DeptService deptService;

	@Autowired
	public DeptRestController(DeptService deptService) {
		this.deptService = deptService;
	}

	// 전체조회 : GET => depts
	@GetMapping("depts")
	public List<DeptVO> deptList() {
		return deptService.deptList();
	}

	// 단건조회 : GET => depts/100
	@GetMapping("depts/{eid}")
	public DeptVO deptInfo(@PathVariable(name = "eid") Integer deptloyeeId) {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(deptloyeeId);
		return deptService.deptInfo(deptVO);
	}

	// 등록 :POST => depts
	@PostMapping("depts")
	public int deptInsert(@RequestBody DeptVO deptVO) {		
		return deptService.deptInsert(deptVO);
	}
	
	// 수정 : PUT => depts/100
	@PutMapping("depts/{eid}")
	public Map<String, Object> deptUpdate(@PathVariable(name = "eid") Integer deptloyeeId,@RequestBody DeptVO deptVO) {
		deptVO.setDepartmentId(deptloyeeId);
		return deptService.deptUpdate(deptVO);
	}
	

	// 삭제 : DELETE => depts/100
	@DeleteMapping("depts/{deptloyeeId}")
	public Map<String, Object> deptUpdate(@PathVariable Integer deptloyeeId) {
		return deptService.deptDelete(deptloyeeId);
	}
}
