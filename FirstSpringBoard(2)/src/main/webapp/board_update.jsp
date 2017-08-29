<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="commons/top.jsp" %>
<script>
function writerCheck(f){
	if(f.sub.value == ''){
		alert("제목을 입력해주세요.")
		return false;
	}
	if(f.con.value.length == 0){
		alert("내용을 입력해주세요.");
		return false;
	}
}
</script>
</head>
    <body>
        <%@include file="commons/navbar.jsp" %>
        <div class="container">
            <div class="col-md-7 col-md-offset-2">
            <div class="page-hearder" style="padding-bottom: 20px;">
                <h1>글쓰기 화면</h1>
            </div>
            <div>
                <form class="form-group" action="updateProcess.do" method="post" onsubmit="return writerCheck(this)">
                <table class="table table-striped row">
                    <tr>
                        <th class="col-md-2">작성자</th>
                        <td>${board.name}</td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td><input class="form-control" id="sub" type="text" name="subject" value="${board.subject}"></td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td><textarea class="form-control" id="con" name="content" rows="10">${board.content}</textarea></td>
                    </tr>
                    <tr>
                        <td class="text-center" colspan="2">
                        <input class="btn btn-primary" type="hidden" name="id" value="${board.id}">
                        <input class="btn btn-primary" type="submit" value="수정">
                        </td>
                    </tr>  
                </table>
            </form>
            </div>
            </div>
            <div class="btn-group col-md-offset-9">
              <a href="getList.do" class="btn btn-default">목록</a>
            </div>
        </div>
    </body>
</html>