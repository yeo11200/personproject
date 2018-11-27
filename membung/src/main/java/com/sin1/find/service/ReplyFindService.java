package com.sin1.find.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sin1.board.dao.ReplyBoardDAO;
import com.sin1.board.dto.ReplyBoardDTO;
import com.sin1.sell.dao.ReplySellDAO;
import com.sin1.sell.dto.ReplySellDTO;
import com.sin1.sell.dto.SellDTO;
import com.sin1.find.dao.ReplyFindDAO;
import com.sin1.find.dto.ReplyFindDTO;
import com.sin1.util.PageObject;
import com.sin1.util.ReplyPageObject;

@Service
public class ReplyFindService {
	@Inject
	private ReplyFindDAO dao;
	
	// 댓글리스트
	public List<ReplyFindDTO> list(ReplyPageObject pageObject){
		// pageObject
		pageObject.setTotalRow(dao.page(pageObject));
		return dao.list(pageObject);
		// pageObject
	}
	// 댓글 보기가 필요한 이유는 업데이트할때 글번호로 그 해당하는 값을 불러오기 위해서이다
	public ReplyFindDTO view(int rno) {
		return dao.view(rno);
	}
	//	댓글 쓰기
	public void ReplyWrite(ReplyFindDTO dto) {
		dao.ReplyWrite(dto);
	}
//	public void questWrite(ReplyBoardDTO dto) {
//		dao.questWriter(dto);
//	}
//	
//	public void answerWrite(ReplyBoardDTO dto) {
//		// 데이터 조정하기 
//		// refNo = refNo
//		// ordNo = ordNo
//		// levNo = levNo+1
//		// prentNo = no
//		dto.setRefNo(dto.getRefNo());
//		dto.setOrdNo(dto.getOrdNo());
//		dto.setLevNo(dto.getLevNo()+1);
//		dto.setParentNo(dto.getRno());
//		dao.increaseOrdNo(dto);
//		dao.answerWriter(dto);  
//	}
//	
	// 댓글수정
	public void ReplyUpdate(ReplyFindDTO dto) {
		dao.ReplyUpdate(dto);
	}
	
	// 댓글 삭제
	public void ReplyDelete(int rno) {
		dao.ReplyDelete(rno);
	}
	
}
