package com.sin1.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String goMain() {
		return "redirect:/main/main.do";
	} // end of main()
	
	@RequestMapping(path="/main/main.do", method=RequestMethod.GET)
	public String JoinForm() {
		return "main/main";
	}

}
