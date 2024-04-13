<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
    
<!DOCTYPE html>

<html>

<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>


<body>

<FORM action="<%=request.getContextPath()%>" method=post enctype="multipart/form-data">
        <input type="file" name="upfile1">
        <br>
        <input type="file" name="upfile2">
        
        <input type="submit" value="submit">
  </FORM>
  
</body>

</html>