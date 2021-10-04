<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>   
 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
				<form action="MemberUpdateOk.me" method="post" name="updateForm" id="updateForm">
					<h3 style="text-align: center;">회원 정보</h3>
					<div>
						<c:set var="member" value="${requestScope.MemberUpdate}"></c:set>
						<table style="width: 400px;height: 100px;margin-left: auto;margin-right: auto;">
				  			 	<tr>
				  			 		<td style="width:100px">아이디</td>
				  			 		<td> 
				  			 			<input type="text" name="id" value="${member.id}" readonly>
				  			 		</td>  
				  			 	</tr>
				  			 	<tr>
				  			 		<td style="width:100px">비번</td>
				  			 		<td> 
				  			 			<input type="text"  value="${member.pwd}">
				  			 		</td> 
				  			 	</tr>
				  			 	<tr>
				  			 		<td style="width:100px">이름</td>
				  			 		<td> 
				  			 			<input type="text" name="name" value="${member.name}" style="background-color: yellow">
				  			 		</td> 
				  			 	</tr>
				  			 	<tr>
				  			 		<td style="width:100px">나이</td>
				  			 		<td> 
				  			 			<input type="text" name="age" value="${member.age}" style="background-color: yellow">
				  			 		</td>
				  			 	</tr>
				  			 	<tr>
				  			 		<td style="width:100px">성별</td>
				  			 		<td> 
								    	<input type="radio" name="gender" id="gender" value="남" 
								    		<c:if test="${member.gender eq '남'}">checked</c:if>> 
								    	<label for="gender">남자</label> 
								    	<input type="radio" name="gender" id="gender" value="여" 
								    	<c:if test="${member.gender eq '여'}">checked</c:if>>
								    	<label for="gender">여자</label>
				  			 		</td>
				  			 	</tr>
				  			 	<tr>
				  			 		<td style="width:100px">이메일</td>
				  			 		<td>
				  			 		<input type="text" name="email" value="${member.email}" style="background-color: yellow">
				  			 		</td>
				  			 	</tr>
				  			 	<tr>
					  			 	<td colspan="2">
									<input type="submit" value="수정하기">
									<a href="Memberlist.me">리스트이동</a>
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