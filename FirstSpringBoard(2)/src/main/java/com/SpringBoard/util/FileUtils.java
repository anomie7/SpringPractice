package com.SpringBoard.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUtils {
	private static final String filePath = "c:\\dev\\file\\";
	
	public Map<String, Object> parseInsertFileInfo(Map<String, Object> map, HttpServletRequest request) throws IllegalStateException, IOException{
		MultipartHttpServletRequest mhsq = (MultipartHttpServletRequest) request;
		Iterator<String> itr = mhsq.getFileNames();
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName =null;
		
		Map<String, Object> listMap = null;
		
		int boardIdx = (int) map.get("IDX");
		File file = new File(filePath);
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		while(itr.hasNext()) {
			multipartFile = mhsq.getFile(itr.next());
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = CommonUtils.getRandomString() + originalFileExtension;
				
				file = new File(filePath + storedFileName);
				multipartFile.transferTo(file);
				
				listMap = new HashMap<>();
				listMap.put("BOARD_IDX", boardIdx);
				listMap.put("ORIGINAL_FILE_NAME", originalFileName);
				listMap.put("STORED_FILE_NAME", storedFileName);
				listMap.put("FILE_SIZE", multipartFile.getSize());
			}
		}
		return listMap;
	}
}
