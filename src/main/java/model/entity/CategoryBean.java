package model.entity;

/**
 * カテゴリー情報を保持するエンティティ
 * @author mori
 */
public class CategoryBean {

	/**
	 * カテゴリーID
	 */
	private int categoryId;

	/**
	 * カテゴリー名
	 */
	private String categoryName;

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

}