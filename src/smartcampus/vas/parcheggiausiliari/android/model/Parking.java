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

	public int getmSlotsOccupiedOnTotal() {
		return mSlotsOccupiedOnTotal;
	}

	public void setmSlotsOccupiedOnTotal(int mSlotsOccupiedOnTotal) {
		this.mSlotsOccupiedOnTotal = mSlotsOccupiedOnTotal;
	}

	public int getmSlotsUnavailable() {
		return mSlotsUnavailable;
	}

	public void setmSlotsUnavailable(int mSlotsUnavailable) {
		this.mSlotsUnavailable = mSlotsUnavailable;
	}

	public Parking(String name, String description, String id,
			double[] position, int slotsTotal) {
		super(name, description, id);
		this.mPosition = position;
		this.mSlotsTotal = slotsTotal;

	}

}
