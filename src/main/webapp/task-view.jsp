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
	%>
<h1>タスク一覧画面</h1>
	<table border="1">
		<tr>
			<th>選択</th>
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
		<tr>
			<td><input type="radio" name="taskid" value="<%=str.getTaskId()%>"></td>
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
		<form action="TaskEditServlet" method ="POST">
		<input type="submit" value="タスク編集">
		</form>
		<form action="TaskDeleteServlet" method ="POST">
		<input type="submit" value="タスク削除">
		</form>
</body>

</html>