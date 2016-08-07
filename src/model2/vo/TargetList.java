package model2.vo;

public class TargetList {
	private int num;
	private String name;
	private int age;
	private int gender;
	private String major;
	private String job;
	private int type;
	
	private int seq; 
	
	
	
	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	

	public TargetList(int num, String name, int age, int gender, String major, String job, int type, int seq) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.major = major;
		this.job = job;
		this.type = type;
		this.seq = seq;
	}


	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "TargetList [num=" + num + ", name=" + name + ", age=" + age + ", gender=" + gender + ", major=" + major
				+ ", job=" + job + ", type=" + type + "]";
	}
	
	
}
