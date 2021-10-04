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
<body data-spy="scroll" data-target=".fixed-top">
	<c:set var="pagesize" value="${requestScope.pagesize}" />
	<c:set var="cpage" value="${requestScope.cpage}" />
	<c:set var="pagecount" value="${requestScope.pagecount}" />
	<c:set var="Boardlist" value="${requestScope.Boardlist}" />
	<c:set var="totalboardcount" value="${requestScope.totalboardcount}" />
	<c:set var="pager" value="${requestScope.pager}" />
	
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
	                        <h3>일반 게시판</h3>
							<table class="table">
								<tr>
									<td colspan="5">
										<!--  
											form 태그 action 전송 주소(목적지) >> submit()
											>> form name="list" ... action 없다면.. 
											>> [현재 URL 창에 있는 주소] 그대로  .....   
											>> board_list.jsp?ps=select 태그 값으로 .... 다시 호출 .....
											>>http://192.168.0.169:8090/WebServlet_5_Board_Model1_Sample/board/board_list.jsp?ps=10					
										-->
										<form name="list" >
										 PageSize: 
											<select name="ps" onchange="submit()">
											   <c:forEach var="i" begin="5" end="20" step="5">
											   		<c:choose>
											   			<c:when test="${pagesize == i}">
											   				<option value="${i}" selected>${i}건</option>
											   			</c:when>
										   				<c:otherwise>
										   					<option value="${i}">${i}건 </option>
										   				</c:otherwise>
											   		</c:choose>
											   </c:forEach>
						   					</select>
										</form>
									</td>
								</tr>
								<tr>
									<th width="10%">NO</th> 
									<th width="40%">제목</th>
									<th width="20%">글쓴이</th>
									<th width="20%">날짜</th>
									<th width="10%">조회수</th>
								</tr>
								<c:forEach var="board" items="${Boardlist}">
									<tr onmouseover="this.style.backgroundColor='gray'" onmouseout="this.style.backgroundColor='white'">
										<td align="center">${board.idx}</td>
										<td align="left">
											<c:forEach var="i" begin="1" end="${board.depth}" step="1">
												&nbsp;&nbsp;&nbsp;
											</c:forEach>
											<c:if test="${board.depth > 0}">
												<img src="${pageContext.request.contextPath}/images/re.gif">
											</c:if>
											 
											<a href="BoardContent.bd?idx=${board.idx}&cp=${cpage}&ps=${pagesize}">
												<c:choose>
													<c:when test="${board.subject != null && fn:length(board.subject) > 10}">
														${fn:substring(board.subject,0,10)}...
													</c:when>
													<c:otherwise>
														${board.subject}
													</c:otherwise>
												</c:choose>
											</a>
										</td>
										<td>${board.writer}</td>
										<td>${board.writedate}</td>
										<td>${board.readnum}</td>
									</tr>

								</c:forEach>
								
							<tr>
								<td colspan="3" align="center">
								<!--  
								원칙적인 방법 아래 처럼 구현
								[1][2][3][다음]
								[이전][4][5][6][다음]
								[이전][7][8][9][다음]
								[이전][10][11]
								
								현재 아래 코드 [][][][][][][]...
								-->
								
									<!--이전 링크 --> 
									<c:if test="${cpage > 1}">
										<a href="BoardList.bd?cp=${cpage-1}&ps=${pagesize}">이전</a>
									</c:if>
									<!-- page 목록 나열하기 -->
									<c:forEach var="i" begin="1" end="${pagecount}" step="1">
										<c:choose>
											<c:when test="${cpage==i}">
													<font color="red" >[${i}]</font>
											</c:when>
											<c:otherwise>
												<a href="BoardList.bd?cp=${i}&ps=${pagesize}">[${i}]</a>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<!--다음 링크 --> 
									<c:if test="${cpage < pagecount}">
										<a href="BoardList.bd?cp=${cpage+1}&ps=${pagesize}">다음</a>
									</c:if>
								</td>
								<td colspan="2" align="center">총 게시물 수 : ${totalboardcount} <br>
								</td>
							</tr>
							
							<tr>
					  			 <td colspan="5">
					  			 <a href="BoardWrite.bd">글쓰기</a>
					  			 </td>
					  		</tr>
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
