package com.SpringBoard.user.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoard.domain.UserVO;

public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDAO;
	
	@Override
	public void joinUser(UserVO vo) {
		userDAO.joinUser(vo);
	}

	@Override
	public UserVO getUserById(String id) {
		return userDAO.getUserById(id);
	}

	@Override
	public void login(UserVO vo) throws Exception {
		userDAO.login(vo);
	}

	@Override
	public void updateUser(UserVO up) {
		userDAO.updateUser(up);
	}
	
}
