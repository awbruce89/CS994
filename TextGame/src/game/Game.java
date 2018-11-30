package game;

import java.util.Random;

public class Game {
	
	private Player player;
	private GameBoard gameBoard;
	private boolean gameOver;
	private Random rand;
	private int[] position;
    /**
     * Constructor for objects of class Game
     */
    public Game() {
    	player = new Player();
    	gameBoard = new GameBoard();
    	gameBoard.buildMap();
    	gameOver = false;
    	rand = new Random();
    	position = new int[2];
    }
    
    /**
     * Return game termination status
     */
    public boolean getGameOver() {
        return gameOver;
    }     
    
    /**
     * Set game termination status
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    /**
     * Return the player
     */
    public Player getPlayer() {
        return player;
    }     
    
    /**
     * Set the player
     */
    public void setPlayer(Player player) {
        this.player = player;
    } 
    
    /**
     * Return the game board
     */
    public GameBoard getGameBoard() {
        return gameBoard;
    }   
    
    /**
     * Play game
     */
    public void playGame(String cmd) {
    	if(cmd.equals("north") || cmd.equals("south") || cmd.equals("east") || cmd.equals("west")){
            movePlayer(cmd); 
        }
        else if(cmd.equals("exit") || player.getHealth() <= 0) {
        	gameOver = true;
        }
        else{
            System.out.println("That is not a recognised command!");
        }
    	gameOver = checkGameOver();
    }
    
    public boolean checkGameOver() {
    	Teleporb teleporb = new Teleporb();
    	if(player.getHealth() <= 0) {
    		System.out.println("You died sucka!");
    		return true;
    	}
    	else if(player.getInventory().contains(teleporb)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }
    
    /**
     * Check direction to move based on the 
     * input command
     */
    public void movePlayer(String cmd) {
        if(cmd.equals("north")){
            moveNorth();
        }
        else if(cmd.equals("south")){
            moveSouth();
        }
        else if(cmd.equals("east")){
            moveEast();
        }
        else if(cmd.equals("west")){
            moveWest();
        }
        else {
        	System.out.println("That is not a valid direction!");
        }
        
    }
    
    /**
     * Checks if the player is on the north side of the board
     * Checks the adjacent room to see if the challenge has been complete
     * Moves the player north by one if challenge is complete and if there is room
     */
    public void moveNorth() {
        position = player.getPosition();
        if(position[1] == (gameBoard.getMap()[0].length - 1)){
            System.out.println("Cannot move further north!");
        }
        else{
        	if(checkRoom(position[0], position[1] + 1)) {
        		position[1]++;
            	player.setPosition(position);
            	pickUpItem(position[0], position[1]);
        	}
        	else {
        		System.out.println("You failed to move north!");
        	}
        }
    }
    
    /**
     * Checks if the player is on the south side of the board
     * Checks the adjacent room to see if the challenge has been complete
     * Moves the player south by one if challenge is complete and if there is room
     */
    public void moveSouth() {
        position = player.getPosition();
        if(position[1] == 0){
            System.out.println("Cannot move further south!");
        }
        else{
        	if(checkRoom(position[0], position[1] - 1)) {
        		position[1]--;
        		player.setPosition(position);
        		pickUpItem(position[0], position[1]);
        	}
        	else {
        		System.out.println( "You failed to move south!");
        	}
        }
    }
    
    /**
     * Checks if the player is on the east side of the board
     * Checks the adjacent room to see if the challenge has been complete
     * Moves the player east by one if challenge is complete and if there is room
     */
    public void moveEast() {
        position = player.getPosition();
        if(position[0] == (gameBoard.getMap().length - 1)){
            System.out.println("Cannot move further east!");
        }
        else{
        	if(checkRoom(position[0] + 1, position[1])) {
        		position[0]++;
            	player.setPosition(position);
            	pickUpItem(position[0], position[1]);
        	}
        	else {
        		System.out.println( "You failed to move east!");
        	}
        }
    }
    
    /**
     * Checks if the player is on the west side of the board
     * Checks the adjacent room to see if the challenge has been complete
     * Moves the player west by one if challenge is complete and if there is room
     */
    public void moveWest() {
        position = player.getPosition();
        if(position[0] == 0){
            System.out.println("Cannot move further west!");
        }
        else{
        	if(checkRoom(position[0] - 1, position[1])) {
        		position[0]--;
            	player.setPosition(position);
            	pickUpItem(position[0], position[1]);
        	}
        	else {
        		System.out.println( "You failed to move west!");
        	}
        }
    }
    
    public boolean checkRoom(int x, int y) {
    	boolean success = false;
    	if(gameBoard.getMap()[x][y] instanceof Library && 
    		gameBoard.getMap()[x][y].getChallengeComplete() == false) {
    		success = libraryPuzzle(x, y);
    		gameBoard.getMap()[x][y].setChallengeComplete(success);
    		return success;
    		
    	}
    	else if(gameBoard.getMap()[x][y] instanceof GamesRoom && 
    			gameBoard.getMap()[x][y].getChallengeComplete() == false) {
    		success = gamesRoomGame(x,y);
    		gameBoard.getMap()[x][y].setChallengeComplete(success);
    		return success;
    	}
    	else if(gameBoard.getMap()[x][y] instanceof Vault && 
    		gameBoard.getMap()[x][y].getChallengeComplete() == false) {
    		Vault v = (Vault) gameBoard.getMap()[x][y];
    		success = player.useKey(v);
    		gameBoard.getMap()[x][y].setChallengeComplete(success);
    		return success;
    	}
    	else if(gameBoard.getMap()[x][y] instanceof Arena && 
    		gameBoard.getMap()[x][y].getChallengeComplete() == false) {
    		success = fight(x,y);
    		gameBoard.getMap()[x][y].setChallengeComplete(success);
    		return success;
    	}
    	else {
    		return true;
    	}
    	
    }
    
    public boolean libraryPuzzle(int x, int y) {
    	Library lib = (Library) gameBoard.getMap()[x][y];
    	int choice = rand.nextInt(2);
    	if(choice == 0 ) {
    		return lib.getPuzzler().askQuestion(true);
    	}
    	else {
    		return lib.getPuzzler().askQuestion(false);
    	}
    }
    
    public boolean gamesRoomGame(int x, int y) {
    	GamesRoom gr = (GamesRoom) gameBoard.getMap()[x][y];
    	int choice;
    		choice = rand.nextInt(2);
    		if(choice == 0 ) {
    			return gr.getGamer().chooseGame();
    		}
    		else {
    			return gr.getGamer().chooseGame();
    		}
    }
    
    public boolean fight(int x, int y) {
    	Arena a = (Arena) gameBoard.getMap()[x][y];
    	if(player.getWeapon() != null && player.getShield() != null) {
    		while(player.getHealth() > 0 && a.getEnemy().getHealth() > 0) {
    			playerFightAction(a);
    			enemyFightAction(a);
    		}
    		return true;
    	}
    	else {
    		System.out.println("Are you mad?! You haven't a weapon or shield! You'll be torn to shreds if you enter that arena!");
    		return false;
    	}
    }
    
    public void playerFightAction(Arena a) {
    	Potion potion = new Potion();
    	int choice = rand.nextInt(2);
    	player.setDefending(false);
    	if(player.getHealth() < 50 && player.getInventory().contains(potion)) {
    		player.setHealth(player.getHealth() + player.usePotion());
    		System.out.println("You use a potion and restore half of your health.");
    	}
    	else {
    		if(choice == 0) {
    			if(a.getEnemy().getDefending()) {
        			System.out.println("You attempt to attack the " + a.getEnemy().getName() + "."
        					+ " He skillfully dodges your ridiculous flailing.");
        		}
        		else{
        			int damage = player.attack();
        			a.getEnemy().setHealth(a.getEnemy().getHealth() - damage);
        	    	System.out.println("You attack the " + a.getEnemy().getName() + ", dealing "  + damage + " damage!");
        		}
    		}
    		else {
    			player.defend();
    			System.out.println("You raise your shield, ready to defend.");
    		}
    	}
    		
    }
    
    public void enemyFightAction(Arena a) {
    	int choice = rand.nextInt(2);
    	a.getEnemy().setDefending(false);
    	if(choice == 0) {
    		if(player.getDefending()) {
    			System.out.println("The " + a.getEnemy().getName() + " attempts to attack you."
    					+ " You manage to deflect the blow with your shield.");
    		}
    		else{
    			player.setHealth(player.getHealth() - a.getEnemy().attack());
    		}
    	}
    	else {
    		a.getEnemy().defend();
    		System.out.println("The " + a.getEnemy().getName() +  " begins to nimbly prance around.");
    	}
    }
    
    public void pickUpItem(int x, int y) {
    	if(gameBoard.getMap()[x][y].getItem() instanceof Weapon) {
    		player.setWeapon((Weapon) gameBoard.getMap()[x][y].getItem());
    		gameBoard.getMap()[x][y].setItem(null);
    		System.out.println("You picked up " + player.getWeapon().getDescription());
    	}
    	else if(gameBoard.getMap()[x][y].getItem() instanceof Shield) {
    		player.setShield((Shield) gameBoard.getMap()[x][y].getItem());
    		gameBoard.getMap()[x][y].setItem(null);
    		System.out.println("You picked up " + player.getShield().getDescription());
    	}
    	else if(gameBoard.getMap()[x][y].getItem() instanceof Teleporb) {
    		player.addItem(gameBoard.getMap()[x][y].getItem());
    		gameBoard.getMap()[x][y].setItem(null);
    		System.out.println("You picked up " + player.getInventory().get(player.getInventory().size() - 1).getDescription());
    	}
    	else if(gameBoard.getMap()[x][y].getItem() != null) {
        		player.addItem(gameBoard.getMap()[x][y].getItem());
        		gameBoard.getMap()[x][y].setItem(null);
        		System.out.println("You picked up " + player.getInventory().get(player.getInventory().size() - 1).getDescription());
    	}
    	else {
    		System.out.println("This room has no items.");
    	}
    }
}



