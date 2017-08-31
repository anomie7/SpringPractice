package com.SpringBoard.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.SpringBoard.domain.UserVO;
import com.SpringBoard.user.dao.UserService;

@Controller
@SessionAttributes("id")
public class HomeController {
	@Autowired
	UserService userDAO;
	
	@RequestMapping("/home.do")
	public String gohome() {
		return "home.jsp";
	}
	
	@RequestMapping("/testForm.do")
	public String formTest(@ModelAttribute("user") @Valid UserVO user, 
			BindingResult bindingResult, Model model) {
		model.addAttribute("user", new UserVO());
		if(bindingResult.hasErrors()) {
			return "testSpringform.jsp";
		}
		return null;
	}
	
	@RequestMapping(value = "/testA.do", method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	public @ResponseBody UserVO testAjax(@RequestParam("id") String id) {
		UserVO user = userDAO.getUserById(id);
		System.out.println(user.toString());
		return user;
	}
	
	
}
