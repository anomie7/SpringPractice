<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="user" action="testForm.do">
		<form:input path="id"/>
		<form:password path="password" showPassword="true"/>
		<input type="submit" value="전송">
	</form:form>
</body>
</html>