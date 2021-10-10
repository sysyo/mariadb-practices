package bookmall.vo;

public class CategoryVo {
	private int categoryNo;
	private String categoryName;
	
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "CategoryVo [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}
	
	
	
	
}
