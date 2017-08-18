package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class DispatcherServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String url = request.getRequestURI();
		String path = url.substring(url.lastIndexOf("/"));
		logger.info("url: " + url + ", path: " + path);

		if (path.equals("/login.do")) {
			// 1. 사용자 입력 정보 추출.
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			// 2. DB 연동 처리
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);

			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);

			// 3. 화면 네비게이션
			if (user != null) {
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login.jsp");
			}
		} else if (path.equals("/logout.do")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
		} else if (path.equals("/insertBoard.do")) {
			request.setCharacterEncoding("utf-8");
			AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
			BoardService boardService = (BoardService) container.getBean("boardService");

			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");

			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);

			boardService.insertBoard(vo);
			response.sendRedirect("getBoardList.do");
		} else if (path.equals("/updateBoard.do")) {
			request.setCharacterEncoding("utf-8");
			AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
			BoardService boardService = (BoardService) container.getBean("boardService");
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			
			boardService.updateBoard(vo);
			
			response.sendRedirect("getBoardList.jsp");
		} else if (path.equals("/deleteBoard.do")) {
			AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
			BoardService boardService = (BoardService) container.getBean("boardService");
			String seq = request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			boardService.deleteBoard(vo);
			
			response.sendRedirect("/getBoardList.do");
		} else if (path.equals("/getBoard.do")) {
			String seq = request.getParameter("seq");

			AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

			BoardService boardService = (BoardService) container.getBean("boardService");
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));

			BoardVO board = boardService.getBoard(vo);
			logger.info("getBoard 실행 중");
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			response.sendRedirect("getBoard.jsp");
		} else if (path.equals("/getBoardList.do")) {
			AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
			BoardService boardService = (BoardService) container.getBean("boardService");
			// 1. 사용자 입력 정보 추출
			// 2. DB 연동 처리
			List<BoardVO> boardList = boardService.getBoardList();

			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}
	}
}
