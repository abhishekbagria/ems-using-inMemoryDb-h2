package employeemanagementsystemusinginmemorydbh2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployeeData {

	public static void deleteWithPreparedStatement(Scanner input) throws SQLException{
		int empId;
		EmployeeData data = new EmployeeData();
		System.out.print("Please Enter Employee ID to be deleted : ");
		empId = input.nextInt();
		data.setEmpId(empId);
		System.out.print("Deleting . . . .");
		Connection connection = ConnectionKeLiye.getDBConnection();
        PreparedStatement deletePreparedStatement = null;

        String DeleteQuery = "DELETE FROM PERSON WHERE id = ?";
        
        try {
            deletePreparedStatement = connection.prepareStatement(DeleteQuery);
            deletePreparedStatement.setInt(1, data.getEmpId());
            deletePreparedStatement.executeUpdate();
            deletePreparedStatement.close();
            System.out.print("Deleted . . . .");
            
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	connection.close();}		
	}

}
