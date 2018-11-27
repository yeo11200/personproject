package com.sin1.chkId.Controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sin1.member.Service.MemberService;
import com.sin1.member.dto.MemberDTO;

@Controller
public class chkIdController {
	@Autowired
	private MemberService service;
	
	@RequestMapping(path="/chkId/checkId.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String CheckId(String id) {
		if(service.chkId(id)== null) {
			return "사용이 가능합니다.";
		}
		return "중복됩니다.";
	}
	
	@RequestMapping(path="/chkId/checkLogin.do", produces = "application/json; charset=utf8")
	@ResponseBody
	public String CheckLogin(String id, String pw) {
		if(service.login(id, pw) == null) {
			return "아이디 혹은 비밀번호가 잘못되었습니다.";
		}
		return "/member/login.do";
	}
}
