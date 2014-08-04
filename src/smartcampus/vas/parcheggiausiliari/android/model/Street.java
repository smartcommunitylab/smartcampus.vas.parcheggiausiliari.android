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
	private int slotsOccupiedOnPaying;
	/**
	 * parcheggi a disco orario totali/occupati
	 */
	private int slotsTimed;
	private int slotsOccupiedOnTimed;
}
