package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDeleteDAO {
	public int TaskDelete(int taskid) throws SQLException,ClassNotFoundException{
		String sql = "DELETE FROM t_task WHERE task_id = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
		
		pstmt.setInt(1,taskid);
		
		int count = pstmt.executeUpdate();
		
		return count;
	}
}
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
