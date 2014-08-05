package smartcampus.vas.parcheggiausiliari.android.model;

public class BaseDT {
	private String name;
	private String description;
	private String id;

	public String getName() {
		return name;
	}

	public BaseDT(String name, String description, String id) {
		super();
		this.name = name;
		this.description = description;
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
