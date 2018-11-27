package com.sin1.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sin1.board.dto.ReplyBoardDTO;
import com.sin1.util.PageObject;
import com.sin1.util.ReplyPageObject;

@Repository
public class ReplyBoardDAO {
	@Inject
	private SqlSession session;
	
	private final String NAME_SPACE = "com.sin1.mapper.ReplyBoardMapper.";
	
	public List<ReplyBoardDTO> list(ReplyPageObject pageObject){
		//pageObject
//		Map<String, Object> map = new HashMap<>();
//		map.put("no", no);
//		System.out.println(no);
//		map.put("pageObject", pageObject);
//		System.out.println(pageObject);
//		System.out.println(map);
		return session.selectList(NAME_SPACE+"Replylist", pageObject);
		//pageObject
	}
	
	public void ReplyWrite(ReplyBoardDTO dto) {
		session.insert(NAME_SPACE+"ReplyWrite", dto);
	}
	// 대댓글을 구현하려다가 실패함...
	public ReplyBoardDTO view(int rno) {
		return session.selectOne(NAME_SPACE+"ReplyView", rno);
	}
//	
//	public void questWriter(ReplyBoardDTO dto) {
//		session.insert(NAME_SPACE+"questWriter", dto);
//	}
//	
//	public void answerWriter(ReplyBoardDTO dto) {
//		session.insert(NAME_SPACE+"answerWriter", dto);
//	}
//	public void increaseOrdNo(ReplyBoardDTO dto) {
//		session.update(NAME_SPACE+"increaseOrdNo",dto);
//	}
//	
	
	public void ReplyUpdate(ReplyBoardDTO dto) {
		session.update(NAME_SPACE+"ReplyUpdate", dto);
	}
	
	public void ReplyDelete(int rno) {
//		Map<String, Integer> map = new HashMap<>();
//		map.put("rno", no);
//		map.put("no", no);
		session.delete(NAME_SPACE+"ReplyDelete", rno);
	}
	
	public int page(ReplyPageObject pageObject) {
		return session.selectOne(NAME_SPACE+"page", pageObject);
	}
}
