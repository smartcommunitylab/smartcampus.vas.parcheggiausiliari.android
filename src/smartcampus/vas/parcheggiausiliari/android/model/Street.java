package smartcampus.vas.parcheggiausiliari.android.model;

public class Street extends BaseDT {
	/**
	 * parcheggi gratuiti totali/occupati
	 */
	private int slotsFree;
	private int slotsOccupiedOnFree;
	/**
	 * parcheggi liberi totali/occupati
	 */
	private int slotsUnavailable;
	/**
	 * parcheggi a pagamento totali/occupati
	 */
	private int slotsPaying;

	public int getSlotsOccupiedOnFree() {
		return slotsOccupiedOnFree;
	}

	public void setSlotsOccupiedOnFree(int slotsOccupiedOnFree) {
		this.slotsOccupiedOnFree = slotsOccupiedOnFree;
	}

	public int getSlotsOccupiedOnPaying() {
		return slotsOccupiedOnPaying;
	}

	public void setSlotsOccupiedOnPaying(int slotsOccupiedOnPaying) {
		this.slotsOccupiedOnPaying = slotsOccupiedOnPaying;
	}

	public int getSlotsOccupiedOnTimed() {
		return slotsOccupiedOnTimed;
	}

	public void setSlotsOccupiedOnTimed(int slotsOccupiedOnTimed) {
		this.slotsOccupiedOnTimed = slotsOccupiedOnTimed;
	}

	public void setSlotsUnavailable(int slotsUnavailable) {
		this.slotsUnavailable = slotsUnavailable;
	}

	public Street(String name, String description, String id, int slotsFree,
			int slotsPaying, int slotsTimed) {
		super(name, description, id);
		this.slotsFree = slotsFree;
		this.slotsPaying = slotsPaying;
		this.slotsTimed = slotsTimed;
	}

	private int slotsOccupiedOnPaying;
	/**
	 * parcheggi a disco orario totali/occupati
	 */
	private int slotsTimed;
	private int slotsOccupiedOnTimed;

	public int getSlotsFree() {
		return slotsFree;
	}

	public int getSlotsUnavailable() {
		return slotsUnavailable;
	}

	public int getSlotsPaying() {
		return slotsPaying;
	}

	public int getSlotsTimed() {
		return slotsTimed;
	}
}
