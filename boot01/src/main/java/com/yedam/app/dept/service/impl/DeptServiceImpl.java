package com.yedam.app.dept.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;
import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor
public class DeptServiceImpl implements DeptService {

	private DeptMapper deptMapper;

	@Autowired
	DeptServiceImpl(DeptMapper deptMapper) {
		this.deptMapper = deptMapper;
	}

	@Override
	public List<DeptVO> deptList() {
		return deptMapper.selecDeptAllList();
	}

	@Override
	public DeptVO deptInfo(DeptVO deptVO) {
		return deptMapper.selectDeptInfo(deptVO);
	}

	@Override
	public int deptInsert(DeptVO deptVO) {
		int result = deptMapper.insertDeptInfo(deptVO);
		return result == 1 ? deptVO.getDepartmentId() : -1;
	}

	@Override
	public Map<String, Object> deptUpdate(DeptVO deptVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean isSuccessed = false;

		int result = deptMapper.updateDeptInfo(deptVO.getDepartmentId(), deptVO);

		if (result == 1) {
			isSuccessed = true;
		}
		
		map.put("result", isSuccessed);
		map.put("tartet", deptVO);
		
		return map;
	}

	@Override
	public Map<String, Object> deptDelete(int detpId) {
		Map<String, Object> map = new HashMap<String, Object>();	
		int result = deptMapper.deleteDeptInfo(detpId);
		
		if (result == 1) {
			map.put("departmentId", detpId);
		}
		
		return map;
	}


}
