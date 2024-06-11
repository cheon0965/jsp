package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DetaSource;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.Student;

public class StudentServiceImpl implements StudentService{
	SqlSession sqlSession = DetaSource.getInstance().openSession(true);
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

	@Override
	public List<Student> studenList() {
		return mapper.selectBlog();
	}

	@Override
	public boolean addStudent(Student std) {
		return mapper.insertStudent(std) == 1;
	}

	@Override
	public boolean modifyStudent(Student std) {
		return mapper.updateStudent(std) == 1;
	}

}
