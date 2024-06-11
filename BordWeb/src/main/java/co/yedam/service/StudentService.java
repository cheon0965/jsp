package co.yedam.service;

import java.util.List;

import co.yedam.vo.Student;

public interface StudentService {
	List<Student> studenList();

	boolean addStudent(Student std);

	boolean modifyStudent(Student std);
}
