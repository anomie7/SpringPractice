<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="commons/top.jsp" %>
</head>
<body>
  <%@include file="commons/navbar.jsp" %>
    <div class="container">
        <div class="col-md-4 col-md-offset-3">
            <form class="form-group row" action="login.do" method="post">
                <table class="table">
                    <tr class="text-center">
                        <td colspan="2">로그인</td>
                    </tr>
                    <tr>
                        <td>ID</td>
                        <td><input class="form-control" type="text" name="id"></td>
                    </tr>
                    <tr>
                        <td>PW</td>
                        <td><input class="form-control" type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td class="text-center" colspan="2">
                            <input class="btn btn-default" type="submit" value="확인">
                            <a class="btn btn-default" href="home.html">취소</a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>

</html>