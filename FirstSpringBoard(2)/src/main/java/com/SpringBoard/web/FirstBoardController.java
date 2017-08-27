package com.SpringBoard.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.model.BoardService;

@Controller
public class FirstBoardController {
	@Autowired
	BoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(FirstBoardController.class);

	@RequestMapping("/getList.do")
	public String home(Model model, BoardVO board,
			@RequestParam(value ="nowpage", defaultValue = "0") int nowpage) {
		int row = 3;
		int startpoint = nowpage * row;
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(board.getSearchCondition(), "%"+ board.getSearchKeyword() + "%");
		map.put("startpoint", startpoint);
		map.put("row", row);
		List<BoardVO> list;
		list = boardService.getSearchWriterAndContent(map);
		
		int totalList = boardService.getTotalCount(map);
		int totalpage = totalList / row - 1;
		if((totalList % row) > 0) totalpage++;
		logger.info("totalpage: {}", totalpage);
		
		model.addAttribute("boardList",list);
		model.addAttribute("nowpage",nowpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("vo", board);
		return "index.jsp";
	}
	
	@RequestMapping("/boardWrite.do")
	public String boardWrite(BoardVO vo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String regDate = sdf.format(new Date());
		vo.setRegDate(regDate);
		boardService.createBoard(vo);
		return "redirect:/getList.do";
	}
	
	@RequestMapping("/boardRead.do")
	public String getBoard(Model model, BoardVO vo) {
		BoardVO board = boardService.getBoard(vo.getId());
		board.setCount(board.getCount() + 1);
		boardService.modifyBoard(board);
		model.addAttribute("board", board);
		return "board_read.jsp";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo.getId());
		return "redirect:/getList.do";
	}
	
	@RequestMapping("/boardUpdate.do")
	public String getBoardForUpdate(Model model, BoardVO vo) {
		BoardVO board = boardService.getBoard(vo.getId());
		model.addAttribute("board" ,board);
		return "board_update.jsp";
	}
	
	@RequestMapping("/updateProcess.do")
	public String updateProcess(BoardVO vo) {
		boardService.modifyBoard(vo);
		return "redirect:/getList.do";
	}
}
