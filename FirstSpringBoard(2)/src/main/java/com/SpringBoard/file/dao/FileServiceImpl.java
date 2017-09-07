package com.SpringBoard.file.dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.domain.FileVO;
import com.SpringBoard.util.FileUtils;

public class FileServiceImpl implements FileService {
	@Autowired
	FileDAO fileDAO;

	@Override
	public void insertFileBoard(BoardVO board, FileVO fvo, HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String regDate = sdf.format(new Date());
		board.setRegdate(regDate);
		fileDAO.insertFileBoard(board);
		insertFile(board, fvo, request);
	}

	@Override
	public void insertFile(BoardVO vo, FileVO fvo, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		map.put("IDX", vo.getId());
		FileUtils fileUtils = new FileUtils();
		try {
			Map<String, Object> filemap = fileUtils.parseInsertFileInfo(map, request);
			if (filemap == null) {
				return;
			}

			Iterator<String> itr = filemap.keySet().iterator();
			while (itr.hasNext()) {
				String key = itr.next();
				if (key.equals("BOARD_IDX")) {
					fvo.setBoardId((int) filemap.get(key));
				} else if (key.equals("ORIGINAL_FILE_NAME")) {
					fvo.setOriginalFileName((String) filemap.get(key));
				} else if (key.equals("STORED_FILE_NAME")) {
					fvo.setStoredFileName((String) filemap.get(key));
				} else if (key.equals("FILE_SIZE")) {
					fvo.setFileSize((long) filemap.get(key));
				}
			}
			fileDAO.insertFile(fvo);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public BoardVO selectFileBoard(int id) {
		return fileDAO.selectFileBoard(id);
	}

	@Override
	public FileVO selectFile(int boardId) {
		return fileDAO.selectFile(boardId);
	}

	@Override
	public Map<String, Object> getSearchWriterAndContent(BoardVO board, int nowpage) {
		int row = 3;
		int startpoint = nowpage * row;

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(board.getSearchCondition(), "%" + board.getSearchKeyword() + "%");
		map.put("startpoint", startpoint);
		map.put("row", row);
		List<BoardVO> list = fileDAO.getSearchWriterAndContent(map);
		int totalList = getTotalCount(map);
		map.clear();
		if (totalList == 0) { // 검색 결과가 없을 떄
			return map;
		}

		int totalpage = totalList / row - 1;
		if ((totalList % row) > 0)
			totalpage++;

		map.put("boardList", list);
		map.put("nowpage", nowpage);
		map.put("totalpage", totalpage);
		map.put("vo", board);
		return map;
	}

	@Override
	public int getTotalCount(HashMap<String, Object> map) {
		return fileDAO.getTotalCount(map);
	}

	@Override
	public void modifyBoard(BoardVO vo) {
		fileDAO.modifyBoard(vo);
	}

	@Override
	public void deleteBoard(int id) {
		fileDAO.deleteBoard(id);
	}

	@Override
	public void deletefile(int fno) {
		fileDAO.deletefile(fno);
	}

}
