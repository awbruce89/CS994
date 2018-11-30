package game;

public class Arena extends Area{
	
	private Enemy enemy;
	
    /**
     * Constructor for objects of class Entrance
     */
    public Arena(Item item) {
        // initialise instance variables
    	super("an arena. Blood stains the....everywhere. It's everywhere.", item);
    	enemy = new Enemy();
    }
    
    /**
     * Returns the enemy in the Arena
     */
	public Enemy getEnemy() {
		return enemy;
	}

	/**
	 * Sets the enemy in the Arena
	 */
	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}
    
	

}
