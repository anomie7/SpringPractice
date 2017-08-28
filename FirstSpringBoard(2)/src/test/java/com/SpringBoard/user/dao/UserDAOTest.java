package com.SpringBoard.user.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.SpringBoard.domain.UserVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/root-context.xml")
public class UserDAOTest {
	@Autowired
	UserDAO userDAO;
	UserVO vo;
	@Before
	public void setup() {
		vo = new UserVO();
		vo.setId("doit123");
		vo.setPassword("1234");
		vo.setEmail("doit123@gmail.com");
		vo.setTel("010-3333-3333");
	}
	
	@Test
	public void joinUser() {
		userDAO.joinUser(vo);
	}

}
