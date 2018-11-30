package game;

public class Question {
	
	private String question;
	private boolean answer;
    /**
     * Constructor for objects of class Game
     */
    public Question(String question, boolean answer) {
    	this.question = question;
    	this.answer = answer;
    }
    
    /**
     * Return question
     */
    public String getQuestion() {
        return question;
    }     
    
    /**
     * Set question
     */
    public void setQuestion(String question) {
        this.question = question;
    }
    
    /**
     * Return answer
     */
    public boolean getAnswer() {
        return answer;
    }     
    
    /**
     * Set answer
     */
    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
    
    

}
