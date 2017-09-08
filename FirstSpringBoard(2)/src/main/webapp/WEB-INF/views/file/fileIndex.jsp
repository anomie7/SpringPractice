<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@include file="../commons/top.jsp" %>
</head>
<body>
  <%@include file="../commons/navbar.jsp" %>
	<div class="container row">
		<div class="col-sm-offset-9">
                <form action="getList.do" method="get">
                    <select name="searchCondition" id="">
                        <option value="writer">작성자</option>
                        <option value="content">내용</option>
                    </select>
                    <input type="text" name="searchKeyword" id="search">
                    <input class="btn btn-sm btn-default" type="submit" value="검색">
                </form>
            </div>
		<div class="col-md-10 col-md-offset-3">
			<table class="table table-striped ">
				<tr class="text-center">
					<th>번호</th>
					<th style="text-align: center">제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>조회</th>
				</tr>
				<c:forEach items="${boardList}" var="board">
				<tr>
					<td class="col-sm-1">${board.id}</td>
					<td style="text-align:center"><a href="fileboardRead.do?id=${board.id}&nowpage=${nowpage}">${board.subject}</a></td>
					<td class="col-sm-2">${board.name}</td>
					<td class="col-sm-2">${board.regdate}</td>
					<td class="col-sm-1">${board.count}</td>
				</tr>
				</c:forEach>
			</table>
			<div class="btn-group col-md-offset-10">
			<c:if test="${not empty sessionScope.id}">
			<a href="board_fileWrite.jsp" class="btn btn-default">글쓰기</a>
			</c:if>
			</div>
		</div>
		<div class="col-md-offset-6">
			<ul class="pagination">
				<li><a href="getFileList.do?nowpage=0&searchCondition=${vo.searchCondition}&searchKeyword=${vo.searchKeyword}">처음</a></li>
				
				<!--현재 페이지가 0보다 작아질 경우 이전 버튼을 disabled하는 조건문  -->
				<c:choose>
				<c:when test="${nowpage <= 0}">
				<li class="disabled"><a href="#">이전</a></li>
				</c:when>
				<c:otherwise>
				<li><a href="getFileList.do?nowpage=${nowpage-1}&searchCondition=${vo.searchCondition}&searchKeyword=${vo.searchKeyword}">이전</a></li>
				</c:otherwise>
				</c:choose>
				
				<!--해당하는 페이지로 갈 수 있는 버튼  -->
				<c:forEach var="i" begin="0" end="${totalpage}" >
  				<li><a href="getFileList.do?nowpage=${i}&searchCondition=${vo.searchCondition}&searchKeyword=${vo.searchKeyword}">${i+1}</a></li>
				</c:forEach>
				
				<!--현재 페이지가 totalpage보다 커질 경우 다음 버튼을 disabled하는 조건문  -->
  				<c:choose>
  				<c:when test="${nowpage >= totalpage }">
  				<li class="disabled"><a href="#">다음</a></li>
  				</c:when>
  				<c:otherwise>
  				<li><a href="getFileList.do?nowpage=${nowpage+1}&searchCondition=${vo.searchCondition}&searchKeyword=${vo.searchKeyword}">다음</a></li>
  				</c:otherwise>
  				</c:choose>
  				<li><a href="getFileList.do?nowpage=${totalpage}&searchCondition=${vo.searchCondition}&searchKeyword=${vo.searchKeyword}">마지막</a></li>
			</ul>
		</div>
	</div>
</body>
</html>