package com.SpringBoard.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.SpringBoard.mappers.BoardMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/root-context.xml")
public class SpringMybatisContext {
	@Autowired
	BoardMapper boardMapper;
	
	@Test
	public void test() {
		assertNotNull(boardMapper);
	}

}
