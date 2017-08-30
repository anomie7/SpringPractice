package com.SpringBoard.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringBoard.domain.UserVO;

@Controller
public class HomeController {
	
	@RequestMapping("/home.do")
	public String gohome() {
		return "home.jsp";
	}
	
	@RequestMapping("/testForm.do")
	public String formTest(UserVO user, Model model) {
		model.addAttribute("user", user);
		return "testSpringform.jsp";
	}
	
	
}
