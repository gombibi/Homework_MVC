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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
		//id="message" 클릭하면 $.ajax 사용해서 
		//요청 @WebServlet("/MemoId")
		//http://192.168.0.3:8090/WebServlet_4_memo_mvc/MemoId
		//url:"MemoId"
		//"true" 사용가능
		//"false" 사용불가 다시입력 ...
		let idcheck = false;
		
		$('#message').click(function(){
			if($('#id').val() == ""){
				$('#idchecker').text("아이디를 입력해주세요.");
				$('#idchecker').css('color', '#f82a2aa3');
				$('#id').focus();
				idcheck = false;
				buttonlive();
			}else{
			   $.ajax(
				 {
					url:"LoginIdCheck.me",
					data:{id:$('#id').val()},
					dataType:"html",
					success:function(responsedata){
						$('#idchecker').html(responsedata);
						let data =responsedata.trim();
						 if(data == "true"){
							   $('#idchecker').text("사용가능한 아이디입니다.");
							   $('#idchecker').css('color', '#199894b3');
							   $('#pwd').focus();
							   idcheck = true;
						 }else{
							   $('#idchecker').text("사용중인 아이디입니다.");
							   $('#idchecker').css('color', '#f82a2aa3');
							   $('#id').val("");
							   $('#id').focus();
							   idcheck = false;
						  }
						   buttonlive();
					}
				 }	  
			  );
			}
		});
		
		
		// 제출버튼 활성화 함수
		function buttonlive() {

			if (idcheck) {
				$("#checkit").prop("disabled", false);
			} else {
				$("#checkit").prop("disabled", true);
			}
		}
		
	});
	
	 //jquery 로 간단하게 유효성 check 하기
	 $(function() {
	  	$('#joinForm').submit(function() {
		   //alert("가입");
		if ($('#id').val() == "") { // 아이디 검사
	    	alert('ID를 입력해 주세요.');
	    	$('#id').focus();
	    return false;
	   } else if ($('#pwd').val() == "") { // 비밀번호 검사
	    alert('PWD를 입력해 주세요.');
	    $('#pwd').focus();
	    return false;
	   }else if ($('#name').val() == "") { // 이름 검사
	    alert('name를 입력해 주세요.');
	    $('#name').focus();
	    return false;
	   }else if ($('#age').val() == "") { // 나이 검사
	    alert('age를 입력해 주세요.');
	    $('#age').focus();
	    return false;
	   }else if ($('#email').val() == "") { // 메일
	    alert('email를 입력해 주세요.');
	    $('#email').focus();
	    return false;
	   }
	   
	  });
	 });
	</script>

</head>
<body>
	<table
		style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2">
				<jsp:include page="/WEB-INF/views/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 700px">
				<form action="JoinOK.me" method="post" name="joinForm" id="joinForm">
					<h3 style="text-align: center;">회원가입</h3>
					<div>
						<table
							style="width: 400px; height: 200px; margin-left: auto; margin-right: auto;">
							<tr>
								<th>ID:</th>
								<td><input type="text" name="id" id="id">
								<input type="button" value="ID확인" id="message"></td>
							</tr>
							<tr>
								<th>ID체크:</th>
								<td colspan="2" id="idchecker"></th>
							</tr>
							<tr>
								<th>PWD:</th>
								<td><input type="password" name="pwd" id="pwd"></td>
							</tr>
							<tr>
								<th>Name:</th>
								<td><input type="text" name="name" id="name"></td>
							</tr>
							<tr>
								<th>age:</th>
								<td><input type="text" name="age" id="age" maxlength="3"></td>
							</tr>
							<tr>
								<th>Gender:</th>
								<td><input type="radio" name="gender" id="gender" value="여"
									checked>여자 <input type="radio" name="gender"
									id="gender" value="남">남자</td>
							</tr>
							<tr>
								<th>Email:</th>
								<td><input type="text" name="email" id="email"></td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" value="회원가입">
									<input type="reset" value="취소"></td>
							</tr>
						</table>

					</div>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<jsp:include page="/WEB-INF/views/common/Bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>