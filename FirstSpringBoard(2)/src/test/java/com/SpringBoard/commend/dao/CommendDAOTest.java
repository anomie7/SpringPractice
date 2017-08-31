package com.SpringBoard.commend.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.SpringBoard.domain.CommendVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/root-context.xml")
public class CommendDAOTest {
	@Autowired
	CommendDAO commendDAO;
	private static final Logger logger = LoggerFactory.getLogger(CommendDAOTest.class);

	@Test
	public void getListTest() {
		List<CommendVO> list = commendDAO.getCommendList(0);
		for (CommendVO vo : list) {
			logger.debug(vo.toString());
		}
	}
	
	@Test
	public void createCommendTest() throws Exception {
		CommendVO commend = new CommendVO();
		commend.setBoardId(2);
		Integer maxNum = commendDAO.getMaxCommendNum(commend.getBoardId() );
		logger.debug("maxNum : {}", maxNum);
		
		if(maxNum == null) {
			commend.setCommendNum(1);
		}else {
			commend.setCommendNum(++maxNum);
		}
		
		commend.setContent("댓글이다 댓글이야");
		commend.setName("testCommend");
		
		logger.debug("생성되기 전 댓글의 값: {}", commend.toString());
		
		commendDAO.createCommend(commend);
	}

}
