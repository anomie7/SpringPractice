package com.SpringBoard.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringBoard.commend.dao.CommendService;
import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.domain.CommendVO;
import com.SpringBoard.model.BoardService;

@Controller
public class FirstBoardController {
	@Autowired
	BoardService boardService;
	@Autowired
	CommendService commendDAO;

	@RequestMapping("/getList.do")
	public String home(Model model, BoardVO board, @RequestParam(value = "nowpage", defaultValue = "0") int nowpage) {
		Map<String, Object> map = boardService.getSearchWriterAndContent(board, nowpage);
		if (map.isEmpty()) {
			return "index.jsp";
		}
		model.addAllAttributes(map);
		return "index.jsp";
	}

	@RequestMapping("/boardWrite.do")
	public String boardWrite(BoardVO vo) {
		boardService.createBoard(vo);
		return "redirect:/getList.do";
	}

	@RequestMapping("/boardRead.do")
	public String getBoard(Model model, BoardVO vo, @RequestParam(value = "nowpage", defaultValue = "0") int nowpage) {
		BoardVO board = boardService.getBoard(vo.getId());
		board.setCount(board.getCount() + 1);
		boardService.modifyBoard(board);

		List<CommendVO> cl = commendDAO.getCommendList(board.getId());
		
		model.addAttribute("cl", cl);
		model.addAttribute("board", board);
		model.addAttribute("nowpage", nowpage);
		return "board_read.jsp";
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo.getId());
		return "redirect:/getList.do";
	}

	@RequestMapping("/boardUpdate.do")
	public String getBoardForUpdate(Model model, BoardVO vo) {
		model.addAttribute("board", boardService.getBoard(vo.getId()) );
		return "board_update.jsp";
	}

	@RequestMapping("/updateProcess.do")
	public String updateProcess(BoardVO vo) {
		boardService.modifyBoard(vo);
		return "redirect:/getList.do";
	}

}
