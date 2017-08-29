<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@include file="commons/top.jsp" %>
<script>
function joinCheck(f){
	if(f.id.value == ''){
		alert("아이디는 필수 입력값입니다.");
		return false;
	}
	if(f.pass.value == ''){
		alert("비밀번호는 필수 입력값입니다.");
		return false;
	}
}
</script>
</head>
<body>
    <%@include file="commons/navbar.jsp" %>
    <div class="container">
        <div class="col-md-4 col-md-offset-3">
            <c:choose>
            <c:when test="${not empty sessionScope.id }"> <!--로그인한 상태일때  -->
            <div class="page-header">
                <h1>개인 정보 수정</h1>
            </div>
            <form class="form-group row" action="update.do" method="post" onsubmit="return joinCheck(this)">
                <table class="table">
                	<tr>
                        <td>ID</td>
                        <td><input class="form-control" id="id" type="text" name="id" readonly="readonly" value="${id}"></td>
                    </tr>
                    <tr>
                        <td>PW</td>
                        <td><input class="form-control" id="pass" type="password" name="password"></td>
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
                            <input class="btn btn-default" type="submit" value="수정">
                            <a class="btn btn-default" href="home.html">취소</a>
                        </td>
                    </tr>
                </table>
            </form>
            </c:when>
            <c:otherwise>
            <div class="page-header">
                <h1>회원가입</h1>
            </div>
            <form class="form-group row" action="join.do" method="post" onsubmit="return joinCheck(this)">
                <table class="table">
                	<tr>
                        <td>ID</td>
                        <td><input class="form-control" id="id" type="text" name="id"></td>
                    </tr>
                    <tr>
                        <td>PW</td>
                        <td><input class="form-control" id="pass" type="password" name="password"></td>
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
            </c:otherwise>
            </c:choose>
            
        </div>
    </div>
</body>
</html>