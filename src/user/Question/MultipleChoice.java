package quizknows.Question;

public class MultipleChoice extends Question {
	String query;
	String[] options;
	int answerIndex;
	int numPoints;
	
	public MultipleChoice(String query, String[] options, int answerIndex, int numPoints) {
		this.query = query;
		this.options = options;
		this.answerIndex = answerIndex;
		this.numPoints = numPoints;
	}

	@Override
	public int getPoints() {
		return numPoints;
	}
	
	public boolean isCorrect(int index) {
		if(index == answerIndex) return true;
		return false;
	}
	
	public String getOption(int index) {
		return options[index];
	}
	
	public String getAnswer() {
		return options[answerIndex];
	}

	@Override
	public String getType() {
		return "MultipleChoice";
	}

}
