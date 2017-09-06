package com.SpringBoard.commend.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoard.domain.CommendVO;

public class CommendServiceImpl implements CommendService {
	@Autowired
	CommendDAO commendDAO;
	private static final Logger logger = LoggerFactory.getLogger(CommendServiceImpl.class);

	@Override
	public List<CommendVO> getCommendList(int id) {
		return commendDAO.getCommendList(id);
	}

	@Override
	public Integer getMaxCommendNum(Integer boardId) {
		return commendDAO.getMaxCommendNum(boardId);
	}

	@Override
	public void createCommend(CommendVO commend) {
		logger.debug(commend.toString());
		Integer maxNum = getMaxCommendNum(commend.getBoardId());

		if (maxNum == null) {
			commend.setCommendNum(1);
		} else {
			commend.setCommendNum(++maxNum);
		}
		logger.debug("생성되기 전 댓글의 값: {}", commend.toString());
		commendDAO.createCommend(commend);
	}

	@Override
	public void updateCommend(CommendVO commend) {
		logger.debug("수정될 commend 객체 : {}", commend.toString());
		commendDAO.updateCommend(commend);
	}

	@Override
	public void deleteCommend(int cno) {
		logger.debug("삭제될 commend 객체의 cno : {}", cno);
		commendDAO.deleteCommend(cno);
	}

}
