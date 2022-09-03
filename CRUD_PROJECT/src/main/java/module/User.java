package module;

public class User {
	// It is not necessory to take similar fields in pojo and table(db)

	private int uid;
	private String uname;
	private String uemail;
	private String ucity;
	public User(int uid, String uname, String uemail, String ucity) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uemail = uemail;
		this.ucity = ucity;
	}
	public User(String uname, String uemail, String ucity) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		this.ucity = ucity;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUcity() {
		return ucity;
	}
	public void setUcity(String ucity) {
		this.ucity = ucity;
	}
	
	

}
