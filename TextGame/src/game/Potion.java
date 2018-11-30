package game;

public class Potion extends Item {
	
	private int heals;

	public Potion() {
		super("Potion", "a random potion. Why wouldn't you drink this in a time of need?!");
		heals = 50;
	}

	/**
	 * Returns amount potion heals
	 */
	public int getHeals() {
		return heals;
	}

	/**
	 * Sets amount potion heals
	 */
	public void setHeals(int heals) {
		this.heals = heals;
	}

}
