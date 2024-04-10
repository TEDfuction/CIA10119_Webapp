<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cactus Activity Testing</title>
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
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
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
}

h3 {
	color: black;
	text-align: center;
	text-transform: uppercase;
	letter-spacing: 2px;
	margin-bottom: 20px;
	text-transform: uppercase;
	letter-spacing: 2px;
}

.error-msg {
	color: red;
	text-align: center;
	margin-bottom: 20px;
}

ul {
	list-style-type: none;
	padding: 0;
	margin: 0;
	text-align: center;
}

li {
	margin-bottom: 20px;
}

label {
	font-weight: bold;
	display: block;
	margin-bottom: 5px;
	color: #555;
}

input[type="text"], select {
	width: calc(100% - 22px);
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 5px;
	margin-bottom: 10px;
	box-sizing: border-box;
}

input[type="submit"], a.button {
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

input[type="submit"]:hover, a.button:hover {
	background-color: #007bff;
}
</style>
</head>
<body>
	<div class="container">
		<h3>---資料查詢 - selectpage.jsp---</h3>

		<c:if test="${not empty errorMsgs}">
			<div class="error-msg">
				<p>請修正以下錯誤:</p>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li>${message}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>

		<ul>
			<li><a href="<%=request.getContextPath()%>/listAllActivity.jsp"
				class="button">秀出所有資料</a></li>

			<form method="post" action="<%=request.getContextPath()%>/activity.do">
				<li><label>請輸入活動類別編號</label> 
				<input type="text" name="activityCategoryid" placeholder="輸入活動類別名稱..."></li>
				<li>
					<input type="hidden" name="action" value="findByPrimaryKey">
					<input type="submit" value="送出" class="button"> 
				</li>
			</form>
				
				
				
				<li><jsp:useBean id="actSvc" scope="page" class="com.activity.model.ActivityService" /> 
				
			<form method="post" action="<%=request.getContextPath()%>/activity.do">
				<label>請輸入活動類別編號</label>
			    <select size="1" name="activityCategoryid">
			    	<c:forEach var ="actVO" items="${actSvc.all}">
			        <option value="${actVO.activityCategoryid}">${actVO.activityCategoryid}
			        </c:forEach>
			        </select>
				</li>
				<li>
					<input type="hidden" name="action" value="findByPrimaryKey">
					<input type="submit" value="送出" class="button"> 
				</li>
			</form>
		</ul>

		<br> <br>

		<ul>
			<li><a href="<%=request.getContextPath()%>/addActivity.jsp"
				class="button">跳轉新增活動</a></li>
		</ul>
	</div>
</body>
</html>
