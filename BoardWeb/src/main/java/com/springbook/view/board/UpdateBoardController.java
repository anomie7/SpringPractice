package com.springbook.view.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class UpdateBoardController{
	
	@RequestMapping("updateBoard.do")
	public String handleRequest(BoardVO vo, BoardDAO boardDAO) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		boardDAO = (BoardDAO) container.getBean("boardDAO");
		
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}

}
