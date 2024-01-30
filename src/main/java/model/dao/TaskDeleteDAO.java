package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * 取得したtask_idのレコードをt_taskテーブルから消す
 * @author taira
 */
public class TaskDeleteDAO {
	/**
	 * 取得したtask_idのレコードをt_taskテーブルから消す
	 * @param taskid
	 * @return 削除した件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int TaskDelete(int taskid) throws SQLException,ClassNotFoundException{
		String sql = "DELETE FROM t_task WHERE task_id = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
		
		pstmt.setInt(1,taskid);
		
		int count = pstmt.executeUpdate();
		
		return count;
	}
}
	
	/**
	 * 取得したtask_idのレコードをt_commentテーブルから消す
	 * @author taira
	 */
	public int DeleteSuccess(int taskid) throws SQLException,ClassNotFoundException{
		String sql = "DELETE FROM t_comment WHERE task_id = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
		
		pstmt.setInt(1,taskid);
		
		int count = pstmt.executeUpdate();
		
		return count;
	}
}
}
