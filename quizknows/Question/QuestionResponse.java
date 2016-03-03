package quizknows.Question;

import java.util.ArrayList;

public class QuestionResponse extends Question {
	
	private int numAnswers;
	private ArrayList<String> answers;
	private String question;
	int pointValue;
	
	
	public QuestionResponse(String question, ArrayList<String> answers, int pointValue) {
		this.question = question;
		this.answers = answers;
		numAnswers = answers.size();
		this.pointValue = pointValue;
	}
	
	public ArrayList<String> getAnswers() {
		return answers;
	}
	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}
	@Override
	public int getPoints() {
		return pointValue;
	}
	public void setPoints(int num) {
		pointValue = num;
	}

	public boolean isCorrect(String finalAnswer) {
		for(int i = 0; i < numAnswers; i++) {
			if(answers.get(i).equalsIgnoreCase(finalAnswer)) return true;
		}
		return false;
		
	}
	
	@Override
	public String getType() {
		return "QuestionResponse";
	}
	
	public void setQuestion(String newQ) {
		question = newQ;
	}
	public String getQuestion() {
		return question;
	}


}
