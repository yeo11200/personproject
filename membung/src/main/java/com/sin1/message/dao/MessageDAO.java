package com.sin1.message.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sin1.message.dto.MessageDTO;
import com.sin1.util.PageObject;

//자동생성 - @Controller, @Service, @Repository, @Component, @RestController
//단, 반드시 servlet-context.xml 에 component-scan의 basc package 안에 있다. 
@Repository
public class MessageDAO {

	// Mybatis - Spring의 DI(Dependency Injection:의존성 주입) 적용
	// root-context.xml에 선언된 sqlSession을 가져온다.
	@Inject
	private SqlSession sqlSession;
	
	//Controller -> service -> dao 
	
	// mapper xml에서 사용하는 nameSpace 지정해서 사용하자.
	private final String NAME_SPACE ="com.sin1.mapper.MessageMapper.";

	// 메시지 리스트 - 받은 사람의 메시지 리스트
	// 받는 사람의 ID, 읽은 메시지나 안 읽은 메시지가 페이지 Object에 포함이 되어 있어야 한다.
	public List<MessageDTO> list(PageObject pageObject){
		System.out.println(getClass().getSimpleName()+".list()");
		// sql 문장은 /src/main/resources/mappers/messageMapper.xml에 정의해 놓는다.
		return sqlSession.selectList(NAME_SPACE + "list",pageObject);
	}
	
	// 메시지 보기
	public MessageDTO view(int no){
		System.out.println(getClass().getSimpleName()+".view()");
		// sql 문장은 /src/main/resources/mappers/messageMapper.xml에 정의해 놓는다.
		return sqlSession.selectOne(NAME_SPACE+"view", no);
	}

	// 메시지를 읽으면 받는 사람 아이디의 회원정보의 메시지 카운트를 -1한다.
	public void discount(String id){
		System.out.println(getClass().getSimpleName()+".discount()");
		// 데이터를 수정.
		sqlSession.update(NAME_SPACE+"discount", id);
	}


	// 메시지 보내기(쓰기)
	public void write(MessageDTO dto){
		System.out.println(getClass().getSimpleName()+".write()");
		// DB에 저장
		sqlSession.insert(NAME_SPACE+"write", dto);
	}
	
	// 메시지 보내기를 하면 받는 사람의 아이디의 회원정보의 메시지 카운트를 +1한다.
	public void increase(String id){
		System.out.println(getClass().getSimpleName()+".increase()");
		System.out.println("increase id:"+id);
		
		// 데이터를 수정.
		sqlSession.update(NAME_SPACE+"increase", id);
	}

	
	// 메시지 삭제
	public void delete(int no){
		System.out.println(getClass().getSimpleName()+".delete()");
		// DB에서 글 삭제
		sqlSession.delete(NAME_SPACE+"delete", no);
	}

	// 메세지 읽기처리
	public int accepted(int no){
		System.out.println(getClass().getSimpleName()+".accepted()");
		// 데이터를 수정.
		return sqlSession.update(NAME_SPACE+"accepted", no);
	}
	
	// 메시지 페이지 처리를 위해 전체 글의 갯수를 구하는 메서드
	public int getTotal(PageObject pageObject) {
		return sqlSession.selectOne(NAME_SPACE+"total", pageObject);
	}


	// 메인 페이지 보여줄 보지 않은 받은 메시지의 갯수
	// id가 넘어와야 한다.
	public int getNotReadCount(String id) {
		return sqlSession.selectOne(NAME_SPACE+"notReadCount", id);
	}
}
