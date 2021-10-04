<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <!-- Styles -->
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,400;0,600;0,700;1,400&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/fontawesome-all.css" rel="stylesheet">
    <link href="css/swiper.css" rel="stylesheet">
	<link href="css/magnific-popup.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
</head>

<body data-spy="scroll" data-target=".fixed-top">
	<!-- Navigation -->
    <nav class="navbar navbar-expand-lg fixed-top navbar-dark">
        <div class="container">
        
        <!-- Image Logo -->
            <a class="navbar-brand logo-text page-scroll" href="Main.jsp">Gombibi</a> 
        
	        <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
	                <ul class="navbar-nav ml-auto">
	                    <li class="nav-item">
	                        <a class="nav-link page-scroll" href="Main.jsp">Main<span class="sr-only">(current)</span></a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link page-scroll" href="Login.jsp">Login</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link page-scroll" href="JoinForm.jsp">Register</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link page-scroll" href="BoardList.bd">Board</a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link page-scroll" href="#">Map</a>
	                    </li>
	                </ul>
	        </div>
	        <c:set var="id" value="${userid}"/> <!-- sessionScope 생략 -->
				<c:choose>
					<c:when test="${userid!=null}">
						<b>${userid}</b> 로그인 상태
						<a href='Logout.jsp'>[ 로그아웃 ]</a>
					</c:when>
					<c:otherwise>
						<b>로그인 하지 않으셨네요</b>
						<a href='Login.jsp'>[ 로그인 ]</a>
					</c:otherwise>
				</c:choose>
       	</div>

