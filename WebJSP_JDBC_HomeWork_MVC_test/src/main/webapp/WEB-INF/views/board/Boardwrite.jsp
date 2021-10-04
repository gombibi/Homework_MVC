<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 

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
	
	<SCRIPT type="text/javascript">
	function check(){
	    if(!bbs.subject.value){
	        alert("제목을 입력하세요");
	        bbs.subject.focus();
	        return false;
	    }
	    if(!bbs.writer.value){
	        
	        alert("이름을 입력하세요");
	        bbs.writer.focus();
	        return false;
	    }
	    if(!bbs.content.value){            
	        alert("글 내용을 입력하세요");
	        bbs.content.focus();
	        return false;
	    }	 
	    document.bbs.submit();
	 
	}
	</SCRIPT>

</head>
<body data-spy="scroll" data-target=".fixed-top">>
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
	                        <h3>게시글 작성</h3>
	                        <!-- form 시작 ---------->
				            <form name="bbs" action="BoardWriteOk.bd" method="POST">
				            	<c:set var="id" value="${userid}"/>
				                <table width="95%" border="2" align="center">
				                    <tr>
				                        <td width="20%" align="center">제목</td>
				                        <td width="80%" align="left"><input type="text"  name="subject" size="40"></td>
				                    </tr>
				                    <tr>
				                        <td width="20%" align="center">글쓴이</td>
				                        <td width="80%" align="left"><input type="text" name="writer" size="40" value="${userid}" readonly></td>
				                    </tr>
				                    <tr>
				                        <td width="20%" align="center">이메일</td>
				                        <td width="80%" align="left"><input type="text" name="email" size="40"></td>
				                    </tr>
				                    <tr>
				                        <td width="20%" align="center">홈페이지</td>
				                        <td width="80%" align="left"><input type="text" name="homepage" size="40" value="http://"></td>
				                    </tr>
				                    <tr>
				                        <td width="20%" align="center">글내용</td>
				                        <td width="80%" align="left"><textarea rows="10" cols="60" name="content" class="ckeditor"></textarea></td>
				                    </tr>
				                    <tr>
				                        <td width="20%" align="center">첨부파일</td>
				                        <td width="80%" align="left"><input type="file" name="filename"></td>
				                    </tr>
				                    <tr>
				                        <td colspan="2" align="center">
				                            <input type="button" value="글쓰기" onclick="check();" /> 
				                            <input type="reset"  value="다시쓰기" />
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
		<tr>
			<td colspan="2">
				<jsp:include page="/WEB-INF/views/common/Bottom.jsp"></jsp:include>
			</td>
		</tr>
			
	</table>

</body>
</html>
