package com.sin1.member.Controller;

import java.lang.reflect.Member;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sin1.member.Service.MemberService;
import com.sin1.member.Service.NoticeMemberService;
import com.sin1.member.dto.LoginDTO;
import com.sin1.member.dto.MemberDTO;

@Controller
@RequestMapping(value="/noticeMember/")
public class NoticeMemberController {
	
	@Autowired
	private NoticeMemberService service;
	
	@RequestMapping(path="noticePage.do", method=RequestMethod.GET)
	public void noticepage() {
		System.out.println(getClass().getSimpleName()+"들어옴?");
//		return "noticeMember/noicePage";
	}
	
	@RequestMapping(path="list.do", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("list",service.list());
		
		return "noticeMember/list";
	}
	
	@RequestMapping(path="view.do", method=RequestMethod.GET)
	public String view(String id, HttpSession session, Model model) {
		model.addAttribute("view",service.view(id));
		return "noticeMember/view";
		
	}
	
	@RequestMapping(path="deletelist.do", method=RequestMethod.GET)
	public String deletelist(Model model) {//pageObject
		model.addAttribute("list", service.deletelist());
		return "noticeMember/deletelist";
	}
	
	public String deleteView(Model model, String id) {
		model.addAttribute("view", service.view(id));
		return "noticeMember/view";
	}
 	@RequestMapping(path="updateGrade.do", method=RequestMethod.GET)
	public String updateGrade(String id, HttpSession session) {
		System.out.println(getClass().getSimpleName()+"너는 들어오니?");
		System.out.println(id);
//		id = ((LoginDTO)session.getAttribute("login")).getId();
		service.updateGrade(id);
		// redirect를 안써서 자꾸 에러가 발생하여 오류가 발생했다.
		return "redirect:/noticeMember/view.do?id="+id;
	}
	
 	@RequestMapping(path="updateDeleteMember.do", method=RequestMethod.GET)
 	public String updateDeleteMember(String id) {
 		service.updateDeleteMember(id);
 		return "redirect:/noticeMember/list.do";
 	}
 	
	@RequestMapping(path="deleteMember.do", method=RequestMethod.GET)
	public String deleteMember(String id, HttpSession session) {
		//id = ((LoginDTO)session.getAttribute("login")).getId();
		service.deleteMember(id);
		return "redirect:/noticeMember/view.do?id="+id;
	}
}
