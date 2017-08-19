package com.springbook.view.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	@RequestMapping("/login.do")
	public String handleRequest(UserVO vo, UserDAO userDAO) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		userDAO = (UserDAO) container.getBean("userDAO");
		
		if(userDAO.getUser(vo) != null) return "getBoardList.do";
		return "login.jsp";
	}
}
