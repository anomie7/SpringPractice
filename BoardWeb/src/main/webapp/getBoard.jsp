<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.*"%>
<%@page import="org.springframework.context.support.*"%>
<% BoardVO board = (BoardVO) session.getAttribute("board"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>글 상세</h1>
		<a href="logout.do">Log-out</a>
		<hr>
		<form action="updateBoard.do" method="post">
			<input name="seq" type="hidden" value="<%=board.getSeq()%>">
			<table board="1" cellpadding="0" cellspacing="0">	
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left">
						<input name="title" type="text" value="<%=board.getTitle()%>"/>
					</td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">작성자</td>
					<td align="left"><%=board.getWriter() %></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">내용</td>
					<td align="left">
						<textarea name="content" rows="10" cols="40">
						<%=board.getContent()%>
						</textarea>
					</td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">등록일</td>
					<td align="left"><%=board.getRegDate() %></td>
				</tr>
				<tr>
					<td bgcolor="orange" width="70">조회수</td>
					<td align="left"><%=board.getCnt()%></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글 수정"/>
					</td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertBoard.jsp">글 등록</a>
		<a href="deleteBoard.do?seq=<%=board.getSeq()%>">글 삭제</a>
		<a href="getBoardList.do">글 목록</a>
	</center>
</body>
</html>