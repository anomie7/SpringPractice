package com.springbook.view.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController{
	
	@RequestMapping("deleteBoard.do")
	public String handleRequest(BoardVO vo, BoardDAO boardDAO) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		boardDAO = (BoardDAO) container.getBean("boardDAO");
		
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

}
