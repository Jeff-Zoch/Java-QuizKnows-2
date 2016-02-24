package user;

import java.sql.*;

public class UserDBConnection {

	Connection con;

	static String account = UserDBInfo.MYSQL_USERNAME;
	static String password = UserDBInfo.MYSQL_PASSWORD;
	static String server = UserDBInfo.MYSQL_DATABASE_SERVER;
	static String database = UserDBInfo.MYSQL_DATABASE_NAME;

	public UserDBConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://" + server, account, password);
				Statement stmt = con.createStatement();
				stmt.executeQuery("USE " + database);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	public Statement getStatement() {
		try {
			return con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
