package com.sin1.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sin1.board.dto.BoardDTO;
import com.sin1.board.dto.ReplyBoardDTO;
import com.sin1.board.service.BoardService;
import com.sin1.board.service.ReplyBoardService;
import com.sin1.util.PageObject;
import com.sin1.util.ReplyPageObject;

@Controller
@RequestMapping(value="/board/")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ReplyBoardService replyBoardService;
	
	// 글 리스트 + 페이징
	@RequestMapping(path="list.do", method=RequestMethod.GET)
	public String list(Model model, PageObject pageObject) {
		// pageObject
		model.addAttribute("list", boardService.list(pageObject));
		// model.addAtttribute("page",pageObject);
		model.addAttribute("page", pageObject);
		return "board/list";
	}
	
	// 글보기 + 댓글 리스트 + 페이징
	@RequestMapping(path="view.do", method=RequestMethod.GET)
	public String view(Model model, int no, @RequestParam(value="isView", defaultValue="false")boolean isView, ReplyPageObject pageObject) {
		// pageObject
		model.addAttribute("view", boardService.view(no,isView));
		// 댓글에 필요한 페이징 처리
		model.addAttribute("ReplyList", replyBoardService.list(pageObject));
		// pageObject
		model.addAttribute("page", pageObject);
		return "board/view";
	}
	
	// 게시판 글쓰기 폼
	@RequestMapping(path="write.do", method=RequestMethod.GET)
	public String writeForm() {
		return "board/write";
	}
	
	// 게시판 글 쓰기
	@RequestMapping(path="write.do", method=RequestMethod.POST)
	public String write(BoardDTO dto) {
		boardService.write(dto); 
		return "redirect:/board/list.do";
	}
	
	// 게시판 글 수정 폼 + 게시판내용 보기
	@RequestMapping(path="update.do", method=RequestMethod.GET)
	public String updateForm(int no, Model model) {
		model.addAttribute("update", boardService.view(no, false));
		return "board/update";
	}
	
	// 게시판 글수정
	@RequestMapping(path="update.do", method=RequestMethod.POST)
	public String update(BoardDTO dto) {
		boardService.update(dto);
		return "redirect:/board/view.do?no="+dto.getNo()+"&isView=false";
	}
	
	// 글 삭제
	@RequestMapping(path="delete.do", method=RequestMethod.GET)
	public String delete(int no) {
		boardService.delete(no);
		// 댓글까지 같이 삭제하려면 delete에 같이 삭제를 하게 하면 된다. replyBoardService.delete(no);
		replyBoardService.ReplyDelete(no);
		return "redirect:/board/list.do";
	}
	
	
//	// 댓글 달기
//	@RequestMapping(path="questWrite.do", method=RequestMethod.POST)
//	public String qusetWrite(ReplyBoardDTO dto) {
//		replyBoardService.questWrite(dto);
//		return "redirect:/board/view.do?no="+dto.getNo()+"&isView=false";
//	}
//	
//	// 대댓글 달기
//	@RequestMapping(path="answerWrite.do", method=RequestMethod.POST)
//	public String answerWrite(ReplyBoardDTO dto) {
//		replyBoardService.answerWrite(dto);
//		return "redirect:/board/view.do?no="+dto.getNo()+"&isView=false";
//	}
//	
	// 댓글 쓰기
	@RequestMapping(path="ReplyWrite.do", method=RequestMethod.POST)
	public String ReplyWrite(ReplyBoardDTO dto) {
		replyBoardService.ReplyWrite(dto);
		return "redirect:/board/view.do?no="+dto.getNo()+"&isView=false";
	}
//	 댓글 수정
	@RequestMapping(path="ReplyUpdate.do", method=RequestMethod.GET)
	public String ReplyUpdateForm(Model model, int rno) {
		model.addAttribute("ReplyUpdate", replyBoardService.view(rno));
		return "board/ReplyUpdate";
	}
	
	// 댓글 수정
	@RequestMapping(path="ReplyUpdate.do", method=RequestMethod.POST)
	public String ReplyUpdate(ReplyBoardDTO dto) {
		replyBoardService.ReplyUpdate(dto);
		return "redirect:/board/view.do?no="+dto.getNo()+"&isView=false";
	}
	
	// 댓글 삭제
	@RequestMapping(path="ReplyDelete.do", method=RequestMethod.GET)
	public String ReplyDelete(int rno, int no) {// int rno,
		replyBoardService.ReplyDelete(rno);
		return "redirect:/board/view.do?no="+no;
	}
}
