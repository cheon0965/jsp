package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DetaSource;
import co.yedam.mapper.BoardMapper;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService{
	SqlSession sqlSession = DetaSource.getInstance().openSession(true);
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public List<BoardVO> BoardList() {
		return mapper.boardList();
	}

	@Override
	public BoardVO getBoard(int bno) {
		return null;
	}

	@Override
	public boolean addBoard(BoardVO bvo) {
		return false;
	}

	@Override
	public boolean editBoard(BoardVO bvo) {
		return false;
	}

	@Override
	public boolean removeBoard(int bno) {
		return false;
	}

}
