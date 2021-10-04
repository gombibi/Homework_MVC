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
			
			<c:set var="Memberlist" value="${requestScope.Memberlist}"></c:set>
				<div align=center>
				<table style="width: 400px;height: 100px;margin-left: auto;margin-right: auto">
					<tr><th colspan="4">회원 리스트</th></tr> 
					<tr>
						<th>ID</th> 
						<th>IP</th>
						<th>삭제</th>
						<th>수정</th>
					</tr>
					<c:forEach var="Member" items="${Memberlist}">
						<tr>
							<td width="100px"><a href="MemberDetail.me?id=${Member.id}">${Member.id}</a></td>
							<td width="100px"><a href="MemberDetail.me?id=${Member.id}">${Member.ip}</a></td>
							<td width="100px"><a href="MemberDelete.me?id=${Member.id}">[삭제]</a></td>
							<td width="100px"><a href="MemberUpdate.me?id=${Member.id}">[수정]</a></td>
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
