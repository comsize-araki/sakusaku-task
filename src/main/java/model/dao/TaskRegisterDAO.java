package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.TaskBean;

//タスク情報登録の中でデータベース接続にかかわるDAOクラス
public class TaskRegisterDAO {

	//ユーザ名からユーザIDを取得
	public String getUserId(String userName) throws SQLException, ClassNotFoundException {

		//SQL文の設定
		String sql = "SELECT user_id FROM m_user WHERE user_name = ?";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			//プレイスホルダーへの代入
			pstmt.setString(1, userName);

			//クエリ送信
			ResultSet res = pstmt.executeQuery();

			//ユーザID用変数
			String userId;

			if (res.next()) {

				//結果が存在すればユーザIDを変数に代入
				userId = res.getString("user_id");

			} else {

				//結果が存在しなければnullを代入
				userId = null;

			}

			//ユーザIDの変数をreturn
			return userId;

		}

	}

	public int register(TaskBean task) throws SQLException, ClassNotFoundException {

		//SQL文の設定
		String sql = "INSERT INTO m_user (task_name, category_id, limit_date, "
				+ "user_id, status_code, memo) VALUE (?, ?, ?, ?, ?, ?)";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			int num = 0;
			
			//プレイスホルダーへの代入
			pstmt.setString(1, task.getTaskName());
			pstmt.setInt(2, task.getCategoryId());
			//https://qiita.com/Manabu-man/items/abaa7e9aa1773e282d02を参考にリクエストパラメータをLocalDateに変換する方法とLocalDateをセットする方法を検索
//			pstmt.setDate(3, task.getLimitDate());
			pstmt.setString(4, task.getUserId());
			pstmt.setString(5, task.getStatusCode());
			pstmt.setString(6, task.getMemo());
			
			return num;
		}
	}
}
