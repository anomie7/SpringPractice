package com.SpringBoard.file.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.domain.FileVO;
import com.SpringBoard.mappers.FileMapper;

public class FileDAO{
	@Autowired
	private FileMapper fileMapper;

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

	public List<BoardVO> getSearchWriterAndContent(HashMap<String, Object> map) {
		return fileMapper.getSearchWriterAndContent(map);
	}

	public int getTotalCount(HashMap<String, Object> map) {
		return fileMapper.findTotalCount(map);
	}

	public void modifyBoard(BoardVO vo) {
		fileMapper.modifyBoard(vo);
	}

	public void deleteBoard(int id) {
		fileMapper.deleteBoard(id);
	}

	public void deletefile(int fno) {
		fileMapper.deleteFile(fno);
	}
}
