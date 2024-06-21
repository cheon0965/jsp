package co.yedam.service;

import java.util.List;

import co.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int boardNo, int page);
	

	ReplyVO getReply(int replyNo);

	boolean registerReply(ReplyVO rvo);

	boolean removeReply(int replyNo);
	
	int getTotalCount(int bno);
}
