package com.SpringBoard.model;

import static org.junit.Assert.fail;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.SpringBoard.util.MybatisSqlSessionFactory;

public class BoardDAOTest {
	SqlSession session;
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Before
	public void tearDown() throws Exception {
		session = MybatisSqlSessionFactory.openSession();
		logger.debug("세션을 성공적으로 불러왔습니다.");
	}

	@Test
	public void test() {
		
	}

}
