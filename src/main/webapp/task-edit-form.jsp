<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, model.entity.CategoryBean, model.entity.StatusBean,model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	タスク編集画面
	<%
	List<CategoryBean> catList = (List<CategoryBean>) session.getAttribute("category_list");
	List<StatusBean> statusList = (List<StatusBean>) session.getAttribute("status_list");
	TaskBean bean = (TaskBean)request.getAttribute("bean");
	int taskId = (int)request.getAttribute("taskId");
%>
	<form action="TaskEditServlet" method="POST">
		<table border="1">
			<tr>
				<th>タスク名</th>
				<td><input type="text" name="task_name"  required maxlength="50" size="50" value = "<%=bean.getTaskName()%>"></td>
			</tr>
			<tr>
				<th>カテゴリ情報</th>
				<td>
				<select name="category_id">
				<%
					for(CategoryBean cat: catList){
				%>
				<option value="<%=cat.getCategoryId()%>"
			<%if (cat.getCategoryName().equals(bean.getCategoryName())) {%> selected <%}%>><%=cat.getCategoryName() %></option>
			<% }%>

				</select>
				</td>
			</tr>
			<tr>
				<th>期限</th>
				<td><input type="date" name="limit_date" value = "<%=bean.getLimitDate()%>"></td>
			</tr>
			<tr>
				<th>担当者情報</th>
				<td><input type="text" required  name="user_name" maxlength="20" size="20" value = "<%=bean.getUserName()%>" ></td>
			</tr>
			<tr>
				<th>ステータス情報</th>
				<td>
				<select name="status_code">
				<%
					for(StatusBean status: statusList){
				%>
				<option value="<%=status.getStatusCode()%>"
			<%if (status.getStatusName().equals(bean.getStatusName())) {%> selected <%}%>><%=status.getStatusName()%></option>
			<% }%>

				</select>
				</td>
			</tr>
			<tr>
				<th>メモ</th>
				<td>
				<textarea name="memo" rows="2" cols="50" maxlength="100" ><%=bean.getMemo()%></textarea>
				</td>
			</tr>
		</table>
		<input type = "hidden" name = "taskId" value = "<%=taskId%>">
		<input type="submit" value="編集する">
		<input type="reset" value="クリア">
	</form>

</body>
</html>