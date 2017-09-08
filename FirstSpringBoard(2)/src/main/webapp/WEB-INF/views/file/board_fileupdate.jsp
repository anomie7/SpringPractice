<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../commons/top.jsp" %>
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

$(document).ready(function(){
	$("#delFile").on("submit", function(event){
		var isDelete = confirm("파일을 삭제 하시겠습니까?");
		if(isDelete){
			alert("삭제되었습니다.");
		}else{
			event.preventDefault();
		}
	})
});
</script>
</head>
    <body>
        <%@include file="../commons/navbar.jsp" %>
        <div class="container">
            <div class="col-md-7 col-md-offset-2">
            <div class="page-hearder" style="padding-bottom: 20px;">
                <h1>수정 화면</h1>
            </div>
            <div>
                <form class="form-group" action="fileUpdateProcess.do" method="post" enctype="multipart/form-data" onsubmit="return writerCheck(this)">
                <table class="table table-striped row">
                    <tr>
                        <th class="col-md-2">작성자</th>
                        <td>${board.name}</td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td><input class="form-control" id="sub" type="text" name="subject" value="${board.subject}"></td>
                    </tr>
                    <c:if test="${empty file.fno}">
                    <tr>
                    	<th>첨부파일</th>
                   		<td><input name="file" type="file"></td>
                    </tr>
                    </c:if>
                    <tr>
                        <th>내용</th>
                        <td><textarea class="form-control" id="con" name="content" rows="10">${board.content}</textarea></td>
                    </tr>
                    <tr>
                        <td class="text-center" colspan="2">
                        <input class="btn btn-primary" type="hidden" name="id" value="${board.id}">
                        <input class="btn btn-primary" type="hidden" name="count" value="${board.count}">
                        <input class="btn btn-primary" type="submit" value="수정">
                        </td>
                    </tr>  
                </table>
            </form>
            </div>
            <c:if test="${not empty file.fno }">
            <div>
            <form id="delFile" action="fileDelete.do" method="post">
            <div class="page-header">
            	<h4>첨부파일</h4>
            </div>
                <div class="checkbox">
                    <label><input type="checkbox" name="fno" value="${file.fno}">${file.originalFileName}</label>
                    <input type="hidden" name="id" value="${board.id}">
                </div>
                <div>
                	<button class="btn btn-xs btn-primary">삭제</button>
                </div>
            </form>
            </div>
            </c:if>
            <div class="btn-group col-md-offset-9">
              <a href="getFileList.do" class="btn btn-default">목록</a>
            </div>
        </div>
        </div>
    </body>
</html>