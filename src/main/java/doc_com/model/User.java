package doc_com.model;

public class User {
	private int uid;
	private int upass;
	private String uname;
	private String usex;
	private int uage;
	private double utel;
	private int ucondition;
	private String udescripe;
	
	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}

	
	public int getUpass() {
		return upass;
	}

	public void setUpass(int upass) {
		this.upass = upass;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public int getUage() {
		return uage;
	}

	public void setUage(int uage) {
		this.uage = uage;
	}

	public double getUtel() {
		return utel;
	}

	public void setUtel(double utel) {
		this.utel = utel;
	}

	public int getUcondition() {
		return ucondition;
	}

	public void setUcondition(int ucondition) {
		if(ucondition==0||ucondition==1||ucondition==2) {
			this.ucondition = ucondition;
		}else {
			this.ucondition = -1;
		}
		
	}

	public String getUdescripe() {
		return udescripe;
	}

	public void setUdescripe(String udescripe) {
		this.udescripe = udescripe;
	}

}
