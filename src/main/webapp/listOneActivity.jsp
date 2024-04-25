<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ page import="com.activity.model.*"%> --%>
<%@ page import="com.activity.itemmodel.*"%>

<%
// 	ActivityVO actVO = (ActivityVO)request.getAttribute("actVO");
    ActivityItemVO aitVO = (ActivityItemVO)request.getAttribute("aitVO");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>One Member -- From listOneMember.jsp</title>
    <style>
        /* Custom font */
        @import url(https://fonts.googleapis.com/css?family=Montserrat);

        /* Basic reset */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Montserrat', sans-serif;
            background-color: #f2f2f2;
        }

        h3, h4 {
            text-align: center;
            margin-top: 20px;
            margin-bottom: 10px;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            text-decoration: underline;
        }

        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        th, td {
            padding: 12px 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
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

        .no-image {
            font-style: italic;
            color: #888;
        }

        .image-cell img {
            max-width: 100px;
            max-height: 100px;
            display: block;
            margin: 0 auto;
        }
    </style>
</head>
<body>

<h3>---搜尋的活動資料結果---</h3>
<br>
<h4><a href="<%=request.getContextPath()%>/selectPage.jsp">回首頁</a></h4>
<br>

<table>
    <tr>
        <th>活動項目編號</th>
        <th>活動項目名稱</th>
        <th>活動項目簡述</th>
        <th>活動項目資訊</th>
        <th>活動項目價格</th>
        <th>活動項目狀態</th>
        <th>活動類別編號</th>
        <th>活動類別照片</th>
    </tr>

    <tr>
        <td>${aitVO.activityItemid}</td>
        <td>${aitVO.activityItemname}</td>
        <td>${aitVO.activityItemdescription}</td>
        <td>${aitVO.activityIteminfo}</td>
        <td>${aitVO.activityItemprice}</td>
        <td>${aitVO.activityItemstate}</td>
        <td>${aitVO.activityCategory.activityCategoryid}</td>

        <c:choose>
            <c:when test="${aitVO.activityCategory.activityCategorypic == null}">
                <td class="no-image">無圖片</td>
            </c:when>
            <c:otherwise>
                <td class="image-cell"><img src="<%=request.getContextPath()%>/ShowPicServlet.do?activityCategoryid=${aitVO.activityCategory.activityCategoryid}" alt="活動類別照片"></td>
            </c:otherwise>
        </c:choose>
    </tr>
</table>
</body>
</html>