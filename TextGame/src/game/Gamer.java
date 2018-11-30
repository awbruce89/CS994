package game;

import java.util.Random;

public class Gamer extends Creature {
	
    /**
     * Constructor for objects of class Gamer
     */
    public Gamer() {
        // initialise instance variables
        super("Gamer", "Likes a good game");

    }
    
    public boolean chooseGame() {
    	Random rand = new Random();
    	int choice = (rand.nextInt(2));
    	if(choice == 0) {
    		return rollDice();
    	}
    	else {
    		return rockPaperScissors();
    	}
    }
    
    public boolean rollDice() {
    	System.out.println("Dice roll! Highest roll wins!");
    	Random rand = new Random();
    	int playerRoll = rand.nextInt(6) + 1;
    	System.out.println("You rolled a " + playerRoll);
    	int enemyRoll = rand.nextInt(6) + 1;
    	System.out.println("Your opponent rolled a " + enemyRoll);
    	if(playerRoll >  enemyRoll) {
    		System.out.println("You win!");
    		return true;
    	}
    	else if (playerRoll == enemyRoll){
    		System.out.println("Draw!");
    		return false;
    	}
    	else {
    		System.out.println("You Lose!");
    		return false;
    	}
    }   
    
    public boolean rockPaperScissors() {
    	System.out.println("Rock! Paper! Scissors!");
    	String playerChoice = rpsChoice();
    	System.out.println("You chose " + playerChoice + "!");
    	String enemyChoice = rpsChoice();
    	System.out.println("Your opponent chose " + enemyChoice + "!");
    	if(playerChoice.equals("rock") && enemyChoice.equals("scissors")
    		|| playerChoice.equals("scissors") && enemyChoice.equals("paper")
    		|| playerChoice.equals("paper") && enemyChoice.equals("rock")) {
    		System.out.println("You win!");
    		return true;
    	}
    	else if (playerChoice.equals(enemyChoice)){
    		System.out.println("Draw!");
    		return false;
    	}
    	else {
    		System.out.println("You Lose!");
    		return false;
    	}
    }
    
    /**
     * Selects a random 
     */
    public String rpsChoice() {
    	Random rand = new Random();
    	int choice = rand.nextInt(3);
    	if(choice == 0) {
    		return "rock";
    	}
    	else if(choice == 1) {
    		return "paper";
    	}
    	else {
    		return "scissors";
    	}
    }

}
