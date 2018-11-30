package game;

public class Area {
	
	private String description;
	private boolean challengeComplete;
	private Item item;
	
    /**
     * Constructor for objects of class Library
     */
    public Area(String description, Item item) {
        // initialise instance variables
        this.description = description;
        challengeComplete = false;
        this.item = item;
    }

    /**
     * Return the area description
     */
    public String getDescription() {
    	return description;
    }
    
    /**
     * Set the area description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * Return the challenge complete status
     */
    public boolean getChallengeComplete() {
    	return challengeComplete;
    }
    
    /**
     * Set the challenge complete status
     */
    public void setChallengeComplete(boolean challengeComplete)
    {
        this.challengeComplete = challengeComplete;
    }
    
    /**
     * Return player if the room contains the player
     */
    public Item getItem()
    {
        return item;
    } 
    
    /**
     * Set whether room contains the player
     */
    public void setItem(Item item)
    {
        this.item = item;
    }
    
}
