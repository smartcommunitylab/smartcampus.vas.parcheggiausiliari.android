package smartcampus.vas.parcheggiausiliari.android.model;

public class BaseDT {
	private String mName;
	private String mDescription;
	private String mId;

	public String getName() {
		return mName;
	}

	public BaseDT(String name, String description, String id) {
		super();
		this.mName = name;
		this.mDescription = description;
		this.mId = id;
	}

	public String getId() {
		return mId;
	}

}
