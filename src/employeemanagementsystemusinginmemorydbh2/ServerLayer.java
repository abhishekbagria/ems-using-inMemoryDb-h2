package employeemanagementsystemusinginmemorydbh2;

import java.sql.SQLException;
import java.util.Scanner;

public class ServerLayer {

	public void createTable() {
		try {
			CreateTable.createWithPreparedStatement();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	public void insertIntoTable(Scanner input) {
		try {
			AddEmployeeData.insertWithPreparedStatement(input);
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	public void selectFromTable() {
		try {
			ListEmployeeData.selectWithPreparedStatement();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	public void deleteFromTable(Scanner input) {
		try {
			DeleteEmployeeData.deleteWithPreparedStatement(input);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	
	public void updateIntoTable(Scanner input) {
		try {
			UpdateEmployeeData.updateWithPreparedStatement(input);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
}
