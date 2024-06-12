
package co.yedam.service;

import java.util.List;

import co.yedam.vo.BoardVO;

//기능실행 mapper실행
public interface BoardService {
	List<BoardVO> BoardList(int page);

	int boardTotal();

	BoardVO getBoard(int bno); // 단건 조회

	boolean addBoard(BoardVO bvo);

	boolean editBoard(BoardVO bvo);

	boolean removeBoard(int bno);

}
