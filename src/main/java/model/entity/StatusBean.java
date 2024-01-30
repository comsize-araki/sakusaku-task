package model.entity;

/**
 * ステータス情報を保持するエンティティ
 * @author mori
 */
public class StatusBean {

	/**
	 * ステータスコード
	 */
	private String statusCode;

	/**
	 * ステータス名
	 */
	private String statusName;

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

}
