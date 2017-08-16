package com.springbook.biz.user.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

public class UserServiceImplTest {
	@Autowired
	UserService userService;
	UserVO vo;
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);

	@Before
	public void setup() {
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		userService = (UserService) container.getBean("userService");
		
		vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test123");
		
//		container.close();
	}
	
	@Test
	public void loginTest() {
		UserVO user = userService.getUser(vo);
		if(user != null) {
			logger.info(user.getName() + "님 환영합니다.");
		}else {
			logger.info("로그인 실패");
		}
	}
}
