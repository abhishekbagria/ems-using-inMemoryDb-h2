package employeemanagementsystemusinginmemorydbh2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ListEmployeeData {

	public static void selectWithPreparedStatement() throws SQLException {
        Connection connection = ConnectionKeLiye.getDBConnection();
        PreparedStatement selectPreparedStatement = null;

        String SelectQuery = "select * from PERSON";
        
        try {
            //connection.setAutoCommit(false);
            selectPreparedStatement = connection.prepareStatement(SelectQuery);
            ResultSet rs = selectPreparedStatement.executeQuery();
            System.out.println("H2 In-Memory Database inserted through PreparedStatement");
            while (rs.next()) {
                System.out.println("Id " + rs.getInt("id") + " Name " + rs.getString("name"));
            }
            selectPreparedStatement.close();
            
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
        	connection.close();
        }
}
}
