package co.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.yedam.common.CenterVO;
import co.yedam.vo.ReplyVO;

public interface ReplyMapper {
	// 목록, 단건조회, 등록, 삭제
	List<ReplyVO> seleList(int replyNo);
	
	List<ReplyVO> selectListPaging(@Param("boardNo") int boardNo, @Param("page") int page);

	ReplyVO selectReply(int replyNo);

	int insertReply(ReplyVO rvo);

	int deleteReply(int replyNo);
	
	// 댓글건수.
	int selectReplyCnt(int bno);
	
	// 센터정보 생성.
	int insertCenter(CenterVO[] arr);
	
	// 시도별 센터갯수 차트.
	List<Map<String, Object>> centerBysido();

}
