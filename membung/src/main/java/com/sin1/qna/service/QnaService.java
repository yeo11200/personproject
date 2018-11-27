package com.sin1.qna.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sin1.qna.dao.QnaDAO;
import com.sin1.qna.dto.QnaDTO;
import com.sin1.util.PageObject;

@Service
public class QnaService {
	
	@Inject
	private QnaDAO dao;
	
	// Qna리스트
	public List<QnaDTO> list(PageObject pageObject){
		pageObject.setTotalRow(dao.page(pageObject));
		return dao.list(pageObject);
	}
//  jsp에서 페이지 처리를 하기위해서 다 가지고온것이다.
//	public List<QnaDTO> service(PageObject page){
//		page.setTotalRow(dao.count());
//		return dao.list(page);
//	}
	// Qna 보기
	public QnaDTO view(int no, boolean isView) {
		if(isView) {dao.increase(no);}
		return dao.view(no);
	}
	// 질문하기
	public void questWrite(QnaDTO dto) {
		dao.questWrite(dto);
	}
	
	// 답변하기
	public void answerWrite(QnaDTO dto) {
		// 데이터를 조정하기
		// refNo = refNo, ordNo = ordNo+1, levNo = levNo+1, parentNo = No
		// no : 게시판번호refNo : 그룹번호, ordNo : 대댓글, levNo : 댓글의 깊이, parentNo 부모글(댓글)
		dto.setOrdNo(dto.getOrdNo()+1);
		dto.setLevNo(dto.getLevNo()+1);
		dto.setPareantNo(dto.getNo());
		
		dao.increaseOrdNo(dto);
		// 답변 쓰기에서 관련글의 순서번호와 같거나 큰 데이터의 순서 번호를 1 증가 시켜야만 한다.  
		dao.answerWrite(dto);
	}     
	
	// 질문수정
	public void questUpdate(QnaDTO dto) {
		dao.questUpdate(dto);
	}
	
	// 답변수정
	public void answerUpdate(QnaDTO dto) {
		dao.answerUpdate(dto);
	}
	
	// Qnd삭제
	public void delete(int no) {
		dao.delete(no);
	}
}
