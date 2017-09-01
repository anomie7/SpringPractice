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
		commend.setBoardId(1);
		commend.setContent("테스트가 정상적으로 될까?");
		commend.setName("테스");
		Integer maxNum = commendDAO.getMaxCommendNum(commend.getBoardId() );
		logger.debug("maxNum : {}", maxNum);
		
		if(maxNum == null) {
			commend.setCommendNum(1);
		}else {
			commend.setCommendNum(++maxNum);
		}
		
		logger.debug("생성되기 전 댓글의 값: {}", commend.toString());
		commendDAO.createCommend(commend);
	}
	
	@Test
	public void updateCommendTest() throws Exception {
		CommendVO vo = new CommendVO();
		vo.setCno(11);
		vo.setContent("테스트 성공");
		
		commendDAO.updateCommend(vo);
	}
	
	@Test
	public void deleteCommendTest() throws Exception {
		CommendVO vo = new CommendVO();
		vo.setCno(11);
		commendDAO.deleteCommend(vo.getCno());
	}

}
