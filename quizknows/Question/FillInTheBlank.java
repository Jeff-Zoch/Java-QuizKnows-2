package quizknows.Question;

public class FillInTheBlank extends Question {
	String beforeBlank;
	String afterBlank;
	String answer;
	int numPoints = 0;
	
	public FillInTheBlank(String beforeBlank, String afterBlank, String answer, int numPoints) {
		this.beforeBlank = beforeBlank;
		this.afterBlank = afterBlank;
		this.answer = answer;
		this.numPoints = numPoints;
	}
	public void setPoints(int num) {
		numPoints = num;
	}
	@Override
	public int getPoints() {
		return numPoints;
	}
	public boolean isCorrect(String answer) {
		if(answer.equalsIgnoreCase(this.answer)) return true;
		return false;
	}
	
	public String getQuestion() {
		String dashes = "";
		for(int i = 0; i < answer.length();i++) dashes += "_";
		return beforeBlank + dashes + afterBlank;
	}

	@Override
	public String getType() {
		return "FillInTheBlank";
	}

	

}
