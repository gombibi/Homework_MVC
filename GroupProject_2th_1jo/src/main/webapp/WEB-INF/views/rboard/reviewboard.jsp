<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<!-- META DATA -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<!--font-family-->
<link href="https://fonts.googleapis.com/css?family=Rufina:400,700"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900"
	rel="stylesheet" />
<!-- TITLE OF SITE -->
<title>Travel</title>
<!-- favicon img -->
<link rel="shortcut icon" type="image/icon" href="logo/favicon.png" />
<!--font-awesome.min.css-->
<link rel="stylesheet" href="css/font-awesome.min.css" />
<!--animate.css-->
<link rel="stylesheet" href="css/animate.css" />
<!--hover.css-->
<link rel="stylesheet" href="css/hover-min.css">
<!-- range css-->
<link rel="stylesheet" href="css/jquery-ui.min.css" />
<!--bootstrap.min.css-->
<link rel="stylesheet" href="css/bootstrap.min.css" />
<!-- bootsnav -->
<link rel="stylesheet" href="css/bootsnav.css" />
<!--style.css-->
<link rel="stylesheet" href="css/style.css" />
<!--responsive.css-->
<link rel="stylesheet" href="css/responsive.css" />
<!--reviewboard.css-->
<link rel="stylesheet" href="css/reviewboard.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

<link
	href="https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100,300,400,500,700,900"
	rel="stylesheet" />
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap')
	;
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script type="text/javascript" type="text/css">
	$(document).ready(function() {
		
		/* 비동기식 글 내용 보기 */
		$('.clickmnic').on("click", function() {
			let clickrbnum = $(this).attr("id");
			let clickmnick = $(this).next().text();
			
			let form_data ={rbnum:$(this).attr("id")};
			
			if($('#'+clickrbnum+clickmnick).html()==""){
				
				$.ajax(
						{
							url:"ReviewBoardContent.bd",
							type:"POST",
							dataType:"html",
							data:form_data,
							success:function(responsedata){
								let result = responsedata.trim();

								$('#'+clickrbnum+clickmnick).html("<form id='editgo' action='ReviewBoardEdit.bd' method='post'></form>"
										+"<td colspan='1' id='reviewboard_body_update'>"
										+"<input form='editgo' type='hidden' name='rbnum' value='"+clickrbnum+"'>"
										+"<input form='editgo' type='hidden' name='mnic' value='"+clickmnick+"'>"
										+"<input form='editgo' type='hidden' name='cpage' value='${cpage}'>"
										+"</td>"
										+"<td colspan='2' id='reviewboard_body_rbcont' style='background-color: #ddf0ef;' align='left'>"
										+responsedata+"</td>"
										+"<td colspan='2' id='reviewboard_body_rbcont' align='center'>"
										+"<input form='editgo' type='submit' value='수정'>"
										+"<form id='delgo' action='ReviewBoardDelete.bd' method='post'></form>"
										+"<input form='delgo' type='submit' value='삭제'>"
										+"<input form='delgo' type='hidden' name='rbnum' value='"+clickrbnum+"'>"
										+"<form id='rego' action='ReviewBoardDelete.bd' method='post'></form>"
										+"<input form='rego' type='button' value='답글'>"
										+"</td>");

							},
							error:function(xhr){
								console.log(xhr.status);
							}
							}		 
					 );
				
			}else{
				
				$('#'+clickrbnum+clickmnick).html("");
				
			}
			 
			
		});

	});
</script>

</head>

<body>
	<c:set var="pagesize" value="${requestScope.pagesize}"></c:set>
	<c:set var="cpage" value="${requestScope.cpage}"></c:set>
	<c:set var="pagecount" value="${requestScope.pagecount}"></c:set>
	<c:set var="list" value="${requestScope.list}"></c:set>
	<c:set var="totalboardcount" value="${requestScope.totalboardcount}"></c:set>
	<c:set var="pager" value="${requestScope.pager}"></c:set>
	<c:set var="login" value="${sessionScope.userid}" />
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div id="reveiwBoardListContainer">
		<h1>리뷰 게시판</h1>
		<h3>리뷰를 써주세요 어쩌구</h3>
		<div style="text-align: center">
			<table id="reviewboard" align="center">
				<tr id="review_write_btn">
					<td colspan="4" align="center"></td>
					<td colspan="1" align="center">총 게시물 수 : ${totalboardcount}</td>
				</tr>
				<tr id="reviewboard_header">
					<td width="10%">글번호</td>
					<td>리뷰</td>
					<td width="15%">닉네임</td>
					<td width="15%">평가</td>
					<td width="15%">작성일</td>
				</tr>
				<!-- 데이터가 한건도 없는 경우  -->

				<!-- forEach()  목록 출력하기  -->
				<c:forEach var="board" items="${list}">
					<tr id="reviewboard_body">
						<td align="center">${board.rbnum}</td>
						<td align="left" class="clickmnic" id="${board.rbnum}"><c:forEach
								var="i" begin="1" end="${board.depth}" step="1">
									&nbsp;&nbsp;&nbsp;
								</c:forEach> <c:if test="${board.depth > 0}">
								<img src="">
								<!-- 들여쓰기아이콘넣기 -->
							</c:if> ${board.rbsubj}</td>
						<td align="center">${board.mnic}</td>
						<td align="center"><c:if test="${board.point == 5}"> 💙💙💙💙💙 </c:if>
							<c:if test="${board.point == 4}"> 💙💙💙💙🤍 </c:if> <c:if
								test="${board.point == 3}"> 💙💙💙🤍🤍 </c:if> <c:if
								test="${board.point == 2}"> 💙💙🤍🤍🤍 </c:if> <c:if
								test="${board.point == 1}"> 💙🤍🤍🤍🤍 </c:if></td>
						<td align="center">${board.rbdate}</td>
					</tr>
					<tr id="${board.rbnum}${board.mnic}"></tr>
				</c:forEach>


				<tr id="review_write_btn">
					<td colspan="5" align="center">${pager}</td>
				</tr>
				<tr id="review_write_btn">
					<td colspan="4"></td>
					<td colspan="1" align="center">
						<button type="submit" class="about-view packages-btn"
							onclick="location.href = 'ReviewBoardWrite.bd';">글쓰기</button>
					</td>
				</tr>
			</table>
		</div>
	</div>



</body>
</html>