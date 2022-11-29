<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.io.File" %>
    <%
    	String deleteImg ="bg.jpg";
    
    	String deleteImgFullPath = request.getRealPath("/image/") +deleteImg;
    	File img = new File(deleteImgFullPath);
    	
    	if(img.exists() && img.isFile()){
    		img.delete();
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file delete</title>
</head>
<body>
	<h2>file delete</h2>
	<p>파일이 정상적으로 삭제되었습니다.</p>
</body>
</html>