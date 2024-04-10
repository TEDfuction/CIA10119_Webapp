<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.activity.model.*"%>

<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
ActivityVO actVO = (ActivityVO) request.getAttribute("actVO");
%>
<%=actVO == null%>${actVO.activityCategoryid}<!-- line100 -->
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>活動資料新增 - addactivity.jsp</title>

<style>
/*custom font*/
@import url(https://fonts.googleapis.com/css?family=Montserrat);

/*basic reset*/
* {
	margin: 0;
	padding: 0;
}

html {
	height: 100%;
	/*Image only BG fallback*/
	/*background = gradient + image pattern combo*/
	background: linear-gradient(rgba(196, 102, 0, 0.6),
		rgba(155, 89, 182, 0.6));
}

body {
	font-family: montserrat, arial, verdana;
	margin: 0;
	padding: 0;
}

/* Container for the whole page */
.container {
	max-width: 800px;
	margin: 50px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	text-align: center;
	
}

/* Headings */
h3 {
	color: black;
	text-align: center;
	text-transform: uppercase;
	letter-spacing: 2px;
	margin-bottom: 20px;
}

h4 {
	text-align: center;
	margin-bottom: 20px;
}

a {
	text-decoration: none;
	color: #007bff;
}

a:hover {
	text-decoration: underline;
}

/* Table styles */
table {
	width: 100%;
	margin-top: 20px;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
	color: #333;
}

/* Form styles */
form {
	margin-top: 20px;
	text-align: center;
}

input[type="text"] {
	width: calc(100% - 22px);
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	margin: 5px 0;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #007bff;
	border: none;
	color: white;
	padding: 15px 30px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	cursor: pointer;
	border-radius: 5px;
	transition: background-color 0.3s ease;
}

input[type="submit"]:hover {
	background-color: #007bff;
}

.error-msg {
	color: red;
	text-align: center;
}
li::marker{
color: white;
}


</style>
</head>
<body>

	<div class="container">
		<h3>---活動資料新增 - addact.jsp---</h3>
		<h4>
			<a href="<%=request.getContextPath()%>/selectPage.jsp">回首頁</a>
			
		</h4>
		<%-- 錯誤訊息列表呈現處 --%>
		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>
				

		<form method="post" action="activity.do" enctype="multipart/form-data">
			<table>
				<tr>
					<th>活動類別名稱</th>
					<td><input type="text" name="activityCategoryname"
						value="<%=(actVO == null) ? "" : actVO.getActivityCategoryname()%>" /></td>
				</tr>
				<tr>
					<th>活動類別資訊</th>
					<td><input type="text" name="activityCategoryinfo"
						value="<%=(actVO == null) ? "" : actVO.getActivityCategoryinfo()%>" /></td>
				</tr>
			</table>
			<br> <input type="hidden" name="action" value="insert">
			<input type="submit" value="送出新增">
		</form>


	</div>
</body>
</html>
