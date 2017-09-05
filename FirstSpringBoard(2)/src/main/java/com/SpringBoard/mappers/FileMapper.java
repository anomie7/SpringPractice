package com.SpringBoard.mappers;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.domain.FileVO;

public interface FileMapper {
	public void insertFileBoard(BoardVO board);
	public void insertFile(FileVO file);
	public BoardVO selectFileBoard(int id);
	public FileVO selectFile(int boardId);
}
