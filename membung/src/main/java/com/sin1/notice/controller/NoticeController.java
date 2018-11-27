package com.sin1.notice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sin1.notice.dto.NoticeDTO;
import com.sin1.notice.service.NoticeService;
import com.sin1.util.PageObject;

@Controller
@RequestMapping(value="/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping(value="list.do", method=RequestMethod.GET)
	public String list(Model model, PageObject pageObject){
		// 공지사항 리스트를 화면에 보여주기 위해서 사용을 한다.
		model.addAttribute("list", service.list(pageObject));
		// 공지사항에 대한 페이징 처리
		model.addAttribute("page", pageObject);
		return "notice/list";
	}
	
	@RequestMapping(value="view.do", method=RequestMethod.GET)
	public String view(Model model, int no) {
		model.addAttribute("view", service.view(no));
		return "notice/view";
	}
	
	@RequestMapping(value="write.do", method=RequestMethod.GET)
	public String writeForm() {
		return "notice/write";
	}
	
	@RequestMapping(value="write.do", method=RequestMethod.POST)
	public String wirte(NoticeDTO dto) {
		service.write(dto);
		return "redirect:/notice/list.do";
	}
	
	@RequestMapping(value="update.do", method=RequestMethod.GET)
	public String updateForm(Model model, int no) {
		model.addAttribute("update", service.view(no));
		return "notice/update";
	}
	
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public String update(NoticeDTO dto) {
		service.update(dto);
		return "redirect:/notice/view.do?no="+dto.getNo()+"&isView=false";
	}
	
	@RequestMapping(value="delete.do", method=RequestMethod.GET)
	public String delete(int no) {
		service.delete(no);
		return "redirect:/notice/list.do";
		
		
		
		
	}
}
