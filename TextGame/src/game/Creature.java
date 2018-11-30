package game;

public class Creature {
    
    private String name;
    private String description;


    /**
     * Constructor for objects of class Creature
     */
    public Creature(String name, String description)
    {
        // initialise instance variables
    	this.name = name;
        this.description = description;
    }
    
    /**
     * Return creature name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Set the creature name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Return creature description
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Set the creature description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
       
}
