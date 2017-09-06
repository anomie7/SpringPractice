package com.SpringBoard.file.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.domain.FileVO;
import com.SpringBoard.mappers.FileMapper;

public class FileDAO {
	@Autowired
	FileMapper fileMapper;
	private static final Logger logger = LoggerFactory.getLogger(FileDAO.class);

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

	public Map<String, Object> getSearchWriterAndContent(BoardVO board, int nowpage) {
		logger.debug("getSearchWriterAndContent() 메소드 호출");
		int row = 3;
		int startpoint = nowpage * row;

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(board.getSearchCondition(), "%" + board.getSearchKeyword() + "%");
		map.put("startpoint", startpoint);
		map.put("row", row);
		List<BoardVO> list = fileMapper.getSearchWriterAndContent(map);
		int totalList = getTotalCount(map);
		map.clear();
		if (totalList == 0) { // 검색 결과가 없을 떄
			return map;
		}

		int totalpage = totalList / row - 1;
		if ((totalList % row) > 0)
			totalpage++;
		logger.info("totalpage: {}", totalpage);

		map.put("boardList", list);
		map.put("nowpage", nowpage);
		map.put("totalpage", totalpage);
		map.put("vo", board);
		return map;
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
