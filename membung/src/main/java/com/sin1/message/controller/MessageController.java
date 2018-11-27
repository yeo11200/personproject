package com.sin1.message.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sin1.member.dto.LoginDTO;
import com.sin1.message.dto.MessageDTO;
import com.sin1.message.service.MessageService;
import com.sin1.util.PageObject;

@Controller
@RequestMapping(value="/message")
public class MessageController {

	// Spring의 DI(Dependency Injection:의존성주입) 적용 - service 필요
	// @Inject - java 기반, @Autowired - Spring  기반 : 둘중에 하나만 사용.
	@Autowired
	private MessageService service;
	
	// 메시지 리스트 - 페이지 처리 완료
	// 메시지 리스트를 뿌릴때 로그인한 사람의 아이디를  pageObject에 저장을 해야하는데
	// session에 로그인한 사람의 아이디 정보가 존재하므로 session에서 꺼내서 pageObject에
	// 넣는다.
	@RequestMapping(path="/list.do", method=RequestMethod.GET)
	public String list(Model model, PageObject pageObject,
			HttpSession session) {
		
		// 테스트를 위해서 강제 로그인하는 것을 만들고 session에서 아이디를 가져오는 처리해야한다.
//		String accepter = "jjang";
		
		String accepter 
		= ((LoginDTO)session.getAttribute("login")).getId();

		pageObject.setAccepter(accepter);
		
		// service의 list() 호출해서 처리된 데이터를 model에 담는다.
		model.addAttribute("list", service.list(pageObject));
		// 페이지 처리를 위래서 model 에 pageObject를 담는다. page라는 이름.
		model.addAttribute("page", pageObject);

		// /WEB-INF/views/ + message/list + .jsp
		return "message/list";
	} // end of list()
	
	// 메시지 글보기
		// 제목을 클릭해서 요청이된다. <a>, location => get 방식
		@RequestMapping(path="/view.do", method=RequestMethod.GET)
		// model객체에 데이터를 담으면 request에 자동적으로 데이터가 담긴다.
		// isView 변수는 리스테에서 부터 글보기로 넘어온 경우만 true로 작성한다. 
		public String view(Model model, HttpSession session, int no) {
			// 회원의 아이디로 온 메시지가 읽지 않은 것이면 읽었다고 표시해준다.
			// 회원의 아이디는 로그인 처리후 session에서 받아오는 것으로 한다.
			String id = ((LoginDTO)session.getAttribute("login")).getId();
			// service의 list() 호출해서 처리된 데이터를 model에 담는다.
			model.addAttribute("dto", service.view(no, id));
			return "message/view";
		}
		
		// 메시지 글쓰기 폼
		// 메시지 글리스트에서 글쓰기 버튼은 클릭해서 -> <a> -> get
		@RequestMapping(path="/write.do", method=RequestMethod.GET)
		// model객체에 데이터를 담으면 request에 자동적으로 데이터가 담긴다.
		public String writeForm() {
			return "message/write";
		}
		
		// 메시지 글쓰기 처리
		@RequestMapping(path="/write.do", method=RequestMethod.POST)
		// model객체에 데이터를 담으면 request에 자동적으로 데이터가 담긴다.
		public String write(MessageDTO dto, RedirectAttributes ra,
				HttpSession session) {
			// 보내는 사람의 id는 session에서 부터 받아온다.
			String sender 
			= ((LoginDTO)session.getAttribute("login")).getId();
			dto.setSender(sender);
			
			// Controller-> service - > dao
			// 데이터 저장
			service.write(dto);
			
			// RedirectAttributes : redirect를 할 때 데이터를 전송하고자 만들어낸 객체이다.
			// 데이트를 한번만 리스트로 전송을 하는 객체 : ra 
			ra.addFlashAttribute("msg", "WRITED");
			
			
			// 메시지 전송 처리가 끝나면 자동을 리스트로 이동한다..
			return "redirect:list.do";
		}
		
		// 메시지 삭제
		// 메시지 보기에서 삭제 버튼을 클릭 -> <a>, location -> get
		@RequestMapping(path="/delete.do", method=RequestMethod.GET)
		// model객체에 데이터를 담으면 request에 자동적으로 데이터가 담긴다.
		// RedirectAttribute : url요청을 하면서 데이터를 딱한번 사용하도록 설정하는 객체
		//  --> session사용해서 처리한다.
		public String delete(int no, RedirectAttributes ra) {
			service.delete(no);
			
			// RedirectAttributes : redirect할 때 데이터를 전송하고자 만들어낸 객체이다.
			// 데이터를 한번만 리스트로 전송을 하는 객체 : ra
			ra.addFlashAttribute("msg", "DELETED");
			
			// 메시지 삭제 처리 후 메시지 리스트로 자동 이동한다.
			return "redirect:list.do";
		}
		
	}
