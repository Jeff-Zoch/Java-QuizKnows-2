package quizknows.Question;

public class QuestionResponse extends Question {
	
	private int numAnswers;
	private String[] answers;
	private String question;
	int pointValue;
	
	
	public QuestionResponse(String question, String[] answers, int pointValue) {
		this.question = question;
		this.answers = answers;
		numAnswers = answers.length;
		this.pointValue = pointValue;
	}
	
	@Override
	public int getPoints() {
		return pointValue;
	}

	public boolean isCorrect(String finalAnswer) {
		for(int i = 0; i < numAnswers; i++) {
			if(answers[i].equalsIgnoreCase(finalAnswer)) return true;
		}
		return false;
		
	}
	
	@Override
	public String getType() {
		return "QuestionResponse";
	}
	
	
	public String getQuestion() {
		return question;
	}

}
