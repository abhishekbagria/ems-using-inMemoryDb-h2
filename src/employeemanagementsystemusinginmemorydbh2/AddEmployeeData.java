package employeemanagementsystemusinginmemorydbh2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class AddEmployeeData {
	
	
	
	
	
	
	public static void insertWithPreparedStatement(Scanner input) throws SQLException {
		//int empId;
		String empName;
		EmployeeData data = new EmployeeData();
		//System.out.print("Please Enter Employee ID : ");
		//empId = input.nextInt();
		//data.setEmpId(empId);
		System.out.print("Please Enter Employee Name : ");
		empName = input.next();
		data.setEmpName(empName);
		//EmployeeData data = new EmployeeData();
        Connection connection = ConnectionKeLiye.getDBConnection();
        PreparedStatement insertPreparedStatement = null;

        String InsertQuery = "INSERT INTO PERSON(name) values(?)";
        
        try {
            insertPreparedStatement = connection.prepareStatement(InsertQuery);
//            insertPreparedStatement.setInt(1, data.getEmpId());
            insertPreparedStatement.setString(1, data.getEmpName());
            insertPreparedStatement.executeUpdate();
            insertPreparedStatement.close();
            
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	connection.close();
        }
        
        
	}

}
