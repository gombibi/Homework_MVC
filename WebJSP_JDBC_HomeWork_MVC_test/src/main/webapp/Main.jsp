<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
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
<body>
	<table
		style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2">
				<jsp:include page="/commonview/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px">
				<jsp:include page="/commonview/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<!-- MAIN PAGE CONTENT  -->
				<c:set var="id" value="${param.id}"/> <!-- sessionScope 생략 -->
				<c:choose>
					<c:when test="${id=='admin'}">
						${id} 관리자님, 안녕하세요 ^^<br>
						<a href='Memberlist.me'>회원관리</a>
					</c:when>
					<c:when test="${id!=null}">
						${id} 회원님, 환영합니다♥<br>
					</c:when>
					<c:otherwise>
						사이트 방문을 환영합니다 ^^ <br>회원가입 좀 하지 ...
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="commonview/Bottom.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>


