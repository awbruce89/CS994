package game;

import java.util.ArrayList;
import java.util.Random;

public class Puzzler extends Creature{
	
	
	private ArrayList<Question> questions;
	
    /**
     * Constructor for objects of class Puzzler
     */
    public Puzzler() {
        // initialise instance variables
        super("Puzzler", "an androgenous bipedal creature wearing a green suit covered in question marks.");
        questions = new ArrayList<>();
        questions.add(new Question("2 + 2 = 4", true));
        questions.add(new Question("3 x 3 = 12", false));
        questions.add(new Question("" , false));
    }
    
 
    /**
     * Return list of questions
     */
    public ArrayList<Question> getQuestions() {
    	return questions;
    }
    
    /**
     * Add a new question to the list of questions
     */
    public void addQuestions(Question newQuestion) {
    	questions.add(newQuestion);
    }
    
    /**
     * Choose a random question from the list of questions
     * and return that question
     */
    public Question chooseQuestion() {
    	Random rand = new Random();
    	return questions.get(rand.nextInt(questions.size()));
    }


    public boolean askQuestion(boolean answer) {
    	Question question = chooseQuestion();
    	System.out.println(question.getQuestion());
    	if(answer == question.getAnswer()) {
    		System.out.println("Correct!");
    		return true;
    	}
    	else { 
    		System.out.println("Wrong!");
    		return false;
    	}
    }
    
    
}
