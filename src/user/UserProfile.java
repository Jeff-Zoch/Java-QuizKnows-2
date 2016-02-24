package user;

import java.util.*;
import java.sql.*;
import java.security.*;

public class UserProfile {
	
	private class Message{}	//stubs to suppress errors
	private class Quiz{}
	
	private String username;
	private String password;
	private int ID;
	private boolean isAdmin;
	private boolean unreadMessages;
	
	private UserDBConnection db;
	private Statement statement;
	
	//existing user
	public UserProfile(String username, String password) {
		db = new UserDBConnection();
		Statement statement = db.getStatement();
		//initExistingUser()
	}
	//TODO: figure out the flow of users? existing vs. new? Password checking?
	
	public static String hexToString(byte[] bytes) {
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			int val = bytes[i];
			val = val & 0xff; // remove higher bits, sign
			if (val < 16)
				buff.append('0'); // leading 0
			buff.append(Integer.toString(val, 16));
		}
		return buff.toString();
	}
	public String encode(String password) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
			byte[] passwordBytes = password.getBytes();
			byte[] hashBytes = md.digest(passwordBytes);
			String hash = hexToString(hashBytes);
			return hash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	private String queryPassword() {
		Statement statement = db.getStatement();
		String query = "SELECT password FROM user_profiles WHERE username='"+username+"'";
		try {
			ResultSet rs;
			rs = statement.executeQuery(query);
			rs.next();
			return rs.getString("password");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword() {
		return;
	}
	
	private int getID() {
		String query = "Select user_id FROM user_profiles WHERE username = '" + username + "'";
		ResultSet rs;
		return 0; //TODO
		
	}
	
	public ArrayList<UserProfile> getFriendsList() {
		String query = "SELECT password FROM friends_list WHERE user_id='"+getID()+"'";
		try {
			ResultSet rs;
			rs = statement.executeQuery(query);
			rs.next();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	}
	
	public ArrayList<Message> getMessages() {
		return null;
	}
	
	public HashMap<String, Integer> getHistory() {
		return null;
	}
	
	public ArrayList<Quiz> getCreatedQuizzes() {
		return null;
	}
	
	public void addCreatedQuiz(Quiz quiz) {
		return;
	}
	
	public ArrayList<String> getAchievements(int binaryCode) {
		return null;
	}
	
	public void setAchievement(int index) {
		return;
	}
}
