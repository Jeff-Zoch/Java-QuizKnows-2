package quizknows.Question;

public class MultiAnswer extends Question {
	String question;
	String[] answers;
	int numCorrectNeeded;
	boolean ordered;
	int numPoints;
	
	/* answers[] should be ordered if ordered == true
	 * 
	 */
	public MultiAnswer(String question, String[]answers, 
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
	public boolean isCorrect(String[] userAnswers) {
		int numCorrect = 0;
		if(ordered) {
			for(int i = 0; i < userAnswers.length; i++) {
				if(answers[i].equalsIgnoreCase(userAnswers[i])) numCorrect++;
			}
		} else {
			for(int j = 0; j < userAnswers.length; j++) {
				for(int z = 0; z < answers.length; z++) {
					if(userAnswers[j].equalsIgnoreCase(answers[z])) {
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
	
	public boolean isOrdered(){
		return ordered;
	}
	public int numCorrectNeeded() {
		return numCorrectNeeded;
	}
	public String getQuestion(){
		return question;
	}
	public String[] getAnswers() {
		return answers;
	}

}
