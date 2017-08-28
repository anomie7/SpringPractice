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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
    	pre {border: 0; background-color: transparent;}
	</style>
</head>
<body>
  <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="home.html" class="navbar-brand">FirstSpring Project</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="">로그인</a></li>
                    <li><a href="">회원가입</a></li>
                    <li><a href="getList.do">게시판</a></li>
                </ul>
            </div>
        </nav>
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
                    <td>${board.name }</td>
                    <th>작성일</th>
                    <td>${board.regDate}</td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3"><pre><code>${board.content}</code></code></pre></td>
                </tr>
            </table>
            <span class="btn-group col-md-offset-9">
                    <a href="getList.do" class="btn btn-default">목록</a>
                    <a href="boardUpdate.do?id=${board.id}" class="btn btn-default">수정</a>
                    <a href="deleteBoard.do?id=${board.id}" class="btn btn-default">삭제</a>
                </span>
        </div>
    </div>
</body>
</html>