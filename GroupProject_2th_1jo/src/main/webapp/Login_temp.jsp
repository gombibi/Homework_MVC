<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<tr>
		<td style="width: 700px">
			<form action="LoginOK.me" method="post" name="loginForm" id="loginForm">
				<h3 style="text-align: center;">Login Page</h3>
				<div>
					<table style="width: 400px; height: 100px; margin-left: auto; margin-right: auto;">
						<tr>
							<th>ID(email):</th>
							<td><input type="text" name="email" id="email"></td>
						</tr>
						<tr>
							<th>Password</th>
							<td><input type="password" name="mpwd" id="mpwd"></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="로그인"> 
							<input type="reset" value="취소"></td>
						</tr>
					</table>

				</div>
			</form>
		</td>
	</tr>

</body>
</html>