package com.sin1.find.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sin1.board.dao.BoardDAO;
import com.sin1.board.dto.BoardDTO;
import com.sin1.sell.dao.SellDAO;
import com.sin1.sell.dto.SellDTO;
import com.sin1.find.dao.FindDAO;
import com.sin1.find.dto.FindDTO;
import com.sin1.util.FileUtil;
import com.sin1.util.PageObject;

@Service
public class FindService {
	@Inject
	private FindDAO dao;
	
	public List<FindDTO> list(PageObject pageObject){
		// pageObject
		//pageObject.setPerPageNum(12);
		System.out.println(getClass().getSimpleName());
		pageObject.setTotalRow(dao.page(pageObject));
		return dao.list(pageObject);
		//pageObject
	}
	
	public FindDTO view(int no, boolean isView) {
		if(isView) dao.increase(no);
		return dao.view(no);
	}
	
	public void write(FindDTO dto) {
		dao.write(dto);
	}
	
	public void update(String realPath, FindDTO dto) throws Exception {
		String fileName = dto.getFileName();
		// 원래 파일명을 가지고오서 파일 지우기를 한다.
		if(fileName != null && !fileName.equals("")) {
			FileUtil.removeFile(realPath, dao.getFileName(dto.getNo()));
			// 서버로 첨부되는 파일을 보사
			dto.setFileName(FileUtil.copyFile(realPath, dto.getMultiFile()));
		}
		dao.update(dto);
	}
	
	// 글 삭제
	// DB에서 데이터를 삭제하기 전에 파일을 삭제해야므로 실제적인 파일의 위치를 문자열로 받아야한다.
	public void delete(String realPath, int no) {
		System.out.println(dao.getFileName(no));
		FileUtil.removeFile(realPath, dao.getFileName(no));
		dao.delete(no);
	}
}
