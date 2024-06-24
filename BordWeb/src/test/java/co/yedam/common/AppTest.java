package co.yedam.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import co.yedam.mapper.BoardMapper;
import co.yedam.mapper.ReplyMapper;
import co.yedam.mapper.StudentMapper;
import co.yedam.service.BoardService;
import co.yedam.service.BoardServiceImpl;
import co.yedam.vo.BoardVO;
import co.yedam.vo.ReplyVO;
import co.yedam.vo.Student;

public class AppTest {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DetaSource.getInstance();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		// interface - 구현객체.
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
//		BoardService svc = new BoardServiceImpl();
//		System.out.println(svc.getBoard(100));
		
//		Student std = new Student();
//		std.setStdNo("s0010");
//		std.setStdName("김영식");
//		std.setPhone("010-3333-2222");
//		std.setBldType("O");
//		
//		sqlSession.insert("co.yedam.mapper.StudentMapper.insertStudent", std);
//		sqlSession.commit();
		
//		sqlSession.update("co.yedam.mapper.StudentMapper.updateStudent", std);
		
//		mapper.updateStudent(std);

		
//		sqlSession.commit();
		
//		List<Student> list = sqlSession.selectList("co.yedam.mapper.StudentMapper.selectBlog");
		
//		SearchVO search = new SearchVO(1, "T", "java");
//		mapper.boardListPaging(search).forEach(bvo -> System.out.println(bvo));
		
		
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		
//		mapper.seleList(201).forEach(t -> System.out.println(t));
		
//		ReplyVO rvo = mapper.selectReply(1);
//		System.out.println(rvo);
		
//		ReplyVO rvo = new ReplyVO();
//		rvo.setReply("TEST");
//		rvo.setReplyer("admin");
//		rvo.setBoardNo(201);
//		
//		if(mapper.insertReply(rvo)==1) {
//			System.out.println("입력성공");
//		}
//		try {
//			if(mapper.deleteReply(4)==1) {
//				System.out.println("삭제성공");
//			}
//		} catch (Exception e) {
//			System.out.println("예외발생");
//		}
//		CenterVO cvo1 = new CenterVO();
//		cvo1.setAddress("add1");
//		cvo1.setId("1");
//		cvo1.setCenterName("cn1");
//		cvo1.setSido("sd1");
//		cvo1.setPhoneNumber("ph1");
//		
//		CenterVO cvo2 = new CenterVO();
//		cvo2.setAddress("add2");
//		cvo2.setId("2");
//		cvo2.setCenterName("cn2");
//		cvo2.setSido("sd2");
//		cvo2.setPhoneNumber("ph2");
//		
//		CenterVO[] centers = {cvo1, cvo2};
//		int r = mapper.insertCenter(centers);
//		System.out.println(r + "건 입력.");''
		
		List<Map<String, Object>> result = mapper.centerBysido();
		for(Map<String, Object> map : result) {
			Set<String> keyset = map.keySet();
				System.out.println(map.get("sido") + "," + map.get("cnt"));
		}		
	}
}
