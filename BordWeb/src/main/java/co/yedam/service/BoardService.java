
package co.yedam.service;

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.vo.BoardVO;
import co.yedam.vo.MemberVO;

//기능실행 mapper실행
public interface BoardService {
	List<BoardVO> BoardList(SearchVO search);

	int boardTotal(SearchVO search);

	BoardVO getBoard(int bno); // 단건 조회

	boolean addBoard(BoardVO bvo);

	boolean editBoard(BoardVO bvo);

	boolean removeBoard(int bno);
	
	// checkMember(id,pw)
	MemberVO checkMember(String id, String pw);

}
