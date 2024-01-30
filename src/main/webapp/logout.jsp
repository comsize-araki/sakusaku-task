<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	ログアウトしました。
	
	<%
	session.invalidate();
	%>
	<br>
	<form action="login.jsp" method="POST">
	<input type="submit" value="ログイン画面">
	</form>

</body>
</html>