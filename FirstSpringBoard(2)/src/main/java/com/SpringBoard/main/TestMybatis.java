package com.SpringBoard.main;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.model.BoardService;
import com.SpringBoard.test.ContextTest;

@Component
public class TestMybatis {
	private static final Logger logger = LoggerFactory.getLogger(ContextTest.class);
	@Autowired
	BoardService boardService;
	
	@Test
	public void myddd() {
			BoardVO board = boardService.getBoard(1);
			logger.debug(board.toString());
	}
	
	public static void main(String[] args) {
		new TestMybatis().myddd();;
	}
}
