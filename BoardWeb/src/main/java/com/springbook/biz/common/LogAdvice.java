package com.springbook.biz.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAdvice {
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);

	public void printLog() {
		logger.info("[공통 로그] 비즈니스 로직 수행 전 동작");
	}
}
