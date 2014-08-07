package smartcampus.vas.parcheggiausiliari.android.model;


public class BaseDT {
	private String mName;
	private String mDescription;
	private String mId;
	private LastChange lastChange;
	
	public String getName() {
		return mName;
	}
	

	public LastChange getLastChange() {
		return lastChange;
	}

	public BaseDT(String name, String description, String id, LastChange lastChange) {
		super();
		this.mName = name;
		this.mDescription = description;
		this.mId = id;
		this.lastChange = lastChange;
	}

	public String getId() {
		return mId;
	}
	public String getDescription() {
		return mDescription;
	}

}
