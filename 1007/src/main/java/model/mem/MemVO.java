package model.mem;

public class MemVO {
	private String id; // ID VARCHAR(15) PRIMARY KEY, 
	private String password; // PASSWORD VARCHAR(10),
	private String name; //NAME VARCHAR(15),
	private String role; //ROLE VARCHAR(15)
	
	// Getter & Setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	// toString
	@Override
	public String toString() {
		return "MemVO [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}
	

	
	
}
