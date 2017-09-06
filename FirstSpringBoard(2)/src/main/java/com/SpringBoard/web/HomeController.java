package com.SpringBoard.web;

//github.com/anomie7/SpringPractice.git
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//github.com/anomie7/SpringPractice.git
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("id")
public class HomeController {
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

//	@Autowired
//	UserService userDAO;
//
	@RequestMapping("/home.do")
	public String gohome() {
		return "home.jsp";
	}
//
//	@RequestMapping("/testForm.do")
//	public String goTestPage() {
//		return "testSpringform.jsp";
//	}

//	@RequestMapping("/uploadFile.do")
//	public String uploadFile(HttpServletRequest request) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("IDX", "1");
//		FileUtils fileUtils = new FileUtils();
//		try {
//			Map<String, Object> list =  fileUtils.parseInsertFileInfo(map, request);
//			
//			Iterator<String> itr = list.get(0).keySet().iterator();
//			while(itr.hasNext()) {
//				String key = itr.next();
//				logger.debug("{} : {}", key, list.get(0).get(key));
//			}
//		} catch (IllegalStateException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "home.do";
//	}
	
//	@RequestMapping("/downloadFile.do")
//	public void downloadFile(HttpServletResponse response) throws IOException {
//		String originalFileName = "사진.jpg";
//		String storedFileName = "6f97a846fc994a83bcea4320b0b48161.jpg";
//		final String filePath = "c:\\dev\\file\\";
//		
//		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File(filePath + storedFileName));
//		
//		response.setContentType("application/octet-stream");
//	    response.setContentLength(fileByte.length);
//	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
//	    response.setHeader("Content-Transfer-Encoding", "binary");
//	    response.getOutputStream().write(fileByte);
//	     
//	    response.getOutputStream().flush();
//	    response.getOutputStream().close();
//	}
}
