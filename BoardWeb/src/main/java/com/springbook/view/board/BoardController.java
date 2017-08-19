package com.springbook.view.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	AbstractApplicationContext container;
	
	public BoardController() {
		container =
				new GenericXmlApplicationContext("applicationContext.xml");
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		
		boardDAO = (BoardDAO) container.getBean("boardDAO");
		boardDAO.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	@RequestMapping("updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO = (BoardDAO) container.getBean("boardDAO");
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView  getBoardList(BoardDAO boardDAO, ModelAndView mav) {
		boardDAO = (BoardDAO) container.getBean("boardDAO");
		mav.addObject("boardList", boardDAO.getBoardList());
		mav.setViewName("getBoardList.jsp");
		return mav;
	}
	
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		boardDAO = (BoardDAO) container.getBean("boardDAO");
		mav.addObject("board", boardDAO.getBoard(vo));
		mav.setViewName("getBoard.jsp");
		return mav;
	}
	
	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO = (BoardDAO) container.getBean("boardDAO");
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
}
