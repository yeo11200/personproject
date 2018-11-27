package com.sin1.message.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sin1.message.dao.MessageDAO;
import com.sin1.message.dto.MessageDTO;
import com.sin1.util.PageObject;


//자동생성 - @Controller, @Service, @Repository, @Conponent, @RestController
//단, 반드시 servlet-context.xml 에 componet-scan의 base-package 안에 있어야 한다.
@Service
public class MessageService {
	
	//Controller -> service -> dao 
	// DI 적용
	@Inject
	private MessageDAO dao;
	
	// 메시지 리스트
	// accepter : 받는 사람의 아이디 - session에 들어 있는 로그인 정보
	public List<MessageDTO> list(PageObject pageObject){
		System.out.println(getClass().getSimpleName()+".list()");
		// page처리를 위해서 전체 글의 갯수등을 계산해서 넣어야 한다.
		// 검색을 위해을 위해서 전체 글의 갯수를 찾을 때 검색단어가 포함되어 있는 pageObject를 넘긴다.
		pageObject.setTotalRow(dao.getTotal(pageObject));
		System.out.println(pageObject);
		return dao.list(pageObject);
	}
	// 메시지 보기
	// transaction 적용
	// dao.accepted(), dao.discount(), dao.view()가 모두 같은 connection을
	// 사용하도록 관리해준다.
	@Transactional
	public MessageDTO view(int no, String id){
		System.out.println(getClass().getSimpleName()+".view()");
		System.out.println("MessageDAO.view().no/id:"+no+"/"+id);
		// 읽지 않은 메시지인 경우 : where acceptDate = null
		// 읽은 날짜를 오늘 날짜로 셋팅한다.
		// 읽지 않은 메시지가 읽혀진 경우 (리턴이 1)
		// 회원 테이블에서 회원의 읽지 않은 메시지 카운트를 -1해준다.
		int cnt = dao.accepted(no);
		System.out.println("MessageDAO.view().cnt:"+cnt);
		if(cnt==1) dao.discount(id);;
		
		return dao.view(no);
	}
	
	// 메시지 쓰기
	@Transactional
	public void write(MessageDTO dto){
		System.out.println(getClass().getSimpleName()+".write()");
		// 회원테이블의 메시지에 +1증가시킨다.
		dao.increase(dto.getAccepter());
		dao.write(dto);
	}
	// 메시지 삭제
	public void delete(int no){
		System.out.println(getClass().getSimpleName()+".delete()");
		dao.delete(no);
	}
	
}
