package quizknows.Question;

import java.sql.Array;

public class MultiAnswerChoice extends Question {	
	String query;
	String[] options;
	int[] answerIndices;
	int numPoints;
	
	public MultiAnswerChoice(String query, String[] options, int[] answerIndices, int numPoints) {
		this.query = query;
		this.options = options;
		this.answerIndices = answerIndices;
		this.numPoints = numPoints;
	}

	@Override
	public int getPoints() {
		return numPoints;
	}
	
	public boolean isCorrect(int[] userIndices) {
		int numAnswers = userIndices.length;
		for(int i = 0; i < userIndices.length; i++) {
			for(int j = 0; j < answerIndices.length; j++) {
				if(userIndices[i] == answerIndices[j]) {
					numAnswers--;
					break;
				}
			}
		}
		return numAnswers == 0;
	}
	public String[] getAnswers() {
		String[] answers = new String[answerIndices.length];
		for(int i = 0; i < answerIndices.length; i++) {
			answers[i] = options[answerIndices[i]];
		}
		return answers;
	}
	public String[] getOptions() {
		return options;
	}
	
	public String getQuestion(){
		return query;
	}

	@Override
	public String getType() {
		return "MultiAnswerChoice";
	}

}
