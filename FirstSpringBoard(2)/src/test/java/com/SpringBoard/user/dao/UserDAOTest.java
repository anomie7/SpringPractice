package com.SpringBoard.user.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.SpringBoard.domain.UserVO;
import com.SpringBoard.exceptions.IdNotMatchException;
import com.SpringBoard.exceptions.PasswordNotMatchException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/root-context.xml")
public class UserDAOTest {
	@Autowired
	UserDAO userDAO;
	UserVO vo;
	private static final Logger logger = LoggerFactory.getLogger(UserDAOTest.class);

	@Before
	public void setup() {
		vo = new UserVO();
		vo.setId("doit122");
		vo.setPassword("1234");
		vo.setEmail("doit123@gmail.com");
		vo.setTel("010-3333-3333");
	}
	
	@Test
	public void joinUser() {
		userDAO.joinUser(vo);
	}
	
	@Test
	public void loginTest() {
		try {
			userDAO.login(vo);
		} catch (IdNotMatchException e) {
			logger.info(e.getMessage());
		}catch(PasswordNotMatchException e) {
			logger.info(e.getMessage());
		}catch(Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	@Test
	public void updateTest() {
		UserVO up = new UserVO();
		up.setId(vo.getId());
		up.setEmail("dotidoti@gmail.com");
//		up.setTel("011-3333-1111");
		up.setPassword("1111");
		userDAO.updateUser(up);
		logger.debug("user: {}" ,userDAO.getUserById(up.getId()).toString());
	}
}
