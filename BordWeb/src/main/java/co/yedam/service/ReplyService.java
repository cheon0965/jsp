package co.yedam.service;

import java.util.List;

import co.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int replyNo);

	ReplyVO getReply(int replyNo);

	boolean registerReply(ReplyVO rvo);

	boolean removeReply(int replyNo);
}
