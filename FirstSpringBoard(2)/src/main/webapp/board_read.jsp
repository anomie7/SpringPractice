<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@include file="commons/top.jsp" %>
    <style>
    	pre {border: 0; background-color: transparent;}
	</style>
	<script>
		function deleteChk(){
			var isdel = confirm("정말 삭제하시겠어요?");
			if(isdel == true){
				location.href = "deleteBoard.do?id=${board.id}";
			}
		}
	</script>
</head>
<body>
    <%@include file="commons/navbar.jsp" %>
    <div class="container">
        <div class="col-md-8 col-md-offset-2">
            <div style="padding-bottom: 30px;">
                <h1>글조회</h1>
            </div>
            <table class="table table-condensed">
                <tr>
                    <th>제목</th>
                    <td colspan="3">${board.subject}</td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>${board.name}</td>
                    <th>작성일</th>
                    <td>${board.regDate}</td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3"><pre><code>${board.content}</code></pre></td>
                </tr>
            </table>
            <span class="btn-group col-md-offset-9">
                    <a href="getList.do" class="btn btn-default">목록</a>
                    <c:if test="${board.name eq sessionScope.id}">
                    <a href="boardUpdate.do?id=${board.id}" class="btn btn-default">수정</a>
                    <a class="btn btn-default" href="javascript:deleteChk()">삭제</a>
                    </c:if>
                </span>
        </div>
    </div>
</body>
</html>