package com.SpringBoard.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.model.BoardService;

@Controller
public class FIrstBoardController {
	@Autowired
	BoardService boardService;
	private static final Logger logger = LoggerFactory.getLogger(FIrstBoardController.class);

	@RequestMapping("/getList.do")
	public String home(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		for (BoardVO board : boardService.getBoardList()) {
			logger.info(board.toString());
		}
		return "index.jsp";
	}
}
