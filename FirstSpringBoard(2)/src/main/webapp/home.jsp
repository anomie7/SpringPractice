<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@include file="commons/top.jsp"%>
<style>
	#overview{
		margin: 0px;
	}
	#nav{
		margin-bottom: 0px;
	}
</style>
</head>
<body>
	<%@include file="commons/navbar.jsp"%>
	<div class="jumbotron page-header" id="overview">
		<div class="container">
			<h1>My First Spring Board Project</h1>
			<c:choose>
			<c:when test="${not empty sessionScope.id}">
			<p class="lead">${sessionScope.id}님환영합니다.</p>
			</c:when>
			<c:otherwise>
			<p class="lead">손님 환영합니다. 회원가입해주세요.</p>
			</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>