package com.sin1.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sin1.notice.dao.NoticeDAO;
import com.sin1.notice.dto.NoticeDTO;
import com.sin1.util.PageObject;

@Service
public class NoticeService {
	@Inject
	private NoticeDAO dao;
	
	public List<NoticeDTO> list(PageObject pageObject){
		pageObject.setTotalRow(dao.page(pageObject));
		return dao.list(pageObject);
	}
	
	public NoticeDTO view(int no) {
		return dao.view(no);
	}
	
	public void write(NoticeDTO dto) {
		dao.write(dto);
	}
	
	public void update(NoticeDTO dto) {
		dao.update(dto);
	}
	
	public void delete(int no) {
		dao.delete(no);
	}
}
