package com.SpringBoard.model;

import java.util.HashMap;
import java.util.List;

import com.SpringBoard.domain.BoardVO;

public interface BoardService {

	void createBoard(BoardVO vo);

	BoardVO getBoard(int id);

	List<BoardVO> getBoardList();

	void modifyBoard(BoardVO vo);

	void deleteBoard(int id);
	
	List<BoardVO> getSearchWriter(String writer);

	List<BoardVO> getSearchContent(String content);

	List<BoardVO> getSearchWriterAndContent(HashMap<String, String> map);

}