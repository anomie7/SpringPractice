package com.SpringBoard.web;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.domain.FileVO;
import com.SpringBoard.file.dao.FileDAO;
import com.SpringBoard.util.FileUtils;

@Controller
public class FileBoardController {
	@Autowired
	FileDAO fileDAO;

	@RequestMapping("FileWrite.do")
	public String fileWrite(BoardVO vo, FileVO fvo, HttpServletRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String regDate = sdf.format(new Date());
		vo.setRegDate(regDate);
		fileDAO.insertFileBoard(vo);

		Map<String, Object> map = new HashMap<>();
		map.put("IDX", vo.getId());
		FileUtils fileUtils = new FileUtils();
		try {
			Map<String, Object> filemap = fileUtils.parseInsertFileInfo(map, request);

			Iterator<String> itr = filemap.keySet().iterator();
			while (itr.hasNext()) {
				String key = itr.next();
				if (key.equals("BOARD_IDX")) {
					fvo.setBoardId((int) filemap.get(key));
				} else if (key.equals("ORIGINAL_FILE_NAME")) {
					fvo.setOriginalFileName((String) filemap.get(key));
				} else if (key.equals("STORED_FILE_NAME")) {
					fvo.setStoredFileName((String) filemap.get(key));
				} else if (key.equals("FILE_SIZE")) {
					fvo.setFileSize((long) filemap.get(key));
				}
			}
			fileDAO.insertFile(fvo);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "home.do";
	}
	
	@RequestMapping("/fileboardRead.do")
	public String getBoard(Model model, BoardVO vo, FileVO fvo) {
		BoardVO board = fileDAO.selectFileBoard(vo.getId());
		board.setCount(board.getCount() + 1);
		fvo = fileDAO.selectFile(vo.getId());
		
		model.addAttribute("file", fvo);
		model.addAttribute("board", board);
		return "board_fileRead.jsp";
	}
	

	@RequestMapping("/downloadFile.do")
	public void downloadFile(HttpServletResponse response, @RequestParam("id") int id) throws IOException {
		final String filePath = "c:\\dev\\file\\";

		FileVO file = fileDAO.selectFile(id);
		String originalFileName = file.getOriginalFileName();
		String storedFileName = file.getStoredFileName();

		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File(filePath + storedFileName));

		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",
				"attachment; fileName=\"" + URLEncoder.encode(originalFileName, "UTF-8") + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);

		response.getOutputStream().flush();
		response.getOutputStream().close();
	}

}
