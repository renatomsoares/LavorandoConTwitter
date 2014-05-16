
public class Tweet {
	
	int id;
	String user;
	String text;
	String image;
	String link;
	
	public Tweet(int id, String user, String text, String image, String link){
		this.id = id;
		this.user = user;
		this.text = text;
		this.image = image;
		this.link = link;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

}
