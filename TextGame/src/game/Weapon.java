package game;

public class Weapon extends Item {
	
	private double damageModifier;
	
	public Weapon(String name, String description, double damageModifier) {
		super(name, description);
		this.damageModifier = damageModifier;
	}

	/**
	 * Returns the weapon damage modifier
	 */
	public double getDamageModifier() {
		return damageModifier;
	}

	/**
	 * Sets the weapon damage modifier
	 */
	public void setDamageModifier(double damageModifier) {
		this.damageModifier = damageModifier;
	}
	
}
