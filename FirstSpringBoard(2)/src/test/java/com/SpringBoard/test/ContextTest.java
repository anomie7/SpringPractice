package com.SpringBoard.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.model.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/root-context.xml")
public class ContextTest {
	private static final Logger logger = LoggerFactory.getLogger(ContextTest.class);
	@Autowired
	BoardService boardService;
	BoardVO vo;

	@Before
	public void testsetup() throws Exception {
		logger.debug("DAO 객체 생성완료");
		vo = new BoardVO();
		vo.setId(22);
		vo.setName("윤준");
		vo.setSubject("안녕1");
		vo.setContent("반가워요22");
		vo.setRegDate("2017-10-2-2");
		vo.setCount(4);
		vo.setPassword("1234");
		logger.debug("테스트 객체 생성완료");
	}

	@Test
	public void getBoardtest() {
		BoardVO board = boardService.getBoard(vo.getId());
		assertNotNull(board);
		logger.info(board.toString());
	}

	@Test
	public void createBoardTest() {
		boardService.createBoard(vo);
		assertNull(vo);
	}
	
	@Test
	public void getBoardListTest() throws Exception {
		List<BoardVO> list = boardService.getBoardList();
		assertNotNull(list);
		for (BoardVO board : list) {
			logger.info(board.toString());
		}
	}
	
	@Test
	public void modifyBoardTest() throws Exception {
		BoardVO up = new BoardVO();
		up.setId(vo.getId());
		up.setSubject("나가");
		up.setContent("22324");
		boardService.modifyBoard(up);
	}
	
	@Test
	public void deleteBoardTest() throws Exception {
		boardService.deleteBoard(vo.getId());
		assertNull(boardService.getBoard(vo.getId()));
	}
	
	@Test
	public void SearchWriterTest() throws Exception {
		List<BoardVO> list = boardService.getSearchWriter("%아%");
		for (BoardVO vo : list) {
			logger.info(vo.toString());
		}
	}
	
	@Test
	public void SearchContentTest() throws Exception {
		List<BoardVO> list = boardService.getSearchContent("%22%");
		for (BoardVO vo : list) {
			logger.info(vo.toString());
		}
	}
	
	@Test
	public void SearchWriterAndContentTest() throws Exception {
		HashMap<String, String> map = new HashMap<>();
		map.put("writer", "");
		map.put("content", "");
		List<BoardVO> list = boardService.getSearchWriterAndContent(map);
		for (BoardVO vo : list) {
			logger.info(vo.toString());
		}
	}

}
