<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<title>Insert title here</title>
	
	<!-- Styles -->
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,400;0,600;0,700;1,400&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/fontawesome-all.css" rel="stylesheet">
    <link href="css/swiper.css" rel="stylesheet">
	<link href="css/magnific-popup.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	
	<!-- Favicon  -->
    <link rel="icon" href="images/favicon.png">
	
	<style type="text/css">
	table {
		border: solid 2px black;
		border-collapse: collapse;
	}
	
	tr {
		border: solid 1px blue;
		background-color: white;
		color: black;
	}
	
	td {
		border: solid 1px red;
	}
	</style>
</head>
<body data-spy="scroll" data-target=".fixed-top">
	
	<table>
		<tr>
			<td colspan="2">
				<jsp:include page="/WEB-INF/views/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
		<!-- MAIN PAGE CONTENT -->
	    <div class="header">
	        <div class="ocean">
	            <div class="wave"></div>
	            <div class="wave"></div>
	        </div>
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-6">
	                    <div class="text-container">
	                    <c:set var="id" value="${userid}"/> <!-- sessionScope 생략 -->
							<c:choose>
								<c:when test="${id=='admin'}">
									<h1 class="h1-large">${id} 관리자님,<br> 안녕하세요 ^^<br></h1>
									<a class="btn-solid-lg page-scroll" href='Memberlist.me'>회원관리</a>
								</c:when>
								<c:when test="${id!=null}">
									<h1 class="h1-large">${id} 회원님,<br> 환영합니다♥<br></h1>
								</c:when>
								<c:otherwise>
									<h1 class="h1-large">사이트 방문을 환영합니다 ^^ <br></h1>
									<p class="p-large">회원가입 좀 하지 ...</p>
								</c:otherwise>
							</c:choose>
	                    </div> <!-- end of text-container -->
	                </div> <!-- end of col -->
	                <div class="col-lg-6">
	                    <div class="image-container">
	                        <img class="img-fluid" src="images/header-gem.svg" alt="alternative">
	                    </div> <!-- end of image-container -->
	                </div> <!-- end of col -->
	            </div> <!-- end of row -->
	        </div> <!-- end of container -->
	    </div> <!-- end of header -->
	    </tr>
	</table>
	
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/common/Bottom.jsp"></jsp:include>
	
</body>
</html>


