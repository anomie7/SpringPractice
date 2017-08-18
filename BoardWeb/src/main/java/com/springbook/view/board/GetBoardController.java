package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.view.controller.Controller;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String seq = request.getParameter("seq");
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		BoardService boardService = (BoardService) container.getBean("boardService");
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));

		BoardVO board = boardService.getBoard(vo);
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		return "getBoard";
	}

}
