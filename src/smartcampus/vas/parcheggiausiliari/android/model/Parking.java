package smartcampus.vas.parcheggiausiliari.android.model;

public class Parking extends BaseDT {

	private double[] position;
	private int slotsTotal;
	private int slotsOccupiedOnTotal;
	private int slotsUnavailable;

	public int getSlotsTotal() {
		return slotsTotal;
	}

	public double[] getPosition() {
		return position;
	}

	public Parking(String name, String description, String id,
			double[] position, int slotsTotal) {
		super(name, description, id);
		this.position = position;
		this.slotsTotal = slotsTotal;

	}

}
