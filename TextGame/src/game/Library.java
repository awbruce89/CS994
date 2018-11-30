package game;

public class Library extends Area {
	
	private Puzzler puzzler;
	
    /**
     * Constructor for objects of class Library
     */
    public Library(Item item) {
        // initialise instance variables
    	super("a Library. It's filled with bookstacks on bookstacks on bookstacks.", item);
        puzzler = new Puzzler();
    }
    
    /**
     * Return the puzzler
     */
    public Puzzler getPuzzler() {
        return puzzler;
    }     
    
    /**
     * Set the puzzler
     */
    public void setPuzzler(Puzzler puzzler) {
        this.puzzler = puzzler;
    }
    

}
