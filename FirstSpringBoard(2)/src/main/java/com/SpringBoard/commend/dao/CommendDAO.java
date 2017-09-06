package com.SpringBoard.commend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoard.domain.CommendVO;
import com.SpringBoard.mappers.CommendMapper;

public class CommendDAO{
	@Autowired
	private CommendMapper commendMapper;
	
	public List<CommendVO> getCommendList(int id){
		return commendMapper.getCommendList(id);
	}

	public Integer getMaxCommendNum(Integer boardId) {
		return commendMapper.getMaxCommendNum(boardId);
	}

	public void createCommend(CommendVO commend) {
		commendMapper.insertCommend(commend);
	}

	public void updateCommend(CommendVO vo) {
		commendMapper.updateCommend(vo);
	}

	public void deleteCommend(int cno) {
		commendMapper.deleteCommend(cno);
	}
}
