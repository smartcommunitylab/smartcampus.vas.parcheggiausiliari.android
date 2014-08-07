package smartcampus.vas.parcheggiausiliari.android.model;

import java.util.Date;

public class LastChange{
	private String mAuthor;
	private Date mTime;
	public LastChange(String mAuthor, Date mTime) {
		super();
		this.mAuthor = mAuthor;
		this.mTime = mTime;
	}
	public String getmAuthor() {
		return mAuthor;
	}
	public Date getmTime() {
		return mTime;
	}
	
}