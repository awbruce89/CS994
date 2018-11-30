package game;

public class Fighter extends Creature {

	private int health;
	private int strength;
	private boolean defending;
	
	public Fighter(String name, String description, int health, int strength) {
		super(name, description);
		this.health = health;
		this.strength = strength;	
		defending = false;
	}

    /**
     * Return fighter health
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * Set the fighter health
     */
    public void setHealth(int health)
    {
        this.health = health;
    }

    /**
     * Return fighter health
     */
    public int getStrength()
    {
        return strength;
    }
    
    /**
     * Set the fighter health
     */
    public void setStrength(int strength)
    {
        this.strength = strength;
    }
       
    /**
     * Return fighter defending status
     */
    public boolean getDefending()
    {
        return defending;
    }
    
    /**
     * Set the defending status
     */
    public void setDefending(boolean defending)
    {
        this.defending = defending;
    }
    
}
