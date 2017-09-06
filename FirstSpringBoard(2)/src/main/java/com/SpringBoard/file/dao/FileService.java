package com.SpringBoard.file.dao;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.domain.FileVO;

public interface FileService {

	void insertFileBoard(BoardVO board, FileVO fvo, HttpServletRequest request);

	void insertFile(BoardVO vo, FileVO fvo, HttpServletRequest request);

	BoardVO selectFileBoard(int id);

	FileVO selectFile(int boardId);

	Map<String, Object> getSearchWriterAndContent(BoardVO board, int nowpage);

	int getTotalCount(HashMap<String, Object> map);

	void modifyBoard(BoardVO vo);

	void deleteBoard(int id);

	void deletefile(int fno);

}