package com.SpringBoard.model;

import java.util.List;

import com.SpringBoard.domain.BoardVO;

public interface BoardService {

	void createBoard(BoardVO vo);

	BoardVO getBoard(int id);

	List<BoardVO> getBoardList();

	void modifyBoard(BoardVO vo);

	void deleteBoard(int id);

}