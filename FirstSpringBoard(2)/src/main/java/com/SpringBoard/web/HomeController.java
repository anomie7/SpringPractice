package com.SpringBoard.web;

import org.springframework.beans.factory.annotation.Autowired;
//github.com/anomie7/SpringPractice.git
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//github.com/anomie7/SpringPractice.git
import org.springframework.web.bind.annotation.SessionAttributes;

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

}
