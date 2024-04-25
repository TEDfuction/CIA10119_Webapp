<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%-- <%@ page import="com.activity.model.*"%> --%>
<%@ page import="com.activity.itemmodel.*"%>

<%
// ActivityService actSvc = new ActivityService();
// List<ActivityVO> list = actSvc.getAll();
// pageContext.setAttribute("list", list);
 ActivityItemService aitSvc = new ActivityItemService ();
 List<ActivityItemVO> list = aitSvc.getAll();
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
            box-sizing: border-box;
        }

        html, body {
            height: 100%;
            background: linear-gradient(rgba(196, 102, 0, 0.6), rgba(155, 89, 182, 0.6));
            font-family: 'Montserrat', sans-serif;
        }

        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h3, h4 {
            text-align: center;
            text-transform: uppercase;
            letter-spacing: 2px;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
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

        form {
            margin: 0;
            display: inline-block;
        }

        form input[type="submit"] {
            border: none;
            background: none;
            color: #007bff;
            cursor: pointer;
        }

        form input[type="submit"]:hover {
            text-decoration: underline;
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

<div class="container">
    <h3>---所有活動編號資料 - LISTALLACTIVITY.JSP---</h3>
    <h4>
        <a href="<%=request.getContextPath()%>/selectPage.jsp" style="text-decoration: none;">回首頁</a>
    </h4>
    
    <table>
        <thead>
        <tr>
            <th>活動項目編號</th>
            <th>活動項目名稱</th>
            <th>活動項目簡述</th>
            <th>活動項目資訊</th>
            <th>活動項目價格</th>
            <th>活動項目狀態</th>
            <th>活動類別編號</th>
            <th>活動類別照片</th>
            <th colspan="2">操作</th>
        </tr>
        </thead>
        <tbody>
        <%@ include file="page1.file" %> 
        <c:forEach var="aitVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
            <tr>
                <td>${aitVO.activityItemid}</td>
                <td>${aitVO.activityItemname}</td>
                <td>${aitVO.activityItemdescription}</td>
                <td>${aitVO.activityIteminfo}</td>
                <td>${aitVO.activityItemprice}</td>
                <td>${aitVO.activityItemstate}</td>
                <td>${aitVO.activityCategory.activityCategoryid}</td>
                <td class="image-cell">
                    <c:choose>
                        <c:when test="${aitVO.activityCategory.activityCategorypic == null}">
                            無圖片
                        </c:when>
                        <c:otherwise>
                            <img src="<%=request.getContextPath()%>/ShowPicServlet.do?activityCategoryid=${aitVO.activityCategory.activityCategoryid}" alt="活動類別照片">
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <form method="post" action="<%=request.getContextPath()%>/activityItem.do">
                        <input type="submit" value="修改">
                        <input type="hidden" name="activityItemid" value="${aitVO.activityItemid}">
                        <input type="hidden" name="action" value="getOne_For_Update">
                    </form>
                </td>
                <td>
                    <form method="post" action="<%=request.getContextPath()%>/activityItem.do">
                        <input type="hidden" name="activityItemid" value="${aitVO.activityItemid}">
                        <input type="hidden" name="action" value="delete">
                        <input type="submit" value="刪除">
                    </form>
                </td>
            </tr>
        </c:forEach>
        
        </tbody>
        
        
    </table>
    <%@ include file="page2.file" %> 
    
</div>


</body>
</html>