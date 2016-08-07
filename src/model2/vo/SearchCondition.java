package model2.vo;

public class SearchCondition {
	private String key;
	private String gender;
	private String type;
	private String text;

	
	public SearchCondition(String key, String gender, String type, String text) {
		super();
		this.key = key;
		this.gender = gender;
		this.type = type;
		this.text = text;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "SearchCondition [key=" + key + ", gender=" + gender + ", type=" + type + ", text=" + text + "]";
	}
	
	
}
