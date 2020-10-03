package Entity;

public class User {
	private String userid;
	private String username;
	private String userPassword;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public User(String userid, String username, String userPassword) {
		super();
		this.userid = userid;
		this.username = username;
		this.userPassword = userPassword;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", userPassword=" + userPassword + "]";
	}

}
