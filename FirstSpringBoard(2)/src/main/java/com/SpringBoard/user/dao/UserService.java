package com.SpringBoard.user.dao;

import com.SpringBoard.domain.UserVO;

public interface UserService {

	void joinUser(UserVO vo);

	UserVO getUserById(String id);

	void login(UserVO vo) throws Exception;

	void updateUser(UserVO up);

}