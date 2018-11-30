package game;

public class Vault extends Area{

	private boolean locked;
	private boolean requiresMasterKey;
	
    /**
     * Constructor for objects of class Vault
     */
    public Vault(String description, Item item, boolean requiresMasterKey) {
        // initialise instance variables
    	super(description, item);
        locked = true;
        this.requiresMasterKey= requiresMasterKey;
    }
    
    /**
     * Return the locked status of the vault
     */
    public boolean getLocked() {
        return locked;
    }     
    
    /**
     * Set the locked status of the vault
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    
    /**
     * Return whether the vault requires a master key
     * to enter
     */
    public boolean getRequiresMasterKey() {
        return requiresMasterKey;
    }     
    
    /**
     * Set whether the vault requires a master key
     * to enter
     */
    public void setRequiresMasterKey(boolean requiresMasterKey) {
        this.requiresMasterKey = requiresMasterKey;
    }
    
    /**
     * Sets the locked status of the room and sets
     * the challenge complete status true
     */
    public void unlockRoom() {
    	locked = false;
    	setChallengeComplete(true);
    }
    
	
}
