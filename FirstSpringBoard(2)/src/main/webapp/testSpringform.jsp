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
		<form:errors path="id"></form:errors>
		<form:password path="password" showPassword="true"/>
		<form:errors path="password"></form:errors>
		<input type="submit" value="전송">
	</form:form>
	<h1>${sessionScope.id }</h1>
</body>
</html>