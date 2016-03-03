package quizknows.Question;

import java.util.Map;

public class Matching extends Question {
	
	Map<String, String> answers;
	int numPoints;
	
	/* Matching needs a Map of  Strings to their answer strings 
	 * 
	 */
	public Matching(Map<String, String> answers, int numPoints) {
		this.answers = answers;
		this.numPoints = numPoints;
	}
	
	public boolean isCorrect(Map<String,String>users){
		int numAnswers = users.keySet().size();
		for(String key : users.keySet()) {
			if(users.get(key).equalsIgnoreCase(answers.get(key))) numAnswers--;
		}
		return numAnswers == 0;
	}
	
	public Map<String,String> getAnswers() {
		return answers;
	}
	
	public void setAnswers(Map<String, String> answers) {
		this.answers = answers;
	}
	

	@Override
	public int getPoints() {
		return numPoints;
	}
	
	public void setPoints(int points) {
		numPoints = points;
	}

	@Override
	public String getType() {
		return "Matching";
	}

}
