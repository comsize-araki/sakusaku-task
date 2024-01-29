package model.entity;

//カテゴリー情報を保持するエンティティ
public class CategoryBean {

	//カテゴリーID
	private int categoryId;
	
	//カテゴリー名
	private String categoryName;

	//アクセサ
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}