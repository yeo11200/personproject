package com.sin1.sell.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sin1.board.dto.BoardDTO;
import com.sin1.sell.dto.SellDTO;
import com.sin1.util.PageObject;

@Repository
public class SellDAO {
	@Inject
	private SqlSession session;
	
	// 게시판에 대한 mapper의 경로를 지정해주는 상수
	private final String NAME_SPACE = "com.sin1.mapper.SellMapper.";
	
	// 게시판 리스트
	public List<SellDTO> list(PageObject pageObject){
		// pageObject
		System.out.println(getClass().getSimpleName());
		return session.selectList(NAME_SPACE+"list", pageObject);
		// pageObject
	}
	
	// 게시글 보기
	public SellDTO view(int no) {
		return session.selectOne(NAME_SPACE+"view", no);
	}
	
	// 게시판 글쓰기
	public void write(SellDTO dto) {
		session.insert(NAME_SPACE+"write", dto);
	}
	
	// 게시판 업데이트
	public void update(SellDTO dto) {
		session.update(NAME_SPACE+"update", dto);
	}
	
	// 게시판 삭제
	public void delete(int no) {
		System.out.println(getClass().getSimpleName()+".delete()");
		System.out.println(no);
		session.delete(NAME_SPACE+"delete", no);
	}
	
	// 이미지 게시판에 삭제나 수정할 때 파일의 내용이 변동이 되는 경우 파일의 이름을 불러와서 삭제를 해야한다.
	// 왜냐하면 삭제나 수정을 할 때 파일의 변동이 되는데 삭제가 안되고 변동이되면 에러가 발생하기 때문이다.
	public String getFileName(int no) {
		return session.selectOne(NAME_SPACE+"getFile", no);
	}
	
	// 조회수를 1 증가 시켜주는 메서드
	public void increase(int no) {
		session.update(NAME_SPACE+"increase", no);
	}
	
	// 게시판을 페이지 처리를 하기위해 전체글의 갯수를 구하는 메서드
	public int page(PageObject pageObject) {
		// pageObject
		return session.selectOne(NAME_SPACE+"page", pageObject);
		// pageObject
	}
}
