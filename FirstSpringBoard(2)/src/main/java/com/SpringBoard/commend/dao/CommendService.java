package com.SpringBoard.commend.dao;

import java.util.List;

import com.SpringBoard.domain.CommendVO;

public interface CommendService {

	List<CommendVO> getCommendList(int id);

	Integer getMaxCommendNum(Integer boardId);

	void createCommend(CommendVO commend);

	void updateCommend(CommendVO vo);

	void deleteCommend(int cno);

}