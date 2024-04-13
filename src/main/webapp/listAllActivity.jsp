<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.activity.model.*"%>

<%
ActivityService actSvc = new ActivityService();
List<ActivityVO> list = actSvc.getAll();
pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Members -- From listAllMember.jsp</title>
<style>
/* Custom font */
@import url(https://fonts.googleapis.com/css?family=Montserrat);

/* Basic reset */
* {
	margin: 0;
	padding: 0;
}

html {
	height: 100%;
	/* Image only BG fallback */
	/* Background = gradient + image pattern combo */
	background: linear-gradient(rgba(196, 102, 0, 0.6),
		rgba(155, 89, 182, 0.6));
}

body {
	font-family: 'Montserrat', sans-serif;
	margin: 0;
	padding: 0;
}

.container {
	width: 80%;
	margin: 0 auto;
	padding-top: 20px;
}

h3, h4 {
	color: black;
	text-align: center;
	text-transform: uppercase;
	letter-spacing: 2px;
	margin-bottom: 20px;
}

a {
	text-decoration: none;
	color: #007bff;
}

a:hover {
	text-decoration: underline;
}

table {
	width: 100%;
	border-collapse: collapse;
	background-color: #fff;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

th, td {
	padding: 12px 15px;
	text-align: center;
}

th {
	background-color: #007bff;
	color: #fff;
	text-transform: uppercase;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #ddd;
}

td:last-child {
	text-align: center;
}

form {
	margin: 0;
}
/* Container for the whole page */
.container {
	max-width: 800px;
	margin: 50px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
</style>
</head>

<body>

	<div class="container">
		<h3>---所有活動編號資料 - LISTALLACTIVITY.JSP---</h3>
		<h4>
			<a href="<%=request.getContextPath()%>/selectPage.jsp">回首頁</a>
		</h4>

		<table>
			<thead>
				<tr>
					<th>活動編號</th>
					<th>活動名稱</th>
					<th>活動資訊</th>
					<th>活動圖片</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="actVO" items="${list}">
					<tr>
						<td>${actVO.activityCategoryid}</td>
						<td>${actVO.activityCategoryname}</td>
						<td>${actVO.activityCategoryinfo}</td>
						    <c:if test="${actVO.activityCategorypic==null}">
					        <td>無圖片</td>
				            </c:if>
				            <c:if test="${actVO.activityCategorypic!=null}">
					        <td><img src="<%=request.getContextPath()%>/ShowPicServlet.do?activityCategoryid=${actVO.activityCategoryid}"></td>
				           </c:if>
						<td>
							<form method="post"action="<%=request.getContextPath()%>/activity.do">
								<input type="submit" value="修改"> <input type="hidden" 
								    name="activityCategoryid" value="${actVO.activityCategoryid}"> <input
									type="hidden" name="action" value="getOne_For_Update">
							</form>
						</td>
						<td>
			                <form METHOD="post" ACTION="<%=request.getContextPath()%>/activity.do">
			                <input type="submit" value="刪除">
			                <input type="hidden" name="activityCategoryid"  value="${actVO.activityCategoryid}">
			                <input type="hidden" name="action" value="delete">
			                </form>
			           </td>
			                
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
