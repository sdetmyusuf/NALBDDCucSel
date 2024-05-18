package common;

import java.sql.DriverManager;

public class SQLConnectionClass {
	
	
	public static void main(String[] args) {
		
		try { 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "root");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
