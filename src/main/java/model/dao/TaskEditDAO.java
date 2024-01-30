package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;

import model.entity.TaskBean;

public class TaskEditDAO {
	
	// タスク編集メソッド
		
		public int update(TaskBean task) throws SQLException, ClassNotFoundException {

			//SQL文の設定
			String sql = "UPDATE  t_task SET task_name = ?, category_id = ?,"
					+ " limit_date = ?, user_id = ?, status_code = ?, memo = ?  WHERE task_id = ?;";

			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {

				//プレイスホルダーへの代入
				pstmt.setString(1, task.getTaskName());
				pstmt.setInt(2, task.getCategoryId());
				if (task.getLimitDate() == null) {

					pstmt.setNull(3, Types.DATE);

				} else {

					Date date = Date.valueOf(task.getLimitDate());
					pstmt.setDate(3, date);

				}
				pstmt.setString(4, task.getUserId());
				pstmt.setString(5, task.getStatusCode());
				pstmt.setString(6, task.getMemo());
				pstmt.setInt(7, task.getTaskId());

				//クエリ送信
				int num = pstmt.executeUpdate();

				//得た更新件数をreturn
				return num;
			}
		}
		
		public TaskBean selectOne(int num) throws SQLException,ClassNotFoundException{
			//一覧表示するためのsql文
			String sql="SELECT t1.task_id,t1.task_name,t2.category_name,t1.limit_date,"
					+ " t3.user_name,t4.status_name,t1.memo FROM t_task t1 INNER JOIN m_category t2 ON t1.category_id = t2.category_id"
					+ " INNER JOIN m_user t3 ON t1.user_id = t3.user_id INNER JOIN m_status t4 "
					+ "ON t1.status_code = t4.status_code WHERE task_id = ?;";
			
			TaskBean list = new TaskBean();

			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				
				//プレイスホルダーへの代入
				pstmt.setInt(1, num);
				ResultSet res = pstmt.executeQuery();
				
				//データベースから値を受け取りBeanにセット
				if (res.next()) {
					
					list.setTaskId(res.getInt("task_id"));
					list.setTaskName(res.getString("task_name"));
					list.setCategoryName(res.getString("category_name"));
					if (res.getDate("limit_date") == null) {
						
						LocalDate limitDate  = null;
						list.setLimitDate(limitDate);
					}else {
						list.setLimitDate(res.getDate("limit_date").toLocalDate());
					}
					
					list.setUserName(res.getString("user_name"));
					list.setStatusName(res.getString("status_name"));
					list.setMemo(res.getString("memo"));

					
				}
			}
			return list;
		}

}
