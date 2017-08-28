package com.SpringBoard.mappers;

import com.SpringBoard.domain.UserVO;

public interface UserMapper {
	void insertUser(UserVO vo);
	void updateUser(UserVO vo);
	UserVO selectUser(String id);
}
