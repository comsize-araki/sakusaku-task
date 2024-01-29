package model.entity;

import java.time.LocalDate;

public class UserBean {
	private String userId;
	private String password;
	private String userName;
	private LocalDate updatDatetime;
	
	// コンストラクタ
	public UserBean () {
		
	}
	
	
	// ゲッターセッター
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
