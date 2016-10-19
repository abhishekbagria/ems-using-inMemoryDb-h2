package employeemanagementsystemusinginmemorydbh2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionKeLiye {
	private static final String DB_DRIVER = "org.h2.Driver"; 
	private static final String DB_CONNECTION = "jdbc:h2:mem:test;";
	private static final String DB_USER = "";
	private static final String DB_PASSWORD = "";
	
	protected static Connection getDBConnection(){
		Connection dbConnection = null;
		try{
			Class.forName(DB_DRIVER);
		}
		catch(ClassNotFoundException e){
			System.out.print(e.getMessage());
		}
		try{
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		}
		catch(SQLException e){System.out.print(e.getMessage());}
				
		return dbConnection;
	}
	
}