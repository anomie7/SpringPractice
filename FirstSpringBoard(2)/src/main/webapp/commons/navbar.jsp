<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="home.do" class="navbar-brand">FirstSpring Project</a>
                </div>
                <ul class="nav navbar-nav">
                <c:choose>
                <c:when test="${not empty sessionScope.id }">
                    <li><a href="logout.do">로그아웃</a></li>
                    <li><a href="#">개인 정보 수정</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="login.jsp">로그인</a></li>
                    <li><a href="join.jsp">회원가입</a></li>
                </c:otherwise>
                </c:choose>
                    <li><a href="getList.do">게시판</a></li>
                </ul>
            </div>
        </nav>