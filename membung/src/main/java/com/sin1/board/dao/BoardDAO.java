package com.sin1.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sin1.board.dto.BoardDTO;
import com.sin1.util.PageObject;

@Repository
public class BoardDAO {
	@Inject
	private SqlSession session;
	
	private final String NAME_SPACE = "com.sin1.mapper.BoardMapper.";
	
	public List<BoardDTO> list(PageObject pageObject){
		// pageObject
		return session.selectList(NAME_SPACE+"list", pageObject);
		// pageObject
	}
	
	public BoardDTO view(int no) {
		return session.selectOne(NAME_SPACE+"view", no);
	}
	
	public void write(BoardDTO dto) {
		session.insert(NAME_SPACE+"write", dto);
	}
	
	public void update(BoardDTO dto) {
		session.update(NAME_SPACE+"update", dto);
	}
	
	public void delete(int no) {
		session.delete(NAME_SPACE+"delete", no);
	}
	
	// 게시판 글보기 할때 1 증가하는 메서드
	public void increase(int no) {
		System.out.println(getClass().getSimpleName()+".increase()");
		// sql 문장은 /src/main/resources/mappers/boardMapper.xml에 정의해 놓는다.
		session.update(NAME_SPACE+"increase", no);
	}
	
	public int page(PageObject pageObject) {
		// pageObject
		return session.selectOne(NAME_SPACE+"page", pageObject);
		// pageObject
	}
}
