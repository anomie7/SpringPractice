package com.SpringBoard.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoard.domain.BoardVO;

public class BoardServiceImpl implements BoardService {
	BoardDAO boardDAO = new BoardDAO();
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Override
	public void createBoard(BoardVO vo) {
		logger.debug("createBoard 메소드 호출");
		boardDAO.createBoard(vo);
		logger.debug("createBoard 메소드 작성 완료");
	}

	@Override
	public BoardVO getBoard(int id) {
		logger.debug("getBoard 메소드 호출");
		return boardDAO.getBoard(id);
	}

	@Override
	public List<BoardVO> getBoardList() {
		logger.debug("getBoardList 메소드 호출");
		return boardDAO.getBoardList();
	}

	@Override
	public void modifyBoard(BoardVO vo) {
		logger.debug("modifyBoard 메소드 호출");
		boardDAO.modifyBoard(vo);
		logger.debug("modifyBoard 메소드 작업 완료");
	}

	@Override
	public void deleteBoard(int id) {
		logger.debug("delete 메소드 호출");
		boardDAO.deleteBoard(id);
		logger.debug("delete 메소드 작업 완료");
	}

}
