<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録完了画面</title>
</head>
<body>
	<%
	TaskBean task = (TaskBean) request.getAttribute("task");
	%>
	<h1>タスクの登録が完了しました。</h1>
	<table border="1">
		<tr>
			<th>登録項目</th>
			<th>登録内容</th>
		</tr>
		<tr>
			<th>タスク名</th>
			<td><%=task.getTaskName()%></td>
		</tr>
		<tr>
			<th>カテゴリ情報</th>
			<td><%=task.getCategoryName()%></td>
		</tr>
		<tr>
			<th>期限</th>
			<td>
				<%
				if (task.getLimitDate() == null) {
				%> 未設定 <%
				} else {
				%> <%=task.getLimitDate()%> <%
 }
 %>
			</td>
		</tr>
		<tr>
			<th>担当者情報</th>
			<td><%=task.getUserName()%></td>
		</tr>
		<tr>
			<th>ステータス情報</th>
			<td><%=task.getStatusName()%></td>
		</tr>
		<tr>
			<th>メモ</th>
			<td><%=task.getMemo()%></td>
		</tr>
	</table>
	<form action="menu.jsp" method="POST">
		<input type="submit" value="メニュー画面に戻る">
	</form>
</body>
</html>