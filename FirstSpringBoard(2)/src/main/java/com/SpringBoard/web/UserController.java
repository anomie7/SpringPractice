package com.SpringBoard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringBoard.domain.UserVO;
import com.SpringBoard.user.dao.UserDAO;

@Controller
public class UserController {
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/join.do")
	public String join(UserVO vo) {
		userDAO.joinUser(vo);
		return "home.html";
	}
}
