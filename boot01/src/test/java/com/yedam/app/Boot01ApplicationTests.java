package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest  // @SpringBootTest => 테스트환경에서 IOC 컨테이너를 생성함
class Boot01ApplicationTests {
	
	@Autowired // 필드주입 Test 환경에서만 사용 보안상 문제 발생 가능성
	EmpMapper empMapper;
	
//	@Test
	void empList() { // 전체조회
			List<EmpVO> list = empMapper.selecEmpAllList();
			assertTrue(!list.isEmpty());
	}
	
//	@Test
	void empINFO() { // 단건조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals("King", findVO.getLastName());
	}
	
//	@Test
	void empInsert() { // 등록
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Hong");
		empVO.setEmail("kdHong@google.com");
		empVO.setJobId("IT_PROG");
		
		int result = empMapper.insertEmpInfo(empVO);
		System.out.println(empVO.getEmployeeId());
		assertEquals(1, result);
	}
	
	@Test
	void empUpdate() { // 수정
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Lee");
		empVO.setJobId("IT_PROG");
		empVO.setSalary(10000);
		
		int result = empMapper.updateEmpInfo(315, empVO);
		assertEquals(1, result);
	}
	
//	@Test
	void empDelete() { // 삭제		
		int result = empMapper.deleteEmpInfo(316);
		assertEquals(1, result);
	}
}
