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
	$(document).ready(function(){
		$("button").click(function(){
			$.ajax({
				url: "testA.do",
				data: { "id" : $("#id").val() },
				type: "get",
				success: function(result){
					alert(result.id + " " +result.email + " " + result.tel);
				}			
			})
		})
	});
</script>
</head>
<body>
	<form method="get">
	<input type="text" name="id" id="id">
	<input type="password" name="password" id="password">
	</form>
	<h1>${sessionScope.id }</h1>
	<div><h1 id="a">안녕 ajax예제야</h1></div>
	<button>하하</button>
</body>
</html>