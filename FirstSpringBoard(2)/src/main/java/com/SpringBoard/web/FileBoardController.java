package com.SpringBoard.web;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringBoard.commend.dao.CommendService;
import com.SpringBoard.domain.BoardVO;
import com.SpringBoard.domain.CommendVO;
import com.SpringBoard.domain.FileVO;
import com.SpringBoard.file.dao.FileService;

@Controller
public class FileBoardController {
	@Autowired
	FileService fileService;
	@Autowired
	CommendService commendDAO;

	@RequestMapping("getFileList.do")
	public String getFileList(Model model, BoardVO board,
			@RequestParam(value = "nowpage", defaultValue = "0") int nowpage) {
		Map<String, Object> map = fileService.getSearchWriterAndContent(board, nowpage);
		if (map.isEmpty()) {
			return "fileIndex.jsp";
		}

		model.addAllAttributes(map);
		return "fileIndex.jsp";
	}

	@RequestMapping("FileWrite.do")
	public String fileWrite(BoardVO vo, FileVO fvo, HttpServletRequest request) {
		fileService.insertFileBoard(vo, fvo, request);
		return "getFileList.do";
	}

	@RequestMapping("/fileboardRead.do")
	public String getBoard(Model model, BoardVO vo) {
		BoardVO board = fileService.selectFileBoard(vo.getId());
		board.setCount(board.getCount() + 1);
		fileService.modifyBoard(board);
		FileVO fvo = fileService.selectFile(vo.getId());
		
		List<CommendVO> cl = commendDAO.getCommendList(board.getId());
		
		model.addAttribute("cl", cl);
		model.addAttribute("file", fvo);
		model.addAttribute("board", board);
		return "board_fileRead.jsp";
	}

	@RequestMapping("/downloadFile.do")
	public void downloadFile(HttpServletResponse response, @RequestParam("id") int id) throws IOException {
		final String filePath = "c:\\dev\\file\\";

		FileVO file = fileService.selectFile(id);
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

	@RequestMapping("/deletefile.do")
	public String deleteBoard(BoardVO vo) {
		fileService.deleteBoard(vo.getId());
		return "redirect:/getList.do";
	}

	@RequestMapping("/updatefile.do")
	public String getBoardForUpdate(Model model, BoardVO vo) {
		BoardVO board = fileService.selectFileBoard(vo.getId());
		FileVO fvo = fileService.selectFile(vo.getId());

		model.addAttribute("file", fvo);
		model.addAttribute("board", board);
		return "board_fileupdate.jsp";
	}

	@RequestMapping("/fileUpdateProcess.do")
	public String updateProcess(BoardVO vo, FileVO fvo, HttpServletRequest request) {
		fileService.modifyBoard(vo);
		fileService.insertFile(vo, fvo, request);
		return "getFileList.do";
	}

	@RequestMapping("/fileDelete.do")
	public String deleteFile(@RequestParam("fno") int fno, @RequestParam("id") int id, Model model) {
		fileService.deletefile(fno);
		model.addAttribute("id", id);
		return "updatefile.do";
	}

}
