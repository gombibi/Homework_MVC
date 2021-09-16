<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    

<a href="Main.jsp">Main</a>&nbsp;&nbsp;&nbsp;||
<a href="Login.jsp">Login</a>&nbsp;&nbsp;&nbsp;||
<a href="JoinForm.jsp">Register</a>&nbsp;&nbsp;&nbsp;||
<a href="#">Intro</a>&nbsp;&nbsp;&nbsp;||
<a href="#">Intro</a>&nbsp;&nbsp;&nbsp;

<c:set var="id" value="${param.id}"/> <!-- sessionScope 생략 -->
	<c:choose>
		<c:when test="${id!=null}">
			<b>${param.id}</b> 로그인 상태
			<a href='Logout.jsp'>[ 로그아웃 ]</a>
		</c:when>
		<c:otherwise>
			<b>로그인 하지 않으셨네요</b>
			<a href='Login.jsp'>[ 로그인 ]</a>
		</c:otherwise>
	</c:choose>