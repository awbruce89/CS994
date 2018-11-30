package game;

public class GamesRoom extends Area{
	
	private Gamer gamer;
	
    /**
     * Constructor for objects of class Library
     */
    public GamesRoom(Item item) {
        // initialise instance variables
    	super("A room of games. This is pretty meta. Also, there's a throne.", item);
    	gamer = new Gamer();
    }
    
    /**
     * Return the player
     */
    public Gamer getGamer() {
        return gamer;
    }     
    
    /**
     * Set the player
     */
    public void setGamer(Gamer gamer) {
        this.gamer = gamer;
    }
}
