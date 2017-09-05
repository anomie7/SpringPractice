package com.SpringBoard.file.dao;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.domain.FileVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/root-context.xml")
public class FileDAOTest {
	@Autowired
	FileDAO fileDAO;
	BoardVO bvo;
	FileVO fvo;
	private static final Logger logger = LoggerFactory.getLogger(FileDAOTest.class);
	
	@Before
	public void setup() {
		bvo = new BoardVO();
		bvo.setId(1);
//		bvo.setName("윤준");
//		bvo.setSubject("안녕1");
//		bvo.setContent("반가워요22");
//		bvo.setRegDate("2017-10-2-2");
//		bvo.setCount(4);
		
		fvo = new FileVO();
		fvo.setBoardId(bvo.getId());
		fvo.setFileSize(123123);
		fvo.setOriginalFileName("오리지널");
		fvo.setStoredFileName(UUID.randomUUID().toString().replace("-", ""));
	}
	
	@Test
	public void insertFileTest() {
		fileDAO.insertFileBoard(bvo);
		fileDAO.insertFile(fvo);
	}
	
	@Test
	public void selectTest() throws Exception {
		BoardVO board = fileDAO.selectFileBoard(bvo.getId());
		FileVO file = fileDAO.selectFile(bvo.getId());
		
		logger.debug(board.toString());
		logger.debug(file.toString());
	}

}
