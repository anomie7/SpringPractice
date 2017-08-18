package com.springbook.biz.board;

import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class BoardServiceTest {
	BoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);
	BoardVO vo;
	
	@Before
	public void setup() {
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		boardService = (BoardService) container.getBean("boardService");
		
		vo = new BoardVO();
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용.......");
	}

	@Test
	public void insertBoardTest() {
		boardService.insertBoard(vo);
		logger.info(boardService.getBoard(vo).toString());
	}
	
	@Test
	public void getListTest() throws Exception {
		List<BoardVO> boardList = boardService.getBoardList();
		for (BoardVO board : boardList) {
			logger.info(board.toString());
		}
	}
}
