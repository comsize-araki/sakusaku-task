<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.entity.UserBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%String name = (String)session.getAttribute("userName");
	%>
	<%=name %><br>

	<a href = "task-register-form.jsp">登録</a>
	<br>
	<a href = "TaskListServlet">一覧表示</a>
	<br>
	<a href = "logout.jsp">ログアウト</a>

</body>
</html>