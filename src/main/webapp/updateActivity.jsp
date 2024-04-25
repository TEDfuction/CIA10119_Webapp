
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ page import="com.activity.model.*"%> --%>
<%@ page import="com.activity.itemmodel.*"%>

<%
// ActivityVO actVO = (ActivityVO) request.getAttribute("actVO");
ActivityItemVO aitVO = (ActivityItemVO) request.getAttribute("aitVO");
%>
<%-- <%=actVO != null%> --%>
<%=aitVO != null%>

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


<form method="post" action="<%=request.getContextPath()%>/activityItem.do" enctype="multipart/form-data">

<table>

<!-- <tr> -->
<!-- 	<td>活動編號:<font color=red><b>*</b></font></td> -->
<%-- 	<td><%=actVO.getActivityCategoryid()%></td> --%>
<!-- </tr> -->

<!-- <tr> -->
<!-- 	<td>活動名稱:<font color=red><b>*</b></font></td> -->
<%-- 	<td><input type="text" name="activityCategoryname" value="<%=actVO.getActivityCategoryname()%>"></td> --%>
<!-- </tr> -->

<!-- <tr> -->
<!-- 	<td>活動資訊:<font color=red><b>*</b></font></td> -->
<%-- 	<td><input type="text" name="activityCategoryinfo" value="<%=actVO.getActivityCategoryinfo()%>"></td> --%>
<!-- </tr> -->

<!-- <tr> -->
<!-- 	<td>活動圖片:</td> -->
<!-- 	<td><input type="file" name="activityCategorypic"></td> -->
<!-- </tr> -->





			
			
			


<tr>
	<td>活動項目編號:<font color=red><b>*</b></font></td>
	<td><%=aitVO.getActivityItemid()%></td>
</tr>

<tr>
	<td>活動項目名稱:<font color=red><b>*</b></font></td>
	<td><input type="text" name="activityItemname" value="<%=aitVO.getActivityItemname()%>"></td>
</tr>

<tr>
	<td>活動項目簡述:<font color=red><b>*</b></font></td>
	<td><input type="text" name="activityItemdescription" value="<%=aitVO.getActivityItemdescription()%>"></td>
</tr>

<tr>
	<td>活動項目資訊:<font color=red><b>*</b></font></td>
	<td><input type="text" name="activityIteminfo" value="<%=aitVO.getActivityIteminfo()%>"></td>
<!-- 	<td><input type="file" name="activityCategorypic"></td> -->
</tr>

<tr>
	<td>活動項目價格:<font color=red><b>*</b></font></td>
	<td><input type="text" name="activityItemprice" value="<%=aitVO.getActivityItemprice()%>"></td>
<!-- 	<td><input type="file" name="activityCategorypic"></td> -->
</tr>

<tr>
	<td>活動項目狀態:<font color=red><b>*</b></font></td>
	 <td><select id="activityItemstate"name="activityItemstate">
				    <option value="true"
					<%=aitVO != null && aitVO.getActivityItemstate() ? " selected" : ""%>>上架</option>
				    <option value="false"
					<%=aitVO != null && !aitVO.getActivityItemstate() ? " selected" : ""%>>下架</option></td>
			       </select>
<!-- 	<td><input type="file" name="activityCategorypic"></td> -->
</tr>
<tr>
	<td>活動類別編號:<font color=red><b>*</b></font></td>
	<td><input type="text" name="activityCategoryid"
 		value="<%= ((request.getParameter("activtiyCategoryid") == null) ? "" : request.getParameter("activtiyCategoryid")) %>" /></td> 
</tr>




</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="activityItemid" value="<%=aitVO.getActivityItemid()%>">
<input type="submit" value="送出修改">

</form>


</body>


</html>
