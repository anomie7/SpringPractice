<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@include file="commons/top.jsp" %>
<script>
function loginCheck(f){
	if(f.id.value == ''){
		alert("아이디는 필수 입력값입니다.");
		return false;
	}
	if(f.password.value == ''){
		alert("비밀번호는 필수 입력값입니다.");
		return false;
	}
}
</script>
<style>
	.error{
		color: red;
	}
</style>
</head>
<body>
  <%@include file="commons/navbar.jsp" %>
    <div class="container">
        <div class="col-md-4 col-md-offset-3">
            <%-- <form class="form-group row" action="login.do" method="post" onsubmit="return loginCheck(this)"> --%>
            <form:form modelAttribute="user" cssClass="form-group row" action="loginProcess.do" onsubmit="return loginCheck(this)">
                <table class="table">
                    <tr class="text-center">
                        <td colspan="2">로그인</td>
                    </tr>
                    <tr>
                        <td>ID</td>
                        <td>
                       <!--  <input class="form-control" type="text" name="id" id="id"> -->
                        <form:input cssClass="form-control" path="id"/>
                        <form:errors cssClass="error" path="id"></form:errors>
                        </td>
                    </tr>
                    <tr>
                        <td>PW</td>
                        <td>
                        	<!-- <input class="form-control" type="password" name="password" id="pass"> -->
                        	<form:password cssClass="form-control" path="password"/>
                        	<form:errors cssClass="error" path="password"></form:errors>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center" colspan="2">
                            <input class="btn btn-default" type="submit" value="확인">
                            <a class="btn btn-default" href="home.html">취소</a>
                        </td>
                    </tr>
                </table>
            <%-- </form> --%>
            </form:form>
        </div>
    </div>
</body>

</html>