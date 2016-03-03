package Quiz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import quizknows.Question.Question;

public class Quiz {
	private String creator;
	private String createDate;
	private int UNIXCreateTime;
	private int highScore;
	public String description;
	public String XML;
	public ArrayList<Question> questions;
	public Map<String, QuizUser> map;
	public Quiz(ArrayList<Question> questions, String creator,
			String createDate, int UNIXcreationTime, String description) {
		this.questions = questions;
		this.creator = creator;
		this.createDate = createDate;
		this.description = description;	
		UNIXCreateTime = UNIXcreationTime;
	}
	public String getCreator() {
		return creator;
	}
	public void updateUser(String name, QuizUser user) {
		map.put(name, user);
	}
	public QuizUser getQuizUser(String name) {
		return map.get(name);
	}
	public void setXML(String XML) {
		this.XML = XML;
	}
	public String getXML() {
		return XML;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public int getHighScore() {
		highScore = 0;
		for(String user: map.keySet()) {
			QuizUser quizzer = map.get(user);
			if(quizzer.getHighScore() > highScore) highScore = quizzer.getHighScore();
		}
		return highScore;
	}
	
	public Set<QuizUser> getTopPerformersAllTime(int num) {
		Set<QuizUser> performers = new HashSet<QuizUser>();
		int size = 0;
		QuizUser lowest = null;
		for(String user: map.keySet()) {
			QuizUser quizzer = map.get(user);
			if(lowest == null || quizzer.getHighScore() > lowest.getHighScore()) {
				size++;
				performers.add(quizzer);
				if(size > num) { 
					performers.remove(lowest);
					lowest = quizzer;
					for(QuizUser temp: performers) {
						if(temp.getHighScore() < lowest.getHighScore()) lowest = temp;
					}
				}
			}
		}
		return performers;
	}
	public Set<QuizUser> getRecentTopPerformers(String takenAfter, int num) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH);
		LocalDate dateAfter = LocalDate.parse(takenAfter, formatter);
		Set<QuizUser> performers = new HashSet<QuizUser>();
		int size = 0;
		QuizUser lowest = null;
		for(String user: map.keySet()) {
			QuizUser quizzer = map.get(user);
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH);
			LocalDate dateTaken = LocalDate.parse(quizzer.getDateOfHighScore(), formatter2);
			if(lowest == null || quizzer.getHighScore() > lowest.getHighScore() && dateTaken.isAfter(dateAfter)) {
				size++;
				performers.add(quizzer);
				if(size > num) { 
					performers.remove(lowest);
					lowest = quizzer;
					for(QuizUser temp: performers) {
						if(temp.getHighScore() < lowest.getHighScore()) lowest = temp;
					}
				}
			}
		}
		return performers;
	}
	
	public int numTaken() {
		int num = 0;
		for(String user: map.keySet()) {
			QuizUser quizzer = map.get(user);
			num += quizzer.numAttempts();
		}
		return num;
	}
	public String dateCreated() {
		return createDate;
	}
	public int UNIXtimeCreated() {
		return UNIXCreateTime;
	}
	public Set<QuizUser> getRecentParticipants(String date, int num) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH);
		LocalDate dateAfter = LocalDate.parse(date, formatter);
		Set<QuizUser> performers = new HashSet<QuizUser>();
		for(String user: map.keySet()) {
			QuizUser quizzer = map.get(user);
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH);
			LocalDate dateTaken = LocalDate.parse(quizzer.mostRecentAttempt(), formatter2);
			if( dateTaken.isAfter(dateAfter) && performers.size() < num) {
				performers.add(quizzer);
			}
		}
		return performers;
		
	}
}
