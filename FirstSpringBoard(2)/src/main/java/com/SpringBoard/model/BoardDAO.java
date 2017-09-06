package com.SpringBoard.model;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.mappers.BoardMapper;

public class BoardDAO {
	@Autowired
	BoardMapper boardMapper;
	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);
	
	public BoardDAO() {
		logger.debug("DAO 객체생성");
	}
	
	public void createBoard(BoardVO vo) {
			boardMapper.insertBoard(vo);
	}

	public BoardVO getBoard(int id) {
			return boardMapper.findBoardById(id);
	}

	public List<BoardVO> getBoardList() {
			return boardMapper.findAllBoard();
	}

	public void modifyBoard(BoardVO vo) {
			boardMapper.modifyBoard(vo);
	}

	public void deleteBoard(int id) {
			boardMapper.deleteBoard(id);
		}
	

	public List<BoardVO> getSearchWriterAndContent(HashMap<String, Object> map) {
		return boardMapper.getSearchWriterAndContent(map);
	}
	
	public int getTotalCount(HashMap<String, Object> map) {
		return boardMapper.findTotalCount(map);
	}
	
}
