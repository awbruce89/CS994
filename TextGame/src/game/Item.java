package game;

public class Item {
	
    private String description;
    private String name;


    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description)
    {
        // initialise instance variables
    	this.name = name;
        this.description = description;
    }
	
    /**
     * Return item description
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Set the item description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * Return item name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Set the item name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Checks the see if the name of this object matches the name
     * of another object		
     */
    public boolean equals(Object obj) {
    	Item item = (Item) obj;
    	if(name.toLowerCase().trim().equals(item.getName().toLowerCase().trim())) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
