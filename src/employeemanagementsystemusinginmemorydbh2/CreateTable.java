package employeemanagementsystemusinginmemorydbh2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {
	public static void createWithPreparedStatement() throws SQLException {
	        Connection connection = ConnectionKeLiye.getDBConnection();
	        PreparedStatement createPreparedStatement = null;

	        String CreateQuery = "CREATE TABLE PERSON(id int primary key auto_increment, name varchar(255))";
	        
	        try {
	            connection.setAutoCommit(false);

	            createPreparedStatement = connection.prepareStatement(CreateQuery);
	            createPreparedStatement.executeUpdate();
	            createPreparedStatement.close();
	            //connection.commit();
	            
	        } catch (SQLException e) {
	            System.out.println("Exception Message " + e.getLocalizedMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
