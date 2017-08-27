package com.SpringBoard.mappers;

import java.util.HashMap;
import java.util.List;

import com.SpringBoard.domain.BoardVO;

public interface BoardMapper {
	BoardVO findBoardById(Integer id);
	List<BoardVO> findAllBoard();
	int findTotalCount(HashMap<String, Object> map);
	void insertBoard(BoardVO board);
	void modifyBoard(BoardVO board);
	void deleteBoard(Integer id);
	List<BoardVO> getSearchWriterAndContent(HashMap<String, Object> map);
}
