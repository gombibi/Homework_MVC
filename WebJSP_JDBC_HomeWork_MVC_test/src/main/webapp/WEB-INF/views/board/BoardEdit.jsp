<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
	
	<script type="text/javascript">
		function editCheck() {
	
			if (!edit.email.value) {
				alert("이메일을 입력해야합니다.");
				edit.email.focus();
				return false;
			}
	
			if (!edit.subject.value) {
				alert("제목을 입력하세요");
				edit.subject.focus();
				return false;
			}
	
			if (!edit.content.value) {
				alert("글 내용을 입력하세요");
				edit.content.focus();
				return false;
			}
	
			document.edit.submit();
	
		}
	</script>
</head>
<body data-spy="scroll" data-target=".fixed-top">>
	<c:set var="idx" value="${requestScope.idx}" />
	<c:set var="board" value="${requestScope.board}" />
	
	<table>
		<tr>
			<td colspan="2">
				<jsp:include page="/WEB-INF/views/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
		<!-- CONTENT -->
	    <!-- Statement -->
	    <div id="statement" class="basic-1">
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-12">
	                    <div class="text-container" align="center">
	                        <h3>글수정</h3>
	                        	<!-- form 시작 -->
								<form name="edit" action="BoardEditOk.bd" method="POST">
				                <table width="80%" border="1">
									<tr>
										<td width="20%" align="center"><b> 글번호 </b></td>
										<td width="30%">${idx} <input type="hidden" name="idx" value="${idx}" ></td>
										<td width="20%" align="center"><b>작성일</b></td>
										<td>${board.writedate}</td>
									</tr>
									<tr>
										<td width="20%" align="center"><b>글쓴이</b></td>
										<td width="30%">${board.writer} <input type="hidden" name="writer" value="${board.writer}"> </td>
										<td width="20%" align="center"><b>홈페이지</b></td>
										<td><input type="text" name="homepage" value="${board.homepage}"></td>
									</tr>
									<tr>
										<td width="20%" align="center"><b>이메일</b></td>
										<td>
											<input type="text" name="email" value="${board.email}">
										</td>
									</tr>
									<tr>
										<td width="20%" align="center"><b>제목</b></td>
										<td colspan="3"><input type="text" name="subject" value="${board.subject}" size="40"></td>
									</tr>
									<tr height="100">
										<td width="20%" align="center"><b>글내용</b></td>
										<td colspan="3">
											<textarea rows="7" cols="50" name="content" class="ckeditor">
												${board.content}
											</textarea>
										</td>
									</tr>
									<tr>
										<td width="20%" align="center"><b>첨부파일</b></td>
										<td colspan="3">${board.filename} (${board.filesize}bytes)<br /> 
											<input type="file" name="filename">
										</td>
									</tr>
									<tr>
										<td colspan="4" align="center">
											<input type="button" value="수정하기" onclick="editCheck();"> 
											<input type="reset" value="다시쓰기">
										</td>
									</tr>
									<tr>
										<td colspan="4" align="center">
											<a href="BoardList.bd">목록</a>
										</td>
									</tr>
								</table>
								</form>
	                    </div> <!-- end of text-container -->
	                </div> <!-- end of col -->
	            </div> <!-- end of row -->
	        </div> <!-- end of container -->
	    </div> <!-- end of basic-1 -->
	    <!-- end of statement -->
		</tr>			
	</table>
	
	<jsp:include page="/WEB-INF/views/common/Bottom.jsp"></jsp:include>
	

</body>
</html>
