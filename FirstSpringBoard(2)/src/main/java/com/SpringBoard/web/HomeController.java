package com.SpringBoard.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.SpringBoard.domain.UserVO;

@Controller
@SessionAttributes("id")
public class HomeController {
	
	@RequestMapping("/home.do")
	public String gohome() {
		return "home.jsp";
	}
	
	@RequestMapping("/testForm.do")
	public String formTest(@ModelAttribute("user") @Valid UserVO user, 
			BindingResult bindingResult, Model model) {
		model.addAttribute("id", user.getId());
		if(bindingResult.hasErrors()) {
			return "testSpringform.jsp";
		}
		return null;
	}
	
	
}
