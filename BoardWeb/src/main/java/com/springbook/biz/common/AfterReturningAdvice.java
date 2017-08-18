package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.springbook.biz.user.UserVO;

public class AfterReturningAdvice {
	private static final Logger logger = LoggerFactory.getLogger(AfterReturningAdvice.class);

	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		if (returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if (user.getRole().equals("Admin")) {
				logger.info(user.getName() + "로그인(Admin)");
			}
		}

		logger.info("[사후 처리] " + method + "() 메소드 리턴값: " + returnObj.toString());
	}
}
