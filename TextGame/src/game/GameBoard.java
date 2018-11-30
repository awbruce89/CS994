package game;

import java.util.Random;

public class GameBoard {
	
    private Area[][] map;
    private int keyOffset;
    private int keysLeft;
    private int masterKeyOffset;
    private int masterKeysLeft;
    private int potionOffset;
    private int potionsLeft;
    
    /**
     * Constructor for objects of class GameBoard
     */
    public GameBoard()
    {
        map = new Area[5][5];
        keysLeft = 3;
        keyOffset = 5;
        masterKeysLeft = 1;
        masterKeyOffset = 3;
        potionsLeft = 4;
        potionOffset = 4;
        
    }
    
    /**
     * Return the map
     */
    public Area[][] getMap() {
    	return map;
    }

    /**
     * Generate a room at all coordinates of the map
     */
    public void buildMap()
    {
    	int count = 0;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                if( i ==0 && j == 0){ 
                    map[0][0] = new Entrance(null);
                    map[0][0].setChallengeComplete(true);
                }
                else if (i == 0 && j == 2) {
                	Weapon sword = new Weapon("Sword", "Just an average sword. It's pretty sharp.", 1);
                	map[i][j] = new Vault("an armoury. There's only one sword left. Lucky you.", sword, false);
                }
                else if (i == 2 && j == 0) {
                	Shield shield = new Shield();
                	map[i][j] = new Vault("a big ole vault", shield, false);
                }
                else if (i == 4 && j == 2) {
                	Weapon masterSword = new Weapon("Master Sword", "Super sharp. Super shiny.", 1.5);
                	map[i][j] = new Vault("a big ole vault", masterSword, false);
                }
                else if (i == 2 && j == 4) {
                	Teleporb teleporb = new Teleporb();
                	map[i][j] = new Vault("The one true super vault. In the centre of the room sits an orb.", teleporb, true);
                }
                else if (i == 0 && j == 4 || i == 4 && j == 0 ||
                		i == 2 && j == 2 || i == 4 && j == 4) {
                	map[i][j] = new Arena(placeMasterKey());
                }	
                else if (count == 0){
                    map[i][j] = new Library(placeKey());
                    count++;
                }
                else {
                    map[i][j] = new GamesRoom(placePotion());
                    count = 0;
                }
            }
        }   
    }
    
    /**
     * Decides whether or not to place a key in a Library
     * Three keys will be placed while five Libraries will have
     * no item at all.
     */
    public Key placeKey() {
    	Random rand = new Random();
    	if(keyOffset == 0) {
    		return new Key("Key", "a plain looking old key.", false);
    	}
    	else if(rand.nextInt(keysLeft + keyOffset) < keysLeft) {
    		if(keysLeft > 0) {
    			keysLeft--;
    		}
    		return new Key("Key", "a plain looking old key.", false);
    	}
    	else {
    		if(keyOffset > 0) {
    			keyOffset--;
    		}
    		return null;
    	}
    	
    }

    /**
     * Decides whether or not to place a Master Key in
     * an Arena. Only one Master Key will be placed.
     */
    public Key placeMasterKey() {
    	Random rand = new Random();
    	if(masterKeyOffset == 0) {
    		return new Key("Master Key", "a fancy looking key.", true);
    	}
    	else if(rand.nextInt(masterKeysLeft + masterKeyOffset) < masterKeysLeft) {
    		if(masterKeysLeft > 0) {
    			masterKeysLeft--;
    		}
    		return new Key("Master Key", "a fancy looking key.", true);
    	}
    	else {
    		if(masterKeyOffset > 0) {
    			masterKeyOffset--;
    		}
    		return null;
    	}
    	
    }
    
    /**
     * Decides whether or not to place a Potion in a Games Room
     * Four Potions will be placed while four Games Rooms will have
     * no item at all.
     */
    public Potion placePotion() {
    	Random rand = new Random();
    	if(potionOffset == 0) {
    		return new Potion();
    	}
    	else if(rand.nextInt(potionsLeft + potionOffset) < potionsLeft) {
    		if(potionsLeft > 0) {
    			potionsLeft--;
    		}
    		return new Potion();
    	}
    	else {
    		if(potionOffset > 0) {
    			potionOffset--;
    		}
    		return null;
    	}   	
    }   
}
