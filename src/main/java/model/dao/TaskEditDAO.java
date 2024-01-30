package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

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

}
