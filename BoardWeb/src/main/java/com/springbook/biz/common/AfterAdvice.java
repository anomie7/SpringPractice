package com.springbook.biz.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AfterAdvice {
	private static final Logger logger = LoggerFactory.getLogger(AfterAdvice.class);
	
	public void finallyLog() {
		logger.info("[사후 처리] 비즈니스 로직 수행 후 무조건 동작");
	}
}
