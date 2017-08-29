<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="commons/top.jsp" %>
    </head>
    <body>
        <%@include file="commons/navbar.jsp" %>
        <div class="container">
        	<h1>My First Spring Board Project</h1>
        	<h1>${sessionScope.id}님 환영합니다.</h1>
        </div>
    </body>
</html>