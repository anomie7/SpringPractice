package com.SpringBoard.file.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.domain.FileVO;
import com.SpringBoard.mappers.FileMapper;

public class FileDAO {
	@Autowired
	FileMapper fileMapper;

	public void insertFileBoard(BoardVO board) {
		fileMapper.insertFileBoard(board);
	}

	public void insertFile(FileVO file) {
		fileMapper.insertFile(file);
	}
	
	public BoardVO selectFileBoard(int id) {
		return fileMapper.selectFileBoard(id);
	}
	public FileVO selectFile(int boardId) {
		return fileMapper.selectFile(boardId);
	}
}
