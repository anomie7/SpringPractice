package com.SpringBoard.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoard.domain.BoardVO;

public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDAO;
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	public BoardServiceImpl() {
		logger.debug("Service 객체생성");
	}

	@Override
	public void createBoard(BoardVO vo) {
		logger.debug("createBoard 메소드 호출");
		boardDAO.createBoard(vo);
		logger.debug("createBoard 메소드 작성 완료");
	}

	@Override
	public BoardVO getBoard(int id) {
		logger.debug("getBoard 메소드 호출");
		return boardDAO.getBoard(id);
	}

	@Override
	public List<BoardVO> getBoardList() {
		logger.debug("getBoardList 메소드 호출");
		return boardDAO.getBoardList();
	}

	@Override
	public void modifyBoard(BoardVO vo) {
		logger.debug("modifyBoard 메소드 호출");
		boardDAO.modifyBoard(vo);
		logger.debug("modifyBoard 메소드 작업 완료");
	}

	@Override
	public void deleteBoard(int id) {
		logger.debug("delete 메소드 호출");
		boardDAO.deleteBoard(id);
		logger.debug("delete 메소드 작업 완료");
	}

	@Override
	public Map<String, Object> getSearchWriterAndContent(BoardVO board, int nowpage) {
		logger.debug("getSearchWriterAndContent() 메소드 호출");
		int row = 3;
		int startpoint = nowpage * row;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(board.getSearchCondition(), "%"+ board.getSearchKeyword() + "%");
		map.put("startpoint", startpoint);
		map.put("row", row);
		List<BoardVO> list = boardDAO.getSearchWriterAndContent(map);
		int totalList = getTotalCount(map);
		map.clear();
		if(totalList == 0) {   //검색 결과가 없을 떄
			return map;
		}
		
		int totalpage = totalList / row - 1;
		if((totalList % row) > 0) totalpage++;
		logger.info("totalpage: {}", totalpage);
		
		map.put("boardList",list);
		map.put("nowpage",nowpage);
		map.put("totalpage", totalpage);
		map.put("vo", board);
		return map;
	}

	@Override
	public int getTotalCount(HashMap<String, Object> map) {
		logger.debug("getTotalCount() 메소드 호출");
		return boardDAO.getTotalCount(map);
	}

}
