package com.SpringBoard.mappers;

import java.util.HashMap;
import java.util.List;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.domain.FileVO;

public interface FileMapper {
	public void insertFileBoard(BoardVO board);
	public void insertFile(FileVO file);
	public BoardVO selectFileBoard(int id);
	public FileVO selectFile(int boardId);
	List<BoardVO> getSearchWriterAndContent(HashMap<String, Object> map);
	int findTotalCount(HashMap<String, Object> map);
	void modifyBoard(BoardVO board);
	void deleteBoard(Integer id);
	public void deleteFile(int fno);
}
