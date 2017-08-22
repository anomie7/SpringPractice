package com.SpringBoard.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.mappers.BoardMapper;

public class BoardDAO {
	@Autowired
	SqlSession sqlSession;
	
	public BoardDAO() {
		System.out.println("DAO 객체생성");
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
}
