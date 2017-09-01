package com.SpringBoard.mappers;

import java.util.List;

import com.SpringBoard.domain.CommendVO;

public interface CommendMapper {
	List<CommendVO> getCommendList(int id);

	Integer getMaxCommendNum(Integer boardId);

	void insertCommend(CommendVO commend);

	void updateCommend(CommendVO vo);

	void deleteCommend(int cno);
}
