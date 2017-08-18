package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	private static final Logger logger = LoggerFactory.getLogger(AroundAdvice.class);

	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("[Before]: 비즈니스 메소드 수행 전에 처리할 내용....");
		String method = pjp.getSignature().getName();
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		Object returnobj = pjp.proceed();
		
		stopwatch.stop();
		logger.info(method + "() 메소드 수행에 걸린 시간 : " + stopwatch.getTotalTimeMillis() + "(ms)초");
		
		return returnobj;
	}
}
