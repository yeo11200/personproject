package com.sin1.notice.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sin1.notice.dto.NoticeDTO;
import com.sin1.util.PageObject;

@Repository
public class NoticeDAO {
	
	@Inject
	private SqlSession session;
	
	private final String NAME_SPACE = "com.sin1.mapper.NoticeMapper.";
	
	public List<NoticeDTO> list(PageObject pageObject){
		return session.selectList(NAME_SPACE+"list", pageObject);
	}
	
	public NoticeDTO view(int no) {
		return session.selectOne(NAME_SPACE+"view", no);
	}
	
	public void write(NoticeDTO dto) {
		session.insert(NAME_SPACE+"write", dto);
	}
	
	public void update(NoticeDTO dto) {
		session.update(NAME_SPACE+"update", dto);
	}
	
	public void delete(int no) {
		session.delete(NAME_SPACE+"delete", no);
	}
	
	public int page(PageObject pageObject) {
		return session.selectOne(NAME_SPACE+"page", pageObject);
	}
}
