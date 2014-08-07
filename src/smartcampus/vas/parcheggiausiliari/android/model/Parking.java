package smartcampus.vas.parcheggiausiliari.android.model;

import java.util.Date;

public class Parking extends BaseDT {

	private double[] mPosition;
	private int mSlotsTotal;
	private int mSlotsOccupiedOnTotal;
	private int mSlotsUnavailable;
	private LastChange mLastChange;
	
	
	public int getSlotsTotal() {
		return mSlotsTotal;
	}

	public double[] getPosition() {
		return mPosition;
	}

	public int getSlotsOccupiedOnTotal() {
		return mSlotsOccupiedOnTotal;
	}

	public void setSlotsOccupiedOnTotal(int mSlotsOccupiedOnTotal) {
		this.mSlotsOccupiedOnTotal = mSlotsOccupiedOnTotal;
	}

	public int getSlotsUnavailable() {
		return mSlotsUnavailable;
	}

	public void setSlotsUnavailable(int mSlotsUnavailable) {
		this.mSlotsUnavailable = mSlotsUnavailable;
	}

	public Parking(String name, String description, String id,
			double[] position, int slotsTotal) {
		super(name, description, id);
		this.mPosition = position;
		this.mSlotsTotal = slotsTotal;

	}
	
	public Parking(String name, String description, String id,
			double[] position, int slotsTotal,LastChange lastChange) {
		super(name, description, id);
		this.mPosition = position;
		this.mSlotsTotal = slotsTotal;
		this.mLastChange = lastChange;

	}


	
	public LastChange getLastChange() {
		return mLastChange;
	}

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
	
}
