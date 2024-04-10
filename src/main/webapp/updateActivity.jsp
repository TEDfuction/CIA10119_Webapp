
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.activity.model.*"%>

<%
ActivityVO actVO = (ActivityVO) request.getAttribute("actVO");
%>
<%=actVO != null%>

<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<title>修改資料 - updateActivity.jsp</title>
</head>


<body>

<h3>---修改活動資料---</h3>
<br>

<%-- 錯誤訊息列表呈現處 --%>

<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>


<form method="post" action="<%=request.getContextPath()%>/activity.do" enctype="multipart/form-data">

<table>

<tr>
	<td>活動編號:<font color=red><b>*</b></font></td>
	<td><%=actVO.getActivityCategoryid()%></td>
</tr>

<tr>
	<td>活動名稱:<font color=red><b>*</b></font></td>
	<td><input type="text" name="activityCategoryname" value="<%=actVO.getActivityCategoryname()%>"></td>
</tr>

<tr>
	<td>活動資訊:<font color=red><b>*</b></font></td>
	<td><input type="text" name="activityCategoryinfo" value="<%=actVO.getActivityCategoryinfo()%>"></td>
</tr>




</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="activityCategoryid" value="<%=actVO.getActivityCategoryid()%>">
<input type="submit" value="送出修改">

</form>


</body>


</html>
