package com.sin1.error.Controller;

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
public class errorController {
	
	@RequestMapping(path="/error/error_login.do", method=RequestMethod.GET)
	public String error() {
		return "member/error";
	}
}
