package com.SpringBoard.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.SpringBoard.domain.BoardVO;

public interface BoardService {

	void createBoard(BoardVO vo);

	BoardVO getBoard(int id);

	List<BoardVO> getBoardList();

	void modifyBoard(BoardVO vo);

	void deleteBoard(int id);
	
	public int getTotalCount(HashMap<String, Object> map);

	Map<String, Object> getSearchWriterAndContent(BoardVO board, int nowpage);

}