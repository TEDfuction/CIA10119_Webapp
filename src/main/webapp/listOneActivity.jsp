<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.activity.model.*"%>


<%
	ActivityVO actVO = (ActivityVO)request.getAttribute("actVO");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>One Member -- From listOneMember.jsp</title>
</head>


<body>

<h3>---搜尋的會員資料結果---</h3>
<br>
<h4><a href="<%=request.getContextPath()%>/selectPage.jsp">回首頁</a></h4>
<br>

<table>
	<tr>
		<th>活動編號</th>
		<th>活動名稱</th>
		<th>活動資訊</th>
		
	</tr>
	
	<tr>
			<td>${actVO.activityCategoryid}</td>
			<td>${actVO.activityCategoryname}</td>
			<td>${actVO.activityCategoryinfo}</td>
			
		
		</tr>
	
	
</table>
</body>
</html>