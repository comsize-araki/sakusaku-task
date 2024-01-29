package model.entity;

//ステータス情報を保持するエンティティ
public class StatusBean {

	//ステータスコード
	private String statusCode;
	
	//ステータス名
	private String statusName;

	//アクセサ
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
}
