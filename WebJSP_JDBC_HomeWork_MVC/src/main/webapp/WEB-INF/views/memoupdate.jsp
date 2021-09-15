<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table {
	
		    font-family: arial, sans-serif;
		    border-collapse: collapse; /* 붕괴하다 , 무너지다 */
		    width: 100%;
		}
		
		th {
		    border: 1px solid #dddddd;
		    text-align: center;
		    padding: 8px;
		}
		td{
		    border: 1px solid #dddddd;
			text-align: left;
			padding: 8px;
		}
		tr:nth-child(even) {  /* even 짝수     odd 홀수 */
		    background-color: #dddddd;
		}
	</style>
	
</head>
<body>
<c:set var="memo" value="${requestScope.memoview}"></c:set>
<div align=center>
<hr color=green width=400><h2> Line Memo List </h2><hr color=green width=400>

 <form name="f" action="MemoUpdateRun.memo" method="get"> 
      <input type="hidden" value="${requestScope.memoview.id}" id="id"  name="id">  
 <table width="600" border="0" cellpadding="7" > 
        <tr align="center" bgcolor="gold" height="50"> 
            <td colspan="2"> 
                <font size="4" color="#0033CC" face="굴림체"> 
                <b> 
                   Servlet Memo
                </b> 
                </font> 
            </td> 
        </tr> 
        <tr> 
            <td width="25%" align="center" > 
                <b>ID</b> 
            </td> 
            <td>${requestScope.memoview.id}</td> 
        </tr>     
        <tr> 
            <td width="25%" align="center"> 
                <b>EMAIL</b> 
            </td> 
            <td> 
                <input type="text" size="40" id="email" name="email" maxlength="60" value="${requestScope.memoview.email}"> 
            </td> 
        </tr> 
        <tr> 
            <td width="25%" align="center"> 
                <b>MEMO</b> 
            </td> 
            <td> 
                <textarea name="memo" cols="50" class="box2">
                ${requestScope.memoview.content}
                </textarea> 
            </td> 
        </tr> 
        <tr bgcolor="gold"> 
            <td colspan="2" align="center" class="c2"> 
                <input type="submit" value="수정" id="update">
            </td> 
        </tr> 
     
    </table> 
    </form>
</div>

</body>
</html>