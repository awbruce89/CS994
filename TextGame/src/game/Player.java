package game;

import java.util.ArrayList;
import java.util.Random;

public class Player extends Fighter implements Combat {
	
	//private ArrayList<Item> inventory;
	private int[] position;
	private ArrayList<Item> inventory;
	private int maxHealth;
	private Weapon weapon;
	private Shield shield;

    /**
     * Constructor for objects of class Player
     */
    public Player() {
        // initialise instance variables
        super("Dayman", "A master of Karate and friendship.", 100, 5);
        //inventory = new ArrayList<>();
        position = new int[]{0, 0};
        inventory = new ArrayList<>();
        maxHealth = 100;
        weapon = null;
        shield = null;
    }
    
    /**
     * Return player position on game map
     */
    public int[] getPosition()
    {
        return position;
    } 
    
    /**
     * Set player position on game map
     */
    public void setPosition(int[] position)
    {
        this.position = position;
    }
    
    /**
     * Return players maximum health
     */
    public int getMaxHealth()
    {
        return maxHealth;
    } 
    
    /**
     * Set players maximum health
     */
    public void setMaxHealth(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }
    
    /**
     * Return players weapon
     */
    public Weapon getWeapon()
    {
        return weapon;
    } 
    
    /**
     * Set players weapon
     */
    public void setWeapon(Weapon weapon)
    {
        this.weapon = weapon;
    }

    /**
     * Return players shield
     */
    public Shield getShield()
    {
        return shield;
    } 
    
    /**
     * Set players weapon
     */
    public void setShield(Shield shield)
    {
        this.shield = shield;
    }
    
    /**
     * Return player inventory
     */
    public ArrayList<Item> getInventory()
    {
        return inventory;
    } 
    
    public void addItem(Item item) {
    	inventory.add(item);
    }
    
    public int usePotion() {
    	for(int i = 0; i < inventory.size(); i++) {
    		if(inventory.get(i) instanceof Potion) {
    			Potion p = (Potion) inventory.get(i);
    			inventory.remove(i);
    			return p.getHeals();
    		}
    	}
    	return 0;
    }
 
    public boolean useKey(Vault v) {
    	for(int i = 0; i < inventory.size(); i++) {
    		if(inventory.get(i) instanceof Key) {
    			Key k = (Key) inventory.get(i);
    			if((!v.getRequiresMasterKey() && !k.getMasterKey()) 
    				|| (v.getRequiresMasterKey() && k.getMasterKey())) {
    				inventory.remove(i);
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    
    
    public int attack() {
    	Random rand = new Random();
    	int damage = getStrength() + rand.nextInt(6);
    	return (damage);
    }
    
    public void defend() {
    	setDefending(true);
    }

}
