package com.SpringBoard.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoard.commend.dao.CommendDAO;
import com.SpringBoard.domain.CommendVO;

@RestController
public class CommendComtroller {
	@Autowired
	CommendDAO commendDAO;
	private static final Logger logger = LoggerFactory.getLogger(CommendComtroller.class);
	
	@RequestMapping(value = "/commendWrite.do")
	public String commendWrite(CommendVO commend) {
		logger.debug(commend.toString());
		Integer maxNum = commendDAO.getMaxCommendNum(commend.getBoardId() );
		
		if(maxNum == null) {
			commend.setCommendNum(1);
		}else {
			commend.setCommendNum(++maxNum);
		}
		logger.debug("생성되기 전 댓글의 값: {}", commend.toString());
		
		commendDAO.createCommend(commend);
		return "success!";
	}
	
	@RequestMapping("/commendDelete.do")
	public String commendDelete(CommendVO commend){
		logger.debug("삭제될 commend 객체의 cno : {}", commend.getCno());
		commendDAO.deleteCommend(commend.getCno());
		return "success!";
	}
	
	@RequestMapping(value = "/commendUpdate.do")
	public String commendUpdate(CommendVO commend) {
		logger.debug("수정될 commend 객체 : {}", commend.toString());
		commendDAO.updateCommend(commend);
		return "success!";
	}
}
