package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;
import model.entity.StatusBean;

public class LoginDAO {
	
	public boolean existsUser(String userId, String password) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM m_user WHERE user_id = ? and password = ?;";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			
			ResultSet res = pstmt.executeQuery();
			
			if (res.next()) {
				return true;
			}
			
		}
		return false;
	}
	
	public String getUserName(String userId, String password) throws SQLException, ClassNotFoundException {
	    String sql = "SELECT user_name FROM m_user WHERE user_id = ? and password = ?;";
	    try (Connection con = ConnectionManager.getConnection();
	            PreparedStatement pstmt = con.prepareStatement(sql);) {

	        pstmt.setString(1, userId);
	        pstmt.setString(2, password);

	        ResultSet res = pstmt.executeQuery();

	        if (res.next()) {
	            return res.getString("user_name");
	        }
	        return null;
	    }
	}
	
	public List<CategoryBean> category() throws SQLException, ClassNotFoundException {

		//SQL文の設定
		String sql = "SELECT * FROM m_category";

		//カテゴリー一覧用リストの生成
		List<CategoryBean> catList = new ArrayList<CategoryBean>();

		//データベースへの接続
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {

			//取得したデータのリストへの挿入
			while (res.next()) {

				CategoryBean cat = new CategoryBean();

				cat.setCategoryId(res.getInt("category_id"));
				cat.setCategoryName(res.getString("category_name"));

				catList.add(cat);

			}

			//リストをreturn
			return catList;

		}

	}
	
	public List<StatusBean> status() throws SQLException, ClassNotFoundException {

		//SQL文の設定
		String sql = "SELECT * FROM m_status";

		//カテゴリー一覧用リストの生成
		List<StatusBean> statusList = new ArrayList<StatusBean>();

		//データベースへの接続
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)) {

			//取得したデータのリストへの挿入
			while (res.next()) {

				StatusBean status = new StatusBean();

				status.setStatusCode(res.getString("status_code"));
				status.setStatusName(res.getString("status_name"));

				statusList.add(status);

			}

			//リストをreturn
			return statusList;

		}

	}

}
