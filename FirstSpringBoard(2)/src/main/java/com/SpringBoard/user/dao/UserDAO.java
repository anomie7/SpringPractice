package com.SpringBoard.user.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoard.domain.UserVO;
import com.SpringBoard.exceptions.IdNotMatchException;
import com.SpringBoard.exceptions.PasswordNotMatchException;
import com.SpringBoard.mappers.UserMapper;

public class UserDAO {
	@Autowired
	UserMapper userMapper;

	public void joinUser(UserVO vo) {
		userMapper.insertUser(vo);
	}
	
	public UserVO getUserById(String id) {
		return userMapper.selectUser(id);
	}

	public void login(UserVO vo) throws Exception {
		UserVO dbUser = userMapper.selectUser(vo.getId());

		if (dbUser != null) {
			if (dbUser.equals(vo)) {

			} else {
				throw new PasswordNotMatchException();
			}
		}else {
			throw new IdNotMatchException();
		}
	}

	public void updateUser(UserVO up) {
		userMapper.updateUser(up);
	}
	
	
	
	
}
