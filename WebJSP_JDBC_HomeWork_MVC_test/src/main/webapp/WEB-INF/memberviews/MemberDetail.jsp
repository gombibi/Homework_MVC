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
				<form action="MemberDetail.me" method="post" name="detailForm" id="detailForm">
					<h3 style="text-align: center;">회원 정보</h3>
					<div>
						<c:set var="MemberDatail" value="${requestScope.MemberDatail}"></c:set>
						<table style="width: 400px;height: 100px;margin-left: auto;margin-right: auto;">
				  			 	<tr>
				  			 		<td style="width:100px">아이디</td>
				  			 		<td style="width:100px">${MemberDatail.id}</td>
				  			 	</tr>
				  			 	<tr>
				  			 		<td style="width:100px">비번</td>
				  			 		<td style="width:100px">${MemberDatail.pwd}</td>
				  			 	</tr>
				  			 	<tr>
				  			 		<td style="width:100px">이름</td>
				  			 		<td style="width:100px">${MemberDatail.name}</td>
				  			 	</tr>
				  			 	<tr>
				  			 		<td style="width:100px">나이</td>
				  			 		<td style="width:100px">${MemberDatail.age}</td>
				  			 	</tr>
				  			 	<tr>
				  			 		<td style="width:100px">성별</td>
				  			 		<td style="width:100px">${MemberDatail.gender}</td>
				  			 	</tr>
				  			 	<tr>
				  			 		<td style="width:100px">이메일</td>
				  			 		<td style="width:100px">${MemberDatail.email}</td>
				  			 	</tr>
				  			 	<tr>
				  			 		<td colspan="2">
				  			 			<a href="Memberlist.me">목록가기</a>
				  			 		</td>
				  			 	</tr>
				  			 </table>
					</div>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<jsp:include page="/commonview/Bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>