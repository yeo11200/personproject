package com.sin1.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sin1.board.dao.ReplyBoardDAO;
import com.sin1.board.dto.ReplyBoardDTO;
import com.sin1.util.PageObject;
import com.sin1.util.ReplyPageObject;

@Service
public class ReplyBoardService {
	@Inject
	private ReplyBoardDAO dao;
	
	public List<ReplyBoardDTO> list(ReplyPageObject pageObject){
		//pageObject
		pageObject.setTotalRow(dao.page(pageObject));
		return dao.list(pageObject );
	}
	
	public void ReplyWrite(ReplyBoardDTO dto) {
		dao.ReplyWrite(dto);
	}
	
	public ReplyBoardDTO view(int rno) {
		return dao.view(rno);
	}
//	
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
	public void ReplyUpdate(ReplyBoardDTO dto) {
		dao.ReplyUpdate(dto);
	}
	
	public void ReplyDelete(int rno) {//int rno,
		dao.ReplyDelete(rno);
	}
	
}
