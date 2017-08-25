package com.SpringBoard.mappers;

import java.util.HashMap;
import java.util.List;

import com.SpringBoard.domain.BoardVO;

public interface BoardMapper {
	BoardVO findBoardById(Integer id);
	List<BoardVO> findAllBoard();
	void insertBoard(BoardVO board);
	void modifyBoard(BoardVO board);
	void deleteBoard(Integer id);
	List<BoardVO> findBoardByWriter(String writer);
	List<BoardVO> findBoardByContent(String content);
	List<BoardVO> getSearchWriterAndContent(HashMap<String, String> map);
}
