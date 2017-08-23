<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title></title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container row">
		<div class="page-hearder col-md-offset-3" style="padding-bottom: 20px">
			<h1>메인화면</h1>
		</div>
		<div class="col-md-10 col-md-offset-3">
			<table class="table table-striped ">
				<tr class="text-center">
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>조회</th>
				</tr>
				<c:forEach items="${boardList}" var="board">
				<tr>
					<td class="col-sm-1">${board.id}</td>
					<td><a href="#">${board.subject }</a></td>
					<td>${board.name }</td>
					<td>${board.regDate }</td>
					<td class="col-sm-1">${board.count}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="btn-group col-md-offset-10">
			<a href="#" class="btn btn-default">글쓰기</a>
		</div>
	</div>
</body>
</html>