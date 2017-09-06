package com.SpringBoard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoard.commend.dao.CommendService;
import com.SpringBoard.domain.CommendVO;

@RestController
public class CommendComtroller {
	@Autowired
	CommendService commendService;
	
	@RequestMapping(value = "/commendWrite.do")
	public String commendWrite(CommendVO commend) {
		commendService.createCommend(commend);
		return "success!";
	}
	
	@RequestMapping("/commendDelete.do")
	public String commendDelete(CommendVO commend){
		commendService.deleteCommend(commend.getCno());
		return "success!";
	}
	
	@RequestMapping(value = "/commendUpdate.do")
	public String commendUpdate(CommendVO commend) {
		commendService.updateCommend(commend);
		return "success!";
	}
}
