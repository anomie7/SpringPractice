package com.SpringBoard.user.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoard.domain.UserVO;
import com.SpringBoard.mappers.UserMapper;


public class UserDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public void joinUser(UserVO vo) {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.insertUser(vo);
	}

}
