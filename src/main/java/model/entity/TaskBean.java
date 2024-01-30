package model.entity;

import java.time.LocalDate;

/**
 * タスク一覧表示、登録、編集で使用するエンティティ
 * @author mori
 */
public class TaskBean {
	
	/**
	 * タスクID
	 */
	private int taskId;

	/**
	 * タスク名
	 */
	private String taskName;

	/**
	 * カテゴリID
	 */
	private int categoryId;

	/**
	 * カテゴリ情報
	 */
	private String categoryName;

	/**
	 * 期限
	 */
	private LocalDate limitDate;

	/**
	 * 担当者ID
	 */
	private String userId;

	/**
	 * 担当者情報
	 */
	private String userName;

	/**
	 * ステータスコード
	 */
	private String statusCode;

	/**
	 * ステータス情報
	 */
	private String statusName;

	/**
	 * メモ
	 */
	private String memo;

	/**
	 * @return taskId
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId セットする taskId
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName セットする taskName
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId セットする categoryId
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName セットする categoryName
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return limitDate
	 */
	public LocalDate getLimitDate() {
		return limitDate;
	}

	/**
	 * @param limitDate セットする limitDate
	 */
	public void setLimitDate(LocalDate limitDate) {
		this.limitDate = limitDate;
	}

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName セットする userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode セットする statusCode
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return statusName
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * @param statusName セットする statusName
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * @return memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo セットする memo
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}



}
