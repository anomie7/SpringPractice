<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<script>
	
</script>
</head>
<body>
	<form action="uploadFile.do" method="post" id="frm" name="frm" enctype="multipart/form-data">
		<input name="file" type="file">
		<input type="submit">
	</form>
	
	<a href="downloadFile.do">다운로드</a>
</body>
</html>