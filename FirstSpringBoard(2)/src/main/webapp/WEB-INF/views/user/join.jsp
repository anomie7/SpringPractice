<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@include file="../commons/top.jsp" %>
<script>
function joinCheck(f){
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
    <%@include file="../commons/navbar.jsp" %>
    <div class="container">
        <div class="col-md-4 col-md-offset-3">
            <c:choose>
            <c:when test="${not empty sessionScope.id }"> <!--로그인한 상태일때  -->
            <div class="page-header">
                <h1>개인 정보 수정</h1>
            </div>
           <%--  <form class="form-group row" action="update.do" method="post" onsubmit="return joinCheck(this)"> --%>
            <form:form cssClass="form-group row" modelAttribute="user" action="update.do" onsubmit="return joinCheck(this)">
                <table class="table">
                	<tr>
                        <td>ID</td>
                        <td>
                        <input class="form-control" id="id" type="text" name="id" readonly="readonly" value="${id}">
                        <form:errors path="id" cssClass="error"></form:errors>
                        <%-- <form:input cssClass="form-control" path="id" readonly="readonly"/> --%>
                        </td>
                    </tr>
                    <tr>
                        <td>PW</td>
                        <td>
                        <input class="form-control" id="password" type="password" name="password">
                        <form:errors path="password" cssClass="error"></form:errors>
                       <%--  <form:password cssClass="form-control" path="password"/> --%>
                        </td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>
                        <input class="form-control" type="email" name="email">
                        <%-- <form:input cssClass="form-control" type="email" path="email"/> --%>
                        </td>
                    </tr>
                    <tr>
                        <td>Tel</td>
                        <td>
                        <input class="form-control" type="text" name="tel">
                        <%-- <form:input cssClass="form-control" path="tel"/> --%>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center" colspan="2">
                            <input class="btn btn-default" type="submit" value="수정">
                            <a class="btn btn-default" href="home.do">취소</a>
                        </td>
                    </tr>
                </table>
                </form:form>
            <%-- </form> --%>
            </c:when>
            <c:otherwise>
            <div class="page-header">
                <h1>회원가입</h1>
            </div>
               <form:form cssClass="form-group row" modelAttribute="user" action="joinProcess.do" onsubmit="return joinCheck(this)">
                <table class="table">
                	<tr>
                        <td>ID</td>
                        <td>
                        <%-- <input class="form-control" id="id" type="text" name="id" readonly="readonly" value="${id}"> --%>
                        <form:input cssClass="form-control" path="id"/> 
                        <form:errors path="id" cssClass="error"></form:errors>
                        </td>
                    </tr>
                    <tr>
                        <td>PW</td>
                        <td>
                        <!-- <input class="form-control" id="pass" type="password" name="password"> -->
                        <form:password cssClass="form-control" path="password" />
                        <form:errors path="password" cssClass="error"></form:errors>
                        </td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>
                        <!-- <input class="form-control" type="email" name="email"> -->
                        <form:input class="form-control" type="email" path="email"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Tel</td>
                        <td>
                        <!-- <input class="form-control" type="text" name="tel"> -->
                        <form:input cssClass="form-control" path="tel"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center" colspan="2">
                            <input class="btn btn-default" type="submit" value="가입">
                            <a class="btn btn-default" href="home.do">취소</a>
                        </td>
                    </tr>
                </table>
                </form:form>
            </c:otherwise>
            </c:choose>
        </div>
    </div>
</body>
</html>