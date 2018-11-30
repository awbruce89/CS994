package game;

public class Key extends Item{

	
	private boolean masterKey;
    /**
     * Constructor for objects of class Key
     */
    public Key(String name, String description, boolean masterKey)
    {
        super(name, description);
        this.masterKey = masterKey;
        
    }
    
    /**
     * Returns the master key status of the key
     */
	public boolean getMasterKey() {
		return masterKey;
	}
	
    /**
     * Sets the master key status of the key
     */
	public void setMasterKey(boolean masterKey) {
		this.masterKey = masterKey;
	}
	
}
