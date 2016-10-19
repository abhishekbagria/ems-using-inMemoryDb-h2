package employeemanagementsystemusinginmemorydbh2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployeeData {

	public static void updateWithPreparedStatement(Scanner input) throws SQLException{
		int empId;
		String empName;
		EmployeeData data = new EmployeeData();
		System.out.print("Please Enter Employee ID to be Updated : ");
		empId = input.nextInt();
		data.setEmpId(empId);
		System.out.print("Please Enter Employee Name to be Updated : ");
		empName = input.next();
		data.setEmpName(empName);
		System.out.print("Updating . . . .");
		Connection connection = ConnectionKeLiye.getDBConnection();
        PreparedStatement updatePreparedStatement = null;

        String UpdateQuery = "UPDATE PERSON SET name = ? WHERE id = ?";
        
        try {
            updatePreparedStatement = connection.prepareStatement(UpdateQuery);
            updatePreparedStatement.setInt(2, data.getEmpId());
            updatePreparedStatement.setString(1, data.getEmpName());
            updatePreparedStatement.executeUpdate();
            updatePreparedStatement.close();
            System.out.print("Updated . . . .");
            
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	connection.close();
        }
		
	}

}
