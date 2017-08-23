<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="col-md-7 col-md-offset-2">
            <div class="page-hearder" style="padding-bottom: 20px;">
                <h1>글쓰기 화면</h1>
            </div>
            <div>
                <form class="form-group" action="updateProcess.do" method="post">
                <table class="table table-striped row">
                    <tr>
                        <th class="col-md-2">작성자</th>
                        <td>${board.name}</td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td><input class="form-control" type="text" name="subject" value="${board.subject}"></td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td><textarea class="form-control" name="content" rows="10" cols="">
                        ${board.content}
                        </textarea></td>
                    </tr>
                    <tr>
                        <th>암호</th>
                        <td><input class="form-control" type="password" name="password" value="${board.password}">
                        	<input type="hidden" name="id" value="${board.id}">
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center" colspan="2"><input class="btn btn-primary" type="submit" value="수정"></td>
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