package co.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.vo.BoardVO;

// 목록 등록 수정 삭제 단건조회
public interface BoardMapper {
	List<BoardVO> boardList(); //전체 목록

	List<BoardVO> boardListPaging(int page); // 페이징 페이지별 5칸
	
	int getTotalCnt(); // 페이징 계산 용도

	int insertBoard(BoardVO bvo);

	int updateBoard(BoardVO bvo);

	int deleteBoard(int bno);

	BoardVO selectBoard(int bno);
	
	// 회원id, 회원비번
	int selectMember(@Param("id") String id, @Param("pw") String pw);
}
