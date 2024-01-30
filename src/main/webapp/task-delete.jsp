<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	 int count  = (int) request.getAttribute("count");
	%>
	<h1>タスク削除確認画面</h1>
	
	<%
	if(count > 0){
	%>
	
	<form action="" method="POST">
		
	</form>

</body>
</html>