package com.SpringBoard.web;

import java.io.IOException;
import java.util.List;

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
import com.SpringBoard.exceptions.LoginException;
import com.SpringBoard.user.dao.UserService;

@Controller
@SessionAttributes("id")
public class UserController {
	@Autowired
	UserService userService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/join.do")
	public String join(@ModelAttribute("user") UserVO user) {
		return "user/join";
	}

	@RequestMapping("/joinProcess.do")
	public String join(@ModelAttribute("user") @Valid UserVO user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			logger.info("Binding Result has error!");
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				logger.debug("error: {}", error.getDefaultMessage());
			}
			return "user/join";
		}
		userService.joinUser(user);
		return "redirect:home.do";
	}

	@RequestMapping("login.do")
	public String login(@ModelAttribute("user") UserVO user) {
		return "user/login";
	}

	@RequestMapping("/loginProcess.do")
	public String loginProcess(@ModelAttribute("user") @Valid UserVO user, BindingResult bindingResult, Model model)
			throws IOException {
		try {
			if (bindingResult.hasErrors()) {
				logger.info("Binding Result has error!");
				List<ObjectError> errors = bindingResult.getAllErrors();
				for (ObjectError error : errors) {
					logger.debug("error: {}", error.getDefaultMessage());
				}
				return "user/login";
			}
			userService.login(user);
			model.addAttribute("id", user.getId());
		} catch (LoginException e) {
			logger.info(e.getMessage() + "");
			model.addAttribute("msg", e.getMessage());
			return "user/login_error";
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return "redirect:home.do";
	}

	@RequestMapping("/logout.do")
	public String logout(SessionStatus session) {
		session.setComplete();
		return "redirect:home.do";
	}

	@RequestMapping("/update.do")
	public String update(@ModelAttribute("user") @Valid UserVO user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			logger.info("Binding Result has error!");
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				logger.debug("error: {}", error.getDefaultMessage());
			}
			return "user/join";
		}
		userService.updateUser(user);
		return "redirect:home.do";
	}
}
