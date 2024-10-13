package model;

public class register {
	private String username;
	private String fullname;
	private String sdt;
	private String email;
	private String password;
	
	
	public register(String username, String fullname, String sdt, String email, String password) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.sdt = sdt;
		this.email = email;
		this.password = password;
	}



	public String getFullname() {
		return fullname;
	}




	public void setFullname(String fullname) {
		this.fullname = fullname;
	}




	public String getSdt() {
		return sdt;
	}




	public void setSdt(String sdt) {
		this.sdt = sdt;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	@Override
	public String toString() {
		return "longin [username=" + username + ", password=" + password + "]";
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
