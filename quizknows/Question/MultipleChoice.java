package quizknows.Question;

import java.util.ArrayList;

public class MultipleChoice extends Question {
	String query;
	ArrayList<String> options;
	int answerIndex;
	int numPoints;
	
	public MultipleChoice(String query, ArrayList<String> options, int answerIndex, int numPoints) {
		this.query = query;
		this.options = options;
		this.answerIndex = answerIndex;
		this.numPoints = numPoints;
	}
	public void setPoints(int num) {
		numPoints = num;
	}
	@Override
	public int getPoints() {
		return numPoints;
	}
	
	public boolean isCorrect(int index) {
		if(index == answerIndex) return true;
		return false;
	}
	
	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}
	public String getOption(int index) {
		return options.get(index);
	}
	
	public void setAnswer(int index) {
		answerIndex = index;
	}
	public String getAnswer() {
		return options.get(answerIndex);
	}

	@Override
	public String getType() {
		return "MultipleChoice";
	}
	public void setQuestion(String question) {
		query = question;
	}
	public String getQuestion() {
		return query;
	}

}
