package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	// 전체조회
	public List<EmpVO> selecEmpAllList();

	// 단건조회
	public EmpVO selectEmpInfo(EmpVO empVo);

	// 등록
	public int insertEmpInfo(EmpVO empVo);

	// 수정
	public int updateEmpInfo(@Param("id") int empId,@Param("emp") EmpVO empVo);

	// 삭제
	public int deleteEmpInfo(int empId);

}
