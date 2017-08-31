package com.SpringBoard.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringBoard.commend.dao.CommendDAO;
import com.SpringBoard.domain.CommendVO;

@Controller
public class CommendComtroller {
	@Autowired
	CommendDAO commendDAO;
	private static final Logger logger = LoggerFactory.getLogger(CommendComtroller.class);
	
	@RequestMapping(value = "/commendWrite.do", produces="application/json;charset=UTF-8")
	public @ResponseBody String commendWrite(CommendVO commend) {
		logger.debug(commend.toString());
		Integer maxNum = commendDAO.getMaxCommendNum(commend.getBoardId() );
		
		if(maxNum == null) {
			commend.setCommendNum(1);
		}else {
			commend.setCommendNum(++maxNum);
		}
		logger.debug("생성되기 전 댓글의 값: {}", commend.toString());
		
		commendDAO.createCommend(commend);
		return "asdfsadf";
	}
}
