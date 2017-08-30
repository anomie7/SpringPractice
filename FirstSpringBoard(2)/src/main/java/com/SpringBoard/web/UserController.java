package com.SpringBoard.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.SpringBoard.domain.UserVO;
import com.SpringBoard.exceptions.IdNotMatchException;
import com.SpringBoard.exceptions.PasswordNotMatchException;
import com.SpringBoard.user.dao.UserDAO;

@Controller
@SessionAttributes("id")
public class UserController {
	@Autowired
	UserDAO userDAO;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/join.do")
	public String join(@ModelAttribute("user") UserVO user) {
		return "join.jsp";
	}
	
	@RequestMapping("/joinProcess.do")
	public String join(@ModelAttribute("user") @Valid UserVO user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			logger.info("Binding Result has error!");
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				logger.debug("error: {}", error.getDefaultMessage());
			}
			return "join.jsp";
		}
		userDAO.joinUser(user);
		return "home.do";
	}
	
	@RequestMapping("/login.do")
	public String login(@ModelAttribute("user") UserVO user, Model model, HttpServletResponse response) throws IOException {
		try {
			userDAO.login(user);
			model.addAttribute("id", user.getId());
		} catch (IdNotMatchException e) {
			logger.info(e.getMessage() + "");
			model.addAttribute("msg", e.getMessage());
			return "login_error.jsp";
		}catch(PasswordNotMatchException e){
			logger.info(e.getMessage());
			model.addAttribute("msg", e.getMessage());
			return "login_error.jsp";
		}catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "home.do";
	}
	
	@RequestMapping("/logout.do")
	public String logout(SessionStatus session) {
		session.setComplete();
		return "home.do";
	}
	
	@RequestMapping("/update.do")
	public String update(@ModelAttribute("user") @Valid UserVO user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			logger.info("Binding Result has error!");
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				logger.debug("error: {}", error.getDefaultMessage());
			}
			return "join.jsp";
		}
		userDAO.updateUser(user);
		return "home.do";
	}
}
