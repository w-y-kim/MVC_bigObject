package model2.vo;

public class Customer {
	private String id;
	private String pw;
	private String name; 
	private String mail;
	private String type;
	private String code;
	private String addr;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Customer(String id, String pw, String name, String mail, String type, String code, String addr) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.mail = mail;
		this.type = type;
		this.code = code;
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", pw=" + pw + ", name=" + name + ", mail=" + mail + ", type=" + type + ", code="
				+ code + ", addr=" + addr + "]";
	} 
	
	
}
