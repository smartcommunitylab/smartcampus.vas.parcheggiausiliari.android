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
