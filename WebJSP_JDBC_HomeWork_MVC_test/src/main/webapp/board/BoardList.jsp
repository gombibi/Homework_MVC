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
			
			<c:set var="Boardlist" value="${requestScope.Boardlist}"></c:set>
				<div align=center>
				<table style="width: 400px;height: 100px;margin-left: auto;margin-right: auto">
					<tr><th colspan="4">일반 게시판</th></tr> 
					<tr>
						<th>NO</th> 
						<th>제목</th>
						<th>글쓴이</th>
						<th>날짜</th>
					</tr>
					<c:forEach var="Board" items="${Boardlist}">
						<tr>
							<td width="100px">${Board.idx}</td>
							<td width="100px">${Board.subject}</a></td>
							<td width="100px">${Board.writer}</td>
							<td width="100px">${Board.writedate}</td>
						</tr>
					</c:forEach>
				</table>
				</div>	
										
			</td>
		</tr>
	</table>

</body>
</html>
