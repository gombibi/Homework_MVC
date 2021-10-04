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

</head>
<body data-spy="scroll" data-target=".fixed-top">>
	<c:set var="board" value="${requestScope.board}" />
	<c:set var="idx" value="${requestScope.idx}" />
	<c:set var="cpage" value="${requestScope.cp}" />
	<c:set var="pagesize" value="${requestScope.ps}" />
	<c:set var="replyList" value="${requestScope.replyList}" />
	<c:set var="userid" value="${userid}"/>
	
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
	                        <h3>게시판 글내용</h3>
				                <table width="80%" border="1">
									<tr>
										<td width="20%" align="center"><b> 글번호 </b></td>
										<td width="30%">${idx}</td>
										<td width="20%" align="center"><b>작성일</b></td>
										<td>${board.writedate}</td>
									</tr>
									<tr>
										<td width="20%" align="center"><b>글쓴이</b></td>
										<td width="30%">${board.writer}</td>
										<td width="20%" align="center"><b>조회수</b></td>
										<td>${board.readnum}</td>
									</tr>
									<tr>
										<td width="20%" align="center"><b>홈페이지</b></td>
										<td>${board.homepage}</td>
										<td width="20%" align="center"><b>첨부파일</b></td>
										<td>${board.filename}</td>
									</tr>
									<tr>
										<td width="20%" align="center"><b>제목</b></td>
										<td colspan="3">${board.subject}</td>
									</tr>
									<tr height="100">
										<td width="20%" align="center"><b>글내용</b></td>
										<td colspan="3">${fn:replace(board.content, newLineChar,"<br>")}</td>
									</tr>
									<tr>
										<c:choose>
											<c:when test="${userid=='admin' || userid==board.writer}">
											<td colspan="4" align="center">
											<a href="BoardList.bd?cp=${cpage}&ps=${pagesize}">목록가기</a> |
											<a href="BoardEdit.bd?idx=${idx}&cp=${cpage}&ps=${pagesize}">편집</a> |
											<a href="BoardDelete.bd?idx=${idx}&cp=${cpage}&ps=${pagesize}">삭제</a> |
											<a href="BoardRewrite.bd?idx=${idx}&cp=${cpage}&ps=${pagesize}&subject=${board.subject}">답글</a>
											</td>
											</c:when>
											<c:otherwise>
											<td colspan="2" align="center">
											<a href="BoardList.bd?cp=${cpage}&ps=${pagesize}">목록가기</a> |
											<a href="BoardRewrite.bd?idx=${idx}&cp=${cpage}&ps=${pagesize}&subject=${board.subject}">답글</a>
											</td>
											</c:otherwise>
										</c:choose>
									</tr>
								</table>
								<!--  꼬리글 달기 테이블 -->
								<form name="reply" action="ReplyOk.bd" method="POST">
										<!-- hidden 태그  값을 숨겨서 처리  -->
										<input type="hidden" name="idx" value="${idx}"> 
										<!-- hidden data -->
										<table width="80%" border="1">
											<tr>
												<th colspan="2">덧글 쓰기</th>
											</tr>
											<tr>
												<td align="left">작성자 : ${userid} 
													<input type="hidden" name="reply_writer" value="${userid}">
												 	<textarea name="reply_content" rows="2" cols="50"></textarea>
												</td>
															<td align="left">
																<input type="button" value="등록" onclick="reply_check()">
															</td>
											</tr>
										</table>
								</form>
								<!-- 유효성 체크	 -->
								<script type="text/javascript">
									function reply_check() {
										var frm = document.reply;
										if (frm.reply_content.value == "") {
													alert("리플 내용을 입력해주세요.");
											return false;
										}
									frm.submit();
									}
									
									<!--댓글 삭제 -->
									function reply_del(frm) {
										//글쓴이만 삭제하게 하고싶은데 어떻게하지?
										//alert("del");
										//var frm = document.replyDel;
										//alert(frm);
										//if (!(frm.reply_writer.value == userid)) {
										//	alert("글쓴이만 삭제가능");
										//	return false;
										//}
										frm.submit();
									}
								</script>
								<br>
								<!-- 꼬리글 목록 테이블 -->
								<c:if test="${not empty replyList}">
									<c:forEach var="reply" items="${replyList}">
										<table width="80%" border="1">
											<tr>
												<th colspan="2">REPLY LIST</th>
											</tr>
											<tr align="left">
												<td width="80%">
												[${reply.writer}] : ${reply.content}
												<br> 작성일:${reply.writedate}
												</td>
												<td width="20%">
												<form action="ReplyDeleteOk.bd" method="POST" name="replyDel">
													<input type="hidden" name="no" value="${reply.no}"> 
													<input type="hidden" name="idx" value="${idx}"> 
													<input type="button" value="삭제" onclick="reply_del(this.form)">
												</form>
												</td>
											</tr>
										</table>
									</c:forEach>
								</c:if>
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
