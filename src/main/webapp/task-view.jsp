<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,java.util.ArrayList,model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		List<TaskBean> list = (List) request.getAttribute("list"); 
		String message = (String)request.getAttribute("message");
		String select = (String)request.getAttribute("select");
	%>
<h1>タスク一覧画面</h1>

		<a href = "TaskSelectServlet?select=edit">編集する</a>     
		<a href = "TaskSelectServlet?select=delete">削除する</a>
		
		<%if (message != null) {%><h3><%=message %></h3><%} %>
		
		<%if (select == null) { %>
		
		<%}else if (select.equals("edit")){ %>
		<form action="TaskEditServlet" method ="GET">
		<%}else{ %>
		<form action="TaskDeleteServlet" method ="POST">
		<%} %>	
	<table border="1">
		<tr>
			<%if (select != null){ %><th>選択</th><%} %>
			<th>タスク名</th>
			<th>カテゴリ情報</th>
			<th>期限</th>
			<th>担当者情報</th>
			<th>ステータス情報</th>
			<th>メモ</th>
		</tr>
		<%
		for (TaskBean str : list) {
		%>
		<tr><%if (select == null) { %>
		<%}else if (select.equals("edit")){ %>
		<td><input type="radio" name="taskid" value="<%=str.getTaskId()%>"></td>
		<%}else { %>
		<td><input type="radio" name="taskid" value="<%=str.getTaskId()%>"></td>
		<%} %>
			
			<td><%=str.getTaskName()%></td>
			<td><%=str.getCategoryName()%></td>
			<%if (str.getLimitDate() == null) {%>
			<td></td>
			<%}else{ %><td>
			<%=str.getLimitDate()%></td><%} %>
			<td><%=str.getUserName()%></td>
			<td><%=str.getStatusName()%></td>
			<td><%=str.getMemo()%></td>
		</tr>
		<%
		}
		%>
		

		</table>
		<br>
		<%if (select == null) { %>
		
		<%}else if (select.equals("edit")){ %>
		
		<input type="submit" value="タスク編集">
		</form>
		<%}else{ %>
		
		<input type="submit" value="タスク削除">
		</form>
		<%} %>
		
</body>

</html>