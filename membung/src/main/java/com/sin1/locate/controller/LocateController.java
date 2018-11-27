package com.sin1.locate.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sin1.board.dto.BoardDTO;
import com.sin1.board.dto.ReplyBoardDTO;
import com.sin1.board.service.BoardService;
import com.sin1.board.service.ReplyBoardService;
import com.sin1.sell.dto.ReplySellDTO;
import com.sin1.sell.dto.SellDTO;
import com.sin1.sell.service.SellService;
import com.sin1.locate.dto.ReplyLocateDTO;
import com.sin1.locate.dto.LocateDTO;
import com.sin1.locate.service.ReplyLocateService;
import com.sin1.locate.service.LocateService;
import com.sin1.util.FileUtil;
import com.sin1.util.PageObject;
import com.sin1.util.ReplyPageObject;

// 분양하기게시판
@Controller
@RequestMapping(value = "/locate/")
public class LocateController {
	@Autowired
	private LocateService locateService;

	@Autowired
	private ReplyLocateService replyLocateService;

	// 글 리스트 + 페이징
	@RequestMapping(path = "list.do", method = RequestMethod.GET)
	public String list(Model model, PageObject pageObject) {
		// pageObject
		System.out.println(pageObject);
		System.out.println(getClass().getSimpleName());
		System.out.println(model);
		model.addAttribute("list", locateService.list(pageObject));
		// model.addAtttribute("page",pageObject);
		model.addAttribute("page", pageObject);
		return "sell/list";
	}

	// 글보기 + 댓글 리스트 + 페이징
	@RequestMapping(path = "view.do", method = RequestMethod.GET)
	public String view(Model model, int no, @RequestParam(value = "isView", defaultValue = "false") boolean isView,
			ReplyPageObject pageObject) {
		// pageObject
		model.addAttribute("view", locateService.view(no, isView));
		// 댓글에 관한 리스트 pageObject -> ReplyBoardService.
		model.addAttribute("ReplyList", replyLocateService.list(pageObject));
		// pageObject
		// model.addAtttribute("page",pageObject);
		model.addAttribute("page", pageObject);
		return "sell/view";
	}

	// 게시판 글쓰기 폼
	@RequestMapping(path = "write.do", method = RequestMethod.GET)
	public String writeForm() {
		return "sell/write";
	}

	@Resource(name = "locatePath")
	// servlet-context.xml 에있는 bean태그를 Resource로 가지고온다.
	// name은 Bean태그의 id를 가지고온다.
	private String locatePath;

	// 게시판 글 쓰기 + 파일전송을 할 수 있게 해야한다.
	// html(화면)에 form의 method를 post로 해줘야한다.
	// html(화면)에 form에 ectype을 적어줘야하고 "multipart/form-date"가 있어야한다.
	// ectype="multipart/form-date"
	@RequestMapping(path = "write.do", method = RequestMethod.POST)
	public String write(LocateDTO dto, HttpSession session, RedirectAttributes rs) throws IOException {
		// 넘어온 파일을 파일로 저장을 한다.
		System.out.println(dto.getFileName());
		System.out.println(dto);
		// 파일명이 중복이 되지않도록 세팅을 해야한다.
		// 파일을 서버로 올리는 작업이 필요하다.
		// 파일을 올리는 위치는 webapp/upload/image
		// 실질적으로 하드디스크에 위치를 찾아야한다.
//		for(MultipartFile mf : fileList) {
//		String originFileName = mf.getOriginalFilename();
//		long fileSize = mf.getSize();
//		System.out.println(originFileName);
//		System.out.println(fileSize);
		String realPath = session.getServletContext().getRealPath(locatePath);
		System.out.println(dto);
		System.out.println(realPath);
		// mf.transferTo(new File(realPath));
		// 파일 이름을 가지고 온다.
		System.out.println(dto.getFileName());
		// 파일이 있는지중복체크하여 처리하는 프로그램
		// 파일을 realPath에 저장(복사)
		dto.setFileName(FileUtil.copyFile(realPath, dto.getMultiFile()));
		// 데이터를 확인해준다.
		System.out.println("Sellcontroller.write().dto" + dto);

		// 파일을 서버로 올리는 작업이 필요하다.
		// 파일을 올리는 위츠는 /upload/image 폴더에 파일을 올린다.
		// 데이터 저장 -> 모두 dto
		locateService.write(dto);
		return "redirect:/sell/list.do";
	}

	// 게시판 글 수정 폼 + 게시판내용 보기
	@RequestMapping(path = "update.do", method = RequestMethod.GET)
	public String updateForm(int no, Model model) {
		model.addAttribute("update", locateService.view(no, false));
		return "sell/update";
	}

	// 게시판 글수정 + 파일 업로드 처리
	// html form tag 속성중에 반드시 method="post" 이어야 한다.
	// html form tag 속성으로 ectpye있어야하고 "multipart/form-date"가 있어야한다.
	@RequestMapping(path = "update.do", method = RequestMethod.POST)
	public String update(LocateDTO dto, HttpSession session, RedirectAttributes rs) throws Exception {
		// 넘어오는 데이터 확인 -> 첨부파일은 제외한다.
		System.out.println(dto);
		// 넘어오는 데이터 확인 -> 첨부파일만 확인
		System.out.println(dto.getMultiFile());

		String realPath = session.getServletContext().getRealPath(locatePath);
		locateService.update(realPath, dto);
		return "redirect:/sell/view.do?no=" + dto.getNo() + "&isView=false";
	}

	// 글 삭제
	@RequestMapping(path = "delete.do", method = RequestMethod.GET)
	public String delete(int no, HttpSession session, RedirectAttributes rs) {
		// no에 해당하는 파일도 지우기 위해서 실제적인 위치정보를 넣어줘야한다.
		System.out.println(getClass().getSimpleName() + ".delete()");
		String realPath = session.getServletContext().getRealPath(locatePath);
		locateService.delete(realPath, no);
		return "redirect:/sell/list.do";
	}

	// 댓글 달기
//	@RequestMapping(path="questWrite.do", method=RequestMethod.POST)
//	public String qusetWrite(ReplyBoardDTO dto) {
//		replyBoardService.questWrite(dto);
//		return "redirect:/board/view.do?no="+dto.getNo()+"&isView=false";
//	}

	// 대댓글 달기
//	@RequestMapping(path="answerWrite.do", method=RequestMethod.POST)
//	public String answerWrite(ReplyBoardDTO dto) {
//		replyBoardService.answerWrite(dto);
//		return "redirect:/board/view.do?no="+dto.getNo()+"&isView=false";
//	}

	// 댓글 달기
	@RequestMapping(path = "ReplyWrite.do", method = RequestMethod.POST)
	public String ReplyWrite(ReplyLocateDTO dto) {
		System.out.println(dto);
		replyLocateService.ReplyWrite(dto);
		return "redirect:view.do?no=" + dto.getNo() + "&isView=false";
		// "&isView=fasle" 오타발생으로 bad Request 에러가 발생함
	}

	// 댓글 수정
	@RequestMapping(path = "ReplyUpdate.do", method = RequestMethod.GET)
	public String ReplyUpdateForm(Model model, int rno) {
		model.addAttribute("ReplyUpdate", replyLocateService.view(rno));
		return "sell/ReplyUpdate";
	}

	// 댓글 수정
	@RequestMapping(path = "ReplyUpdate.do", method = RequestMethod.POST)
	public String ReplyUpdate(ReplyLocateDTO dto) {
		replyLocateService.ReplyUpdate(dto);
		return "redirect:/sell/view.do?no=" + dto.getNo() + "&isView=false";
	}

	// 댓글 삭제
	@RequestMapping(path = "ReplyDelete.do", method = RequestMethod.GET)
	public String ReplyDelete(int rno, int no) {
		replyLocateService.ReplyDelete(rno);
		return "redirect:/sell/view.do?no=" + no + "&isView=false";
	}
}
