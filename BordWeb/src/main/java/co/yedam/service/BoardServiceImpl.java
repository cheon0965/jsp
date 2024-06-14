package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DetaSource;
import co.yedam.common.SearchVO;
import co.yedam.mapper.BoardMapper;
import co.yedam.mapper.StudentMapper;
import co.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	SqlSession sqlSession = DetaSource.getInstance().openSession(true);
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> BoardList(SearchVO search) {
		return mapper.boardListPaging(search);
	}

	@Override
	public int boardTotal(SearchVO search) {
		return mapper.getTotalCnt(search);
	}

	@Override
	public BoardVO getBoard(int bno) {
		return mapper.selectBoard(bno);
	}

	@Override
	public boolean addBoard(BoardVO bvo) {
		return mapper.insertBoard(bvo) == 1;
	}

	@Override
	public boolean editBoard(BoardVO bvo) {
		return mapper.updateBoard(bvo) == 1;
	}

	@Override
	public boolean removeBoard(int bno) {
		return mapper.deleteBoard(bno) == 1;
	}

	@Override
	public boolean checkMember(String id, String pw) {
		// TODO Auto-generated method stub
		return mapper.selectMember(id, pw) == 1;
	}

}
