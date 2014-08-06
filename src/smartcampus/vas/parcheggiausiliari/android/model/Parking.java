package smartcampus.vas.parcheggiausiliari.android.model;

public class Parking extends BaseDT {

	private double[] mPosition;
	private int mSlotsTotal;
	private int mSlotsOccupiedOnTotal;
	private int mSlotsUnavailable;

	public int getSlotsTotal() {
		return mSlotsTotal;
	}

	public double[] getPosition() {
		return mPosition;
	}

	public Parking(String name, String description, String id,
			double[] position, int slotsTotal) {
		super(name, description, id);
		this.mPosition = position;
		this.mSlotsTotal = slotsTotal;

	}

}
