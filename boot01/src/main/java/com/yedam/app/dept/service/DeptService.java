package com.yedam.app.dept.service;

import java.util.List;
import java.util.Map;

// 실제로 사용자에게 제공하는 기능
public interface DeptService {

	// 전제 사원정보 조회
	public List<DeptVO> deptList();

	// 사원정보 단건 조회
	public DeptVO deptInfo(DeptVO deptVO);

	// 사원정보 단건 등록
	public int deptInsert(DeptVO deptVO);

	// 사원정보 단건 수정
	public Map<String, Object> deptUpdate(DeptVO deptVO);

	// 사원정도 단건 삭제
	public Map<String, Object> deptDelete(int deptId);

}
