package database;

import java.sql.*;

import javax.swing.JOptionPane;

public class DatabaseConnector {

	public static Connection makeConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bobacoollntfinalproject?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(connection == null) {
			JOptionPane.showMessageDialog(null, "Error in making connection");
		} else {
			JOptionPane.showMessageDialog(null, "Success to connect to database");
		}
		
		return connection;
	}

}
