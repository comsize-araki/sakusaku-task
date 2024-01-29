<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action = "LoginServlet" method = "POST">
	ログインID:
	<input type = "text" name = "userId" value = "" ><br>
	パスワード:
	<input type = "text" name = "password" value = "" ><br>
	<input type = "submit" value = "ログイン">  
	<input type = "reset" value = "クリア" ><br>
	</form>
	

</body>
</html>