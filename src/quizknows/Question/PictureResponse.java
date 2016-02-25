package quizknows.Question;

public class PictureResponse extends Question {
	
	String image;
	String[]answers;
	int numPoints;
	
	public PictureResponse(String imageURL, String[] answers, int numPoints) {
		image = imageURL;
		this.answers = answers;
		this.numPoints = numPoints;
	}
	
	public boolean isCorrect(String answer) {
		for(int i = 0; i < answers.length; i++) {
			if(answers[i].equalsIgnoreCase(answer))return true;
		}
		return false;
	}
	
	public String getImage() {
		return image;
	}
	
	public String[] getAnswers() {
		return answers;
	}

	@Override
	public int getPoints() {
		return numPoints;
	}

	@Override
	public String getType() {
		return "PictureResponse";
	}

}
