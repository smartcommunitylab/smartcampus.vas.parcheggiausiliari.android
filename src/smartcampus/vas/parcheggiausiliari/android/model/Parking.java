package smartcampus.vas.parcheggiausiliari.android.model;

import java.util.Date;

public class Parking extends BaseDT {

	private double[] position;
	private int slotsTotal;
	private int slotsOccupiedOnTotal;
	private int slotsUnavailable;
	private LastChange lastChange;
	
	
	public int getSlotsTotal() {
		return slotsTotal;
	}

	public double[] getPosition() {
		return position;
	}

	public int getSlotsOccupiedOnTotal() {
		return slotsOccupiedOnTotal;
	}

	public void setSlotsOccupiedOnTotal(int mSlotsOccupiedOnTotal) {
		this.slotsOccupiedOnTotal = mSlotsOccupiedOnTotal;
	}

	public int getSlotsUnavailable() {
		return slotsUnavailable;
	}

	public void setSlotsUnavailable(int mSlotsUnavailable) {
		this.slotsUnavailable = mSlotsUnavailable;
	}

	public Parking(String name, String description, String id,
			double[] position, int slotsTotal) {
		super(name, description, id);
		this.position = position;
		this.slotsTotal = slotsTotal;

	}
	
	public Parking(String name, String description, String id,
			double[] position, int slotsTotal,LastChange lastChange) {
		super(name, description, id);
		this.position = position;
		this.slotsTotal = slotsTotal;
		this.lastChange = lastChange;

	}


	
	public LastChange getLastChange() {
		return lastChange;
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
