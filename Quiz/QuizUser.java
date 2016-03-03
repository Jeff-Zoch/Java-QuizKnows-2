package Quiz;

import java.util.ArrayList;


public class QuizUser {
	String name;
	ArrayList<Integer> scores = new ArrayList<>();
	ArrayList<String> datesTaken = new ArrayList<>();
	ArrayList<Integer> timePerAttempt = new ArrayList<>();
	ArrayList<Integer> UNIXtimepassed = new ArrayList<>();
	int highScoreIndex;
	
	public QuizUser(String name) {
		this.name = name;
	}
	public void changeName(String name) {
		this.name = name;
	}
	public String mostRecentAttempt() {
		return datesTaken.get(datesTaken.size() - 1);
	}
	public int mostRecentScore() {
		return scores.get(scores.size() - 1);
	}
	public void addScore(int score, String date, int timeTaken, int UNIXtime) {
		scores.add(score);
		datesTaken.add(date);
		timePerAttempt.add(timeTaken);
		UNIXtimepassed.add(UNIXtime);
	}
	public QuizUser(String name, ArrayList<String> datesTaken,
			ArrayList<Integer> UNIXtimepassed,ArrayList<Integer> timePerAttempt) {
		this.name = name;
		this.datesTaken = datesTaken;
		this.UNIXtimepassed = UNIXtimepassed;
		this.timePerAttempt = timePerAttempt;
	}
	
	public int numAttempts() {
		return scores.size();
	}
	public int getUNIXHighScore() {
		getHighScore();
		return UNIXtimepassed.get(highScoreIndex);
	}
	public int getHighScore(){
		int high = 0;
		int index = 0;
		for(int score : scores) {
			index++;
			if(score > high) {
				high = score;
				highScoreIndex = index;
			}
		}
		return high;
	}
	public int getTimeTakenForHighScore() {
		getHighScore();
		return timePerAttempt.get(highScoreIndex);
	}
	public String getDateOfHighScore() {
		getHighScore();
		return datesTaken.get(highScoreIndex);
	}
	public String getName() {
		return name;
	}
	

}
