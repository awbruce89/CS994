package game;

import java.util.Random;

//public class Enemy extends Creature implements Fighter {
public class Enemy extends Fighter implements Combat {
	
    /**
     * Constructor for objects of class Enemy
     */
    public Enemy() {
        // initialise instance variables
        super("Nightman", "A minion of Baron Von Wermhat", 50, 15);
    }
    
    public int attack() {
    	Random rand = new Random();
    	int damage = rand.nextInt(getStrength());
    	System.out.println("The enemy attacks you, dealing " + damage + " damage!");
    	return (damage);
    }
    
    
    /**
     * Sets the enemy defending status
     */
    public void defend() {
    	setDefending(true);
    }


}
