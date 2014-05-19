
public class Tweet {
	
	public int id;
	public String user;
	public String text;
	public String ss;
	
	public Tweet(int id, String user, String text, String ss){
		this.id = id;
		this.user = user;
		this.text = text;
		this.ss = ss;
	}
	
	public Tweet() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getSS() {
		return ss;
	}
	public void setSS(String ss) {
		this.ss = ss;
	}
}
