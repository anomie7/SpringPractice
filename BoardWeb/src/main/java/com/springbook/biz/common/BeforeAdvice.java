package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeforeAdvice {
	private static final Logger logger = LoggerFactory.getLogger(BeforeAdvice.class);

	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		
		logger.info("[사전 처리] " + method + "() 메소드 ARGS 정보: " + args[0].toString());
	}
}
