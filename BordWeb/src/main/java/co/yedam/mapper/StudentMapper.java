package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.Student;

public interface StudentMapper {

	public List<Student> selectBlog();

	public int insertStudent(Student student);

	public int updateStudent(Student student);
	

	// 단건조회/
	public Student getstuStudent(String stdNo);
	public int deletStudent(Student student);
	

}
