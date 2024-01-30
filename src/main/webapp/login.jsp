<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Login.css">
<title>Insert title here</title>
</head>
<body>
	
	<form action = "LoginServlet" method = "POST" >
	<h4>ログインID:</h4>
	<input type = "text" name = "userId" value = "" >
	<h4>パスワード:</h4>
	<input type = "password" name = "password" value = "" ><br>
	<input type = "submit" value = "ログイン">  
	<input type = "reset" value = "クリア" >
	</form>
	

</body>
</html>