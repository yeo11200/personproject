package com.sin1.qna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sin1.qna.dto.QnaDTO;
import com.sin1.qna.service.QnaService;
import com.sin1.util.PageObject;

@Controller
@RequestMapping(value="/qna/")
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value="list.do", method=RequestMethod.GET)
	public String list(PageObject pageObject, Model model) {
		model.addAttribute("list", qnaService.list(pageObject));
		model.addAttribute("page", pageObject);
		return "qna/list";
	}
	
	@RequestMapping(value="view.do", method=RequestMethod.GET)
	public String view(int no, Model model, @RequestParam(value="isView", defaultValue="false")boolean isView) {
		model.addAttribute("view", qnaService.view(no, isView));
		return "qna/view";
	}
	
	@RequestMapping(value="questWrite.do", method=RequestMethod.GET)
	public String questWriteForm() {
		return "qna/questWrite";
	}
	
	@RequestMapping(value="questWrite.do", method=RequestMethod.POST)
	public String questWrite(QnaDTO dto) {
		System.out.println(dto);
		qnaService.questWrite(dto);
		return "redirect:/qna/list.do";
	}
	
	@RequestMapping(value="answerWrite.do", method=RequestMethod.GET)
	public String answerWriteForm(Model model, int no) {
		model.addAttribute("quest", qnaService.view(no, false));
		return "qna/answerWrite";
	}
	
	@RequestMapping(value="answerWrite.do", method=RequestMethod.POST)
	public String answerWrite(QnaDTO dto) {
		qnaService.answerWrite(dto);
		return "redirect:/qna/list.do";
	}
	
	@RequestMapping(value="questUpdate.do", method=RequestMethod.GET)
	public String questUpdateForm(Model model, int no) {
		model.addAttribute("quest", qnaService.view(no, false));
		return "qna/questUpdate";
	}
	
	@RequestMapping(value="questUpdate.do", method=RequestMethod.POST)
	public String questUpdate(QnaDTO dto) {
		System.out.println(dto);
		qnaService.questUpdate(dto);
		return "redirect:/qna/view.do?no="+dto.getNo()+"&isView=false";
	}
	
	@RequestMapping(value="delete.do", method=RequestMethod.GET)
	public String delete(int no) {
		qnaService.delete(no);
		return "redirect:/qna/list.do";
	}
}
