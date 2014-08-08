package smartcampus.vas.parcheggiausiliari.android.model;

import java.util.Date;

public class LastChange{
	private String author;
	private Date time;
	public LastChange(String author, Date time) {
		super();
		this.author = author;
		this.time = time;
	}
	public String getAuthor() {
		return author;
	}
	public Date getTime() {
		return time;
	}
	
}