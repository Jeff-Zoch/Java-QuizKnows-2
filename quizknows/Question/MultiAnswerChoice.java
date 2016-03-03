package quizknows.Question;

import java.sql.Array;
import java.util.ArrayList;

public class MultiAnswerChoice extends Question {	
	String query;
	ArrayList<String> options;
	ArrayList<Integer> answerIndices;
	int numPoints;
	
	public MultiAnswerChoice(String query, ArrayList<String> options, ArrayList<Integer> answerIndices, int numPoints) {
		this.query = query;
		this.options = options;
		this.answerIndices = answerIndices;
		this.numPoints = numPoints;
	}
	public void setPoints(int num) {
		numPoints = num;
	}

	@Override
	public int getPoints() {
		return numPoints;
	}
	
	public boolean isCorrect(ArrayList<Integer> userIndices) {
		int numAnswers = userIndices.size();
		for(int i = 0; i < userIndices.size(); i++) {
			for(int j = 0; j < answerIndices.size(); j++) {
				if(userIndices.get(i) == answerIndices.get(j)) {
					numAnswers--;
					break;
				}
			}
		}
		return numAnswers == 0;
	}
	public void setAnswers(ArrayList<Integer> answerIndices) {
		this.answerIndices = answerIndices;
	}
	public ArrayList<String> getAnswers() {
		ArrayList<String> answers = new ArrayList<String>();
		for(int i = 0; i < answerIndices.size(); i++) {
			answers.add(options.get(answerIndices.get(i)));
		}
		return answers;
	}
	public void setOptions(ArrayList<String> op) {
		options = op;
	}
	public ArrayList<String> getOptions() {
		return options;
	}
	public void setQuestion(String q) {
		query = q;
	}
	public String getQuestion(){
		return query;
	}

	@Override
	public String getType() {
		return "MultiAnswerChoice";
	}

}
