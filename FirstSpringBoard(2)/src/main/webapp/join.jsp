<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</head>
<body>
    <%@include file="commons/navbar.jsp" %>
    <div class="container">
        <div class="col-md-4 col-md-offset-3">
            <div class="page-header">
                <h1>회원가입</h1>
            </div>
            <form class="form-group row" action="join.do" method="post">
                <table class="table">
                    <tr>
                        <td>ID</td>
                        <td><input class="form-control" type="text" name="id"></td>
                    </tr>
                    <tr>
                        <td>PW</td>
                        <td><input class="form-control" type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input class="form-control" type="email" name="email"></td>
                    </tr>
                    <tr>
                        <td>Tel</td>
                        <td><input class="form-control" type="text" name="tel"></td>
                    </tr>
                    <tr>
                        <td class="text-center" colspan="2">
                            <input class="btn btn-default" type="submit" value="가입">
                            <a class="btn btn-default" href="home.html">취소</a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>