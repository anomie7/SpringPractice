package com.springbook.biz.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jAdvice {
	private static final Logger logger = LoggerFactory.getLogger(Log4jAdvice.class);

	public void printLogging() {
		logger.info("[공통 로그-Log4j] 비즈니스 로직 수행 전 동작");
	}
}
