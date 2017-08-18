package com.springbook.biz.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AfterThrowingAdvice {
	private static final Logger logger = LoggerFactory.getLogger(AfterThrowingAdvice.class);

	public void exceptionLog() {
		logger.info("[예외 처리] 비즈니스 로직 수행 중 예외 발생");
	}
}
