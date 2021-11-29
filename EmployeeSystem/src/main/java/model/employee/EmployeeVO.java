package model.employee;

public class EmployeeVO {

	// 멤버변수 
	private int num; // 직원번호 / pk 
	private String ename; // varchar(50) not null,-- 직원이름
	private String phone; // varchar(50) not null,-- 전화번호 
	private String grade; //varchar(50) not null,-- 직급
	private String email; //varchar(50) not null-- 이메일 주소 
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	private String condition;
	private String keyword;

	// Getter & Setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	// toString()
	@Override
	public String toString() {
		return "EmployeeVO [num=" + num + ", ename=" + ename + ", phone=" + phone + ", grade=" + grade + ", email="
				+ email + ", condition=" + condition + ", keyword=" + keyword + "]";
	}	
}
