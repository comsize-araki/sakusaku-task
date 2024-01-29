<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List, model.entity.CategoryBean, model.entity.StatusBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録画面</title>
</head>
<body>
<%
	List<CategoryBean> catList = (List<CategoryBean>) session.getAttribute("category_list");
	List<StatusBean> statusList = (List<StatusBean>) session.getAttribute("status_list");
%>
	<form action="TaskRegisterServlet" method="POST">
		<table border="1">
			<tr>
				<th>タスク名</th>
				<td><input type="text" name="task_name" maxlength="50" size="50"></td>
			</tr>
			<tr>
				<th>カテゴリ情報</th>
				<td>
				<select name="caegory_id">
				<%
					for(CategoryBean cat: catList){
				%>
				<option value="<%=cat.getCategoryId()%>">
				<%=cat.getCategoryName() %>
				</option>
				<%
					}
				%>
				</select>
				</td>
			</tr>
			<tr>
				<th>期限</th>
				<td><input type="date" name="limit_date"></td>
			</tr>
			<tr>
				<th>担当者情報</th>
				<td><input type="text" name="user_name" maxlength="20" size="20"></td>
			</tr>
			<tr>
				<th>ステータス情報</th>
				<td>
				<select name="status_code">
				<%
					for(StatusBean status: statusList){
				%>
				<option value="<%=status.getStatusCode()%>">
				<%=status.getStatusName() %>
				</option>
				<%
					}
				%>
				</select>
				</td>
			</tr>
			<tr>
				<th>メモ</th>
				<td>
				<textarea name="memo" rows="2" cols="50" maxlength="100"></textarea>
				</td>
			</tr>
		</table>
		<input type="submit" value="登録する">
		<input type="reset" value="クリア">
	</form>
</body>
</html>