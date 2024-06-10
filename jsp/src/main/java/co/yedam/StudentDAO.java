package co.yedam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO{
	// 삭제
	boolean deleteStudent(Student std) {
		getConnection();
		String sql = "delete from tbl_student where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo());
			if(psmt.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();// 자원 해제.
		}
		return false;
	}
	// 수정
	boolean updateStudent(Student std) {
		getConnection();
		String sql = "UPDATE tbl_student set phone = ? where std_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getPhone());
			psmt.setString(2, std.getStdNo());
			if(psmt.executeUpdate() == 1) {
				return true;			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();// 자원 해제.
		}
		return false;
	}
	
	//등록, 삭제, 수정, 목록 기능 구현.
	boolean insertStudent(Student std) {
		getConnection();
		String sql = "insert into tbl_student(std_no, std_name, phone, bld_type) values(?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStdNo());
			psmt.setString(2, std.getStdName());
			psmt.setString(3, std.getPhone());
			psmt.setString(4, std.getBldType());
			if(psmt.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();// 자원 해제.
		}
		
		return false;
	}
	
	// 등록 삭제 수정 목록 기능 구현
	List<Student> studentList(){
		getConnection();
		String sql = "select * from tbl_student order by std_no";
		List<Student> students = new ArrayList<Student>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			// 조회된 결과목록을 List<Student>에 담아서 반환.
			while(rs.next()) {
				Student std = new Student();
				std.setStdNo(rs.getString("std_no"));
				std.setStdName(rs.getString("std_name"));
				std.setPhone(rs.getString("phone"));
				std.setBldType(rs.getString("bld_type"));
				std.setCreateDate0(rs.getString("create_date"));
				
				students.add(std); // 데이터배이스의 초회값 하나를 List에 담아줌.
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();// 자원 해제.
		}
		return students;
	}
	
}//class
