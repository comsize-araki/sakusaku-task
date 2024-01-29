package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;

public class TaskListDAO {
	public List<TaskBean> ListView() throws SQLException,ClassNotFoundException{
		//一覧表示するためのsql文
		String sql="SELECT t1.task_id,t1.task_name,t2.category_name,t1.limit_date, t3.user_name,t4.status_name,t1.memo FROM t_task t1 INNER JOIN m_category t2 ON t1.category_id = t2.category_id INNER JOIN m_user t3 ON t1.user_id = t3.user_id INNER JOIN m_status t4 ON t1.status_code = t4.status_code;";
		
		List<TaskBean> list = new ArrayList<>();

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			ResultSet res = pstmt.executeQuery();
			
			//データベースから値を受け取りBeanにセット
			while (res.next()) {
				TaskBean TaskBean = new TaskBean();
				TaskBean.setTaskId(res.getInt("task_id"));
				TaskBean.setTaskName(res.getString("task_name"));
				TaskBean.setCategoryName(res.getString("category_name"));
				if (res.getDate("limit_date") == null) {
					
					LocalDate limitDate  = null;
					TaskBean.setLimitDate(limitDate);
				}else {
					TaskBean.setLimitDate(res.getDate("limit_date").toLocalDate());
				}
				
				TaskBean.setUserName(res.getString("user_name"));
				TaskBean.setStatusName(res.getString("status_name"));
				TaskBean.setMemo(res.getString("memo"));

				list.add(TaskBean);
			}
		}
		return list;
	}
}
