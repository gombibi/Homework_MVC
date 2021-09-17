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
			
			<c:set var="searchlist" value="${requestScope.searchlist}"></c:set>
				<div align=center>
				<table style="width: 400px;height: 100px;margin-left: auto;margin-right: auto">
					<tr><th colspan="4">회원 리스트</th></tr> 
					<tr>
						<th>ID</th> 
						<th>이름</th>
						<th>Email</th>
					</tr>
					<c:forEach var="member" items="${searchlist}">
						<tr>
							<td width="100px">${member.id}</td>
							<td width="100px">${member.name}</td>
							<td width="100px">${member.email}</td>
						</tr>
					</c:forEach>
				</table>
				</div>	
					<hr>
						<form action="MemberSearch.me" method="post">
							회원명:<input type="text" name="search">
							<input type="submit" value="이름검색하기">
						</form>
					<hr>					
			</td>
		</tr>
	</table>

</body>
</html>
