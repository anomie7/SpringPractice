package com.SpringBoard.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.util.MybatisSqlSessionFactory;


public class BoardDAOTest {
	SqlSession session;
	BoardService boardService;
	BoardVO vo;
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Before
	public void testsetup() throws Exception {
		session = MybatisSqlSessionFactory.openSession();
		logger.debug("세션을 성공적으로 불러왔습니다.");
		logger.debug("DAO 객체 생성완료");
		boardService = new BoardServiceImpl();
		vo = new BoardVO();
		vo.setId(7);
		vo.setName("윤도담");
		vo.setSubject("안녕");
		vo.setContent("반가워요22");
		vo.setRegDate("2017-10-2-2");
		vo.setCount(4);
		vo.setPassword("1234");
		logger.debug("테스트 객체 생성완료");
	}
	
	@Test
	public void createBoardTest() {
		boardService.createBoard(vo);
		assertNull(vo);
	}
	
	@Test
	public void testgetBoard() throws Exception {
		BoardVO board = boardService.getBoard(vo.getId());
		assertNotNull(board);
		logger.debug(board.toString());
	}
	
	@Test
	public void testgetBoardList() throws Exception {
		List<BoardVO> list = boardService.getBoardList();
		assertNotNull(list);
		for (BoardVO board : list) {
			logger.debug(board.toString());
		}
	}
	
	@Test
	public void testmodifyBoard() throws Exception {
		BoardVO up = new BoardVO();
		up.setId(7);
		up.setSubject("나가");
		up.setContent("22324");
		boardService.modifyBoard(up);
	}
	@Test
	public void testdeleteBoard() throws Exception {
		boardService.deleteBoard(vo.getId());
		assertNull(boardService.getBoard(vo.getId()));
	}
}
