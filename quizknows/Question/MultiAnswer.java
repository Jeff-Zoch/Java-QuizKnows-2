package quizknows.Question;

import java.util.ArrayList;

public class MultiAnswer extends Question {
	String question;
	ArrayList<String> answers;
	int numCorrectNeeded;
	boolean ordered;
	int numPoints;
	
	/* answers[] should be ordered if ordered == true
	 * 
	 */
	public MultiAnswer(String question, ArrayList<String>answers, 
			int numberCorrectNeeded, boolean ordered, int numPoints) {
		this.question = question;
		this.answers = answers;
		this.numCorrectNeeded = numberCorrectNeeded;
		this.ordered = ordered;
	}

	@Override
	public int getPoints() {
		return numPoints;
	}
	
	public void setPoints(int points) {
		numPoints = points;
	}
	public boolean isCorrect(ArrayList<String> userAnswers) {
		int numCorrect = 0;
		if(ordered) {
			for(int i = 0; i < userAnswers.size(); i++) {
				if(answers.get(i).equalsIgnoreCase(userAnswers.get(i))) numCorrect++;
			}
		} else {
			for(int j = 0; j < userAnswers.size(); j++) {
				for(int z = 0; z < answers.size(); z++) {
					if(userAnswers.get(j).equalsIgnoreCase(answers.get(z))) {
						numCorrect++;
						break;
					}
				}
			}
		}
		return numCorrect >= numCorrectNeeded;
	}

	@Override
	public String getType() {
		return "MultiAnswer";
	}
	
	public void setOrdered(boolean order) {
		ordered = order;
	}
	public boolean isOrdered(){
		return ordered;
	}
	
	public void setNumCorrectNeeded(int num) {
		numCorrectNeeded = num;
	}
	public int numCorrectNeeded() {
		return numCorrectNeeded;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestion(){
		return question;
	}
	
	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}
	public ArrayList<String> getAnswers() {
		return answers;
	}

}
