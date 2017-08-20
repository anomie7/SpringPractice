package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	AbstractApplicationContext container;
	BoardDAO boardDAO;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	public BoardController() {
		container = new GenericXmlApplicationContext("applicationContext.xml");
		boardDAO = (BoardDAO) container.getBean("boardDAO");
		logger.info("컨트롤러 객체 생성");
	}

	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
		return "redirect:getBoardList.do";
	}

	@RequestMapping("updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		logger.info("번호: " + vo.getSeq());
		logger.info("제목 : " + vo.getTitle());
		logger.info("작성자 : " + vo.getWriter());
		logger.info("내용 : " + vo.getContent());
		logger.info("등록일 : " + vo.getRegDate());
		logger.info("조회수 : " + vo.getCnt());
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(
			@RequestParam(value = "searchCondition", defaultValue = "TITLE", required = false) String condition,
			@RequestParam(value = "searchKeyword", defaultValue = "", required = false) String keyword, Model model) {
		logger.info("검색 조건 : " + condition);
		logger.info("검색 단어 : " + keyword);
		model.addAttribute("boardList", boardDAO.getBoardList());
		return "getBoardList.jsp";
	}

	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, ModelAndView mav, Model model) {
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard.jsp";
	}

	@RequestMapping("deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
}
