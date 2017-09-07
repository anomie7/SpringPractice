<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@include file="commons/top.jsp" %>
    <style>
    	pre {border: 0; background-color: transparent;}
    	
    	ul {
    		list-style: none;
    	}
	</style>
	<script>
		function deleteChk(){
			var isdel = confirm("정말 삭제하시겠어요?");
			if(isdel == true){
				location.href = "deletefile.do?id=${board.id}";
			}
		}
		
		$(document).ready(function(){
			$("#comBtn").click(function(){
				$.ajax({
					url: "commendWrite.do?id=${board.id}",
					data: { "name" : $("#comName").text(), "content" : $("#comContent").val(),
							"boardId" : ${board.id} },
					type: "post",
					success: function(){
						alert('성공적으로 댓글이 달렸어요.');
						$("#comContent").val("");
						location.reload();
					},
					error: function(){
						alert('댓글이 달리지 않았습니다.');
					}
				})
			})
		});
		
		//수정 버튼을 누르면 밑에 작성 폼이 사라지면서 수정 폼이 나타나고 hidden input 태그에 수정 버튼을 누른 commend에 cno를 넣어준다.
		$(document).ready(function(){
			$(".comUp").click(function(){
				$("#upContent").val("");
				$("#cno2").val( $(this).val() );   
				$("#writerLi").css("display", "none");
				$("#hid").css("display", "");
			})
		});
		
		//수정 ajax 함수
		$(document).ready(function(){
			$("#upbtn").click(function(){
				$.ajax({
					url: "commendUpdate.do",
					data: { "cno" : $("#cno2").val(), "content" : $("#upContent").val() },
					type: "post",
					success: function(){
						alert("성공적으로 수정되었습니다.");
						$("#hid").css("display", "none");
						$("#upContent").val("");
						$("#writerLi").css("display", "");
						location.reload();
					},
					error: function(){
						alert("수정 되지 않았어요. 어떻하죠?");
					}
				})
			})
		});
		
		//삭제하는 ajax 함수
		$(document).ready(function(){
			$(".comDe").click(function(){
				
				if(!confirm("정말 삭제하시겠어요?")){
					return;
				}
				
				$.ajax({
					url: "commendDelete.do",
					data: { "cno" : $(this).val() },
					type: "post",
					success: function(){
						alert("성공적으로 삭제되었어요.");
						location.reload();
					},
					error: function(){
					alert("삭제되지 않았어요!");
					}
				})
			})
		});
		
		$(document).ready(function(){
			$("#cencle").click(function(){
				$("#hid").css("display", "none");
				$("#upContent").val("");
				$("#writerLi").css("display", "");
			})
		})
	</script>
</head>
<body>
    <%@include file="commons/navbar.jsp" %>
    <div class="container">
        <div class="col-md-8 col-md-offset-2">
            <div style="padding-bottom: 30px;">
                <h1>글 조회</h1>
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
                    <td>${board.regdate}</td>
                </tr>
                <tr>
                	<th>첨부파일</th>
                	<td colspan="3"><a href="downloadFile.do?id=${board.id}">${file.originalFileName}</a></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3"><pre><code>${board.content}</code></pre></td>
                </tr>
            </table>
            <span class="btn-group col-xs-offset-9">
                    <a href="getFileList.do?nowpage=${nowpage}" class="btn btn-default">목록</a>
                    <c:if test="${board.name eq sessionScope.id}">
                    <a href="updatefile.do?id=${board.id}" class="btn btn-default">수정</a>
                    <a class="btn btn-default" href="javascript:deleteChk()">삭제</a>
                    </c:if>
                </span>
        </div>
    </div>
    <div id="commend" class="container col-sm-7 col-sm-offset-3" >
          <ul>
          	  <c:forEach var="commend" items="${cl}">
          	  <li style="width:650px;">
                    <label for="cominput">${commend.name}</label>
                     <span class="input-group" style="width:650px;">
                          <textarea  class="form-control" readonly="readonly">${commend.content}</textarea>
                     </span>
                     <c:if test="${sessionScope.id eq commend.name}">
                     <span class="btn-group col-md-offset-9">
                        <button class="comUp btn btn-xs btn-primary" value="${commend.cno}">수정</button>
                    	<button class="comDe btn btn-xs btn-primary" value="${commend.cno}">삭제</button>
                     </span>
                     </c:if>
              </li>
          	  </c:forEach>
          	  <c:if test="${not empty id }">
              <li id="writerLi" style="width:650px;">
                    <form class="form-gruop" style="width:650px;">
                        <label for="cominput" id="comName">${id}</label>
                        <span class="input-group" style="width:650px;">
                            <textarea class="form-control" id="comContent"></textarea>
                        </span>
                    </form>
                    <span class="btn-group col-md-offset-9">
                    <button id="comBtn" class="btn btn-primary">전송</button>
                    </span>
              </li>
          	  </c:if>
          	  <li id="hid" style="display: none">
          	  	  <form class="form-gruop" style="width:650px;">
                        <label for="cominput" id="comName">${id}</label>
                        <span class="input-group" style="width:650px;">
                            <textarea class="form-control" id="upContent"></textarea>
                        </span>
                    </form>
                    <span class="btn-group col-md-offset-7">
	                    <input type="hidden" id="cno2" name = "cno" value="">
	                    <button id="upbtn" class="btn btn-primary">수정</button>
	                    <button id="cencle" class="btn btn-primary">취소</button>
                    </span>
          	  </li>
          </ul>
    </div>
</body>
</html>