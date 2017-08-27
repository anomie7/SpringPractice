package com.SpringBoard.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.mappers.BoardMapper;

public class BoardDAO {
	@Autowired
	SqlSession sqlSession;
	private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);
	
	public BoardDAO() {
		logger.debug("DAO 객체생성");
	}
	
	public void createBoard(BoardVO vo) {
			BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
			boardMapper.insertBoard(vo);
	}

	public BoardVO getBoard(int id) {
			BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
			return boardMapper.findBoardById(id);
	}

	public List<BoardVO> getBoardList() {
			BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
			return boardMapper.findAllBoard();
	}

	public void modifyBoard(BoardVO vo) {
			BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
			boardMapper.modifyBoard(vo);
	}

	public void deleteBoard(int id) {
			BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
			boardMapper.deleteBoard(id);
		}
	

	public List<BoardVO> getSearchWriterAndContent(HashMap<String, Object> map) {
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		return boardMapper.getSearchWriterAndContent(map);
	}
	
	public int getTotalCount() {
		BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
		return boardMapper.findTotalCount();
	}
}
