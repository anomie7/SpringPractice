package com.SpringBoard.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.mappers.BoardMapper;
import com.SpringBoard.util.MybatisSqlSessionFactory;

public class BoardDAO {

	public void createBoard(BoardVO vo) {
		SqlSession session = MybatisSqlSessionFactory.openSession();
		try {
			BoardMapper boardMapper = session.getMapper(BoardMapper.class);
			boardMapper.insertBoard(vo);
			session.commit();
		} finally {
			session.close();
		}
	}

	public BoardVO getBoard(int id) {
		SqlSession session = MybatisSqlSessionFactory.openSession();
		try {
			BoardMapper boardMapper = session.getMapper(BoardMapper.class);
			return boardMapper.findBoardById(id);
		} finally {
			session.close();
		}
	}

	public List<BoardVO> getBoardList() {
		SqlSession session = MybatisSqlSessionFactory.openSession();
		try {
			BoardMapper boardMapper = session.getMapper(BoardMapper.class);
			return boardMapper.findAllBoard();
		} finally {
			session.close();
		}
	}

	public void modifyBoard(BoardVO vo) {
		SqlSession session = MybatisSqlSessionFactory.openSession();
		try {
			BoardMapper boardMapper = session.getMapper(BoardMapper.class);
			boardMapper.modifyBoard(vo);
			session.commit();
		} finally {
			session.close();
		}
	}

	public void deleteBoard(int id) {
		SqlSession session = MybatisSqlSessionFactory.openSession();
		try {
			BoardMapper boardMapper = session.getMapper(BoardMapper.class);
			boardMapper.deleteBoard(id);
			session.commit();
		} finally {
			session.close();
		}
	}
}
