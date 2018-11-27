package com.sin1.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sin1.board.dao.BoardDAO;
import com.sin1.board.dto.BoardDTO;
import com.sin1.util.PageObject;

@Service
public class BoardService {
	@Inject
	private BoardDAO dao;
	
	public List<BoardDTO> list(PageObject pageObject){
		// pageObject
		
		// page처리를 위해서 전체 글의 갯수등을 계산해서 넣어야한다.
		// 검색을 위해서 전체 글의 갯수를 찾을 때 검색한 단어가 포함되어 있는 pageObject를 넘긴다.
		pageObject.setTotalRow(dao.page(pageObject));
		return dao.list(pageObject);
		//pageObject
	}
	
	public BoardDTO view(int no, boolean isView) {
		if(isView) dao.increase(no);
		return dao.view(no);
	}
	
	public void write(BoardDTO dto) {
		dao.write(dto);
	}
	
	public void update(BoardDTO dto) {
		dao.update(dto);
	}
	
	public void delete(int no) {
		dao.delete(no);
	}
}
