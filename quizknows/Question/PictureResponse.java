package quizknows.Question;

import java.util.ArrayList;

public class PictureResponse extends Question {
	
	String image;
	ArrayList<String> answers;
	int numPoints;
	
	public PictureResponse(String imageURL, ArrayList<String> answers, int numPoints) {
		image = imageURL;
		this.answers = answers;
		this.numPoints = numPoints;
	}
	
	public boolean isCorrect(String answer) {
		for(int i = 0; i < answers.size(); i++) {
			if(answers.get(i).equalsIgnoreCase(answer))return true;
		}
		return false;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImage() {
		return image;
	}
	public void setAnswers(ArrayList<String> answers) {
		this.answers  = answers;
	}
	public ArrayList<String> getAnswers() {
		return answers;
	}
	public void setPoints(int num) {
		numPoints = num;
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
