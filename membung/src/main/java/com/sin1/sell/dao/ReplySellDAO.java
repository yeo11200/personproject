package com.sin1.sell.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sin1.board.dto.ReplyBoardDTO;
import com.sin1.sell.dto.ReplySellDTO;
import com.sin1.util.PageObject;
import com.sin1.util.ReplyPageObject;

@Repository
public class ReplySellDAO {
	@Inject
	private SqlSession session;
	
	private final String NAME_SPACE = "com.sin1.mapper.ReplySellMapper.";
	
	// 게시판 댓글에 대한 것을 보기위한 것이다
	public List<ReplySellDTO> list(ReplyPageObject pageObject){
		//pageObject
		return session.selectList(NAME_SPACE+"ReplyList", pageObject);
		//pageObject
	}
	// 게시판 댓글보기가 필요있는이유는 댓글은 rno로 댓글 수정을 해주기 위해서 이다..
	public ReplySellDTO view(int rno) {
		return session.selectOne(NAME_SPACE+"ReplyView", rno);
	}
	
	// 게시판 댓글 쓰기
	public void ReplyWrite(ReplySellDTO dto) {
		session.insert(NAME_SPACE+"ReplyWrite", dto);
	}
	
	// 게시판 댓글 업데이트를 하기위한 메서드
	public void ReplyUpdate(ReplySellDTO dto) {
		session.update(NAME_SPACE+"ReplyUpdate", dto);
	}
	
	// 게시판 댓글을 삭제 하기위한 메서드
	public void ReplyDelete(int rno) {
		session.delete(NAME_SPACE+"ReplyDelete", rno);
	}
	
	public int page(ReplyPageObject pageObject) {
		return session.selectOne(NAME_SPACE+"page", pageObject);
	}
}
