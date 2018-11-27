package com.sin1.member.Controller;

import java.lang.reflect.Member;

import javax.jws.WebParam.Mode;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.spi.MidiDeviceProvider;

import org.aspectj.ajdt.internal.compiler.lookup.HelperInterfaceBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sin1.member.Service.MemberService;
import com.sin1.member.dto.LoginDTO;
import com.sin1.member.dto.MemberDTO;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSenderImpl mailSender; // bean에 있는 네임을 사용한다.
	
	@RequestMapping(path="/member/join.do", method=RequestMethod.GET)
	public String joinForm() {
		return "member/join";
	}
	
	@RequestMapping(path="/member/join.do", method=RequestMethod.POST)
	public String join(MemberDTO dto) {
		service.join(dto);
		return "redirect:login.do";
	}
	
	
	@RequestMapping(path="/member/login.do", method=RequestMethod.GET)
	public String loginForm() {
		return "member/login";
	}
	
	@RequestMapping(path="/member/login.do", method=RequestMethod.POST)
	public String login(HttpSession session,String id, String pw) {
		String raw = service.findId(id);
		System.out.println(raw);
		System.out.println(pw);
		LoginDTO dto = service.login(id, raw);
		if(dto != null) {
			
			if(passwordEncoder.matches(pw, raw)) {
			//memberservice.loginDate(member_id);
				System.out.println(dto);
			session.setAttribute("login", dto);
			return "redirect:/main/main.do";
			}else {
				return "error/login";
			}
		}else {
			return "error/login";
		}
	}

	@RequestMapping(path="/member/mypage.do", method=RequestMethod.GET)
	public String mypage() {
		return "member/mypage";
	}
	
	@RequestMapping(path="/member/chagePw.do", method=RequestMethod.GET)
	public String chagePwForm(Model model,String id, HttpSession session) {
		id = ((LoginDTO)session.getAttribute("login")).getId();
		return "member/chagePw";
	}
	
	@RequestMapping(path="/member/chagePw.do", method=RequestMethod.POST)
	public String chagePw(String id, String pw, String newPw, HttpSession session) {
		System.out.println(id+pw+newPw);
		service.chagePw(id, pw, newPw);
		session.invalidate();
		return "redirect:/member/login.do";
	}
	
	@RequestMapping(path="/member/view.do", method=RequestMethod.GET)
	public String view(Model model, String id, HttpSession session) {
		id = ((LoginDTO)session.getAttribute("login")).getId();
		model.addAttribute("view", service.view(id));
		return "member/view";
	}
	
	@RequestMapping(path="/member/update.do", method=RequestMethod.GET)
	public String updateForm(Model model, String id) {
		model.addAttribute("update", service.view(id));
		return "member/update";
	}
	
	@RequestMapping(path="/member/update.do", method=RequestMethod.POST)
	public String update(MemberDTO dto, String id, HttpSession session) {
		id = ((LoginDTO)session.getAttribute("login")).getId();
		service.update(dto);
		return "redirect:/member/view.do?id="+id;
	}
	
	@RequestMapping(path="/member/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main/main.do";
	}
	
	@RequestMapping(path="/member/searchId.do", method=RequestMethod.GET)
	public String searchIdForm() {
		return "member/searchId";
	}
	
	@RequestMapping(path="/member/searchId.do", method= RequestMethod.POST)
	public String searchId(Model model, String email, String name, String tel, String gender) {
		System.out.println(email+ name+ tel+ gender);
		model.addAttribute("dto",service.searchId(email, name, tel, gender));
		return "member/findId";
	}

	@RequestMapping(path="/member/middleSerchPw.do", method=RequestMethod.GET)
	public String middleSerchPwForm() {
		return "member/middleSerchPw";
	}
	
	@RequestMapping(path="/member/middleSerchPw.do", method=RequestMethod.POST)
	public String middleSerchPw(String id, String tel, String email) {
		System.out.println(id+tel+email);
		service.middleSerchPw(id, tel, email);
		// 비밀번호를 찾을 때 정보를 전달을 해줘야 model에서 사용이 가능하다.
		return "redirect:finalSearchPw.do?id="+id+"&tel="+tel+"&email="+email;
//		?id="+id+"&tel="+tel+"&email="+email
	}

	@RequestMapping(path="/member/finalSearchPw.do", method=RequestMethod.GET)
	public String finalSearchPwForm(Model model, String id, String tel, String email) {
		model.addAttribute("dto", service.middleSerchPw(id, tel, email));
		return "member/finalSearchPw";
	}
	
	@RequestMapping(path="/member/mail.do", method=RequestMethod.GET)
	public String mail(Model model, MemberDTO dto, String tomail, String title, String content) {
		//model.addAttribute("mail",service.middleSearchPw(dto));
		String setform = "sksksms2@gmail.com";
		// 보내는 사람 이메일
//		String tomail = request.getParameter("tomail");
//		 받는사람 이메일
//		String title = request.getParameter("title");
		// 받은 제목
//		String content = request.getParameter("content");
		// 내용
		try {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper hepler = new MimeMessageHelper(message, true, "UTF-8");
		hepler.setFrom(setform);
		// 보내는 사람을 생략하거나 안쓰면 정상적인 작동을 하지않는다.
		hepler.setTo(dto.getEmail());
		// 받는 사람의 이메일을 적어준다
		hepler.setSubject("아이디로 가는 곳");
		// 메일의 제목은 생략이 가능하지만 나는 한번에보내줄꺼다
		hepler.setText("localhost/member/finalPw.do");
//		 메일 내용
		
		mailSender.send(message);
		}catch(Exception e){
					System.out.println(e);
				}
		return "redirect:/member/login.do";
	}
	 
	
	
	
	
	@RequestMapping(path="/member/finalSearchPw.do", method=RequestMethod.POST)
	public String finalSearchPw(String id, String tel , String email, String pw) {
		service.finalSearchPw(pw, id, tel, email);
		return "redirect:/member/login.do";
	}
}
