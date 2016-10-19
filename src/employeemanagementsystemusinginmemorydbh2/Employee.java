package employeemanagementsystemusinginmemorydbh2;


import java.util.InputMismatchException;
import java.util.Scanner;
public class Employee {
	
	/*public static void timer(){
		for(int i=0;i<5;i++){
			for(int j=0;j<1000000000;j++){
				for(int k=0; k<1000000000;k++);
	}}}
	
	public static void processAnimate(int n){
		for(int i=0;i<n;i++){
			timer();
			System.out.print(".");
			timer();
			System.out.print(" ");
		}
	}*/
	
	//public static List<EmployeeData> employData = new ArrayList<EmployeeData>();
		
	public static void main(String []args){
		char c;
		ServerLayer sl = new ServerLayer();
		System.out.println("Creating Table. . . . .");
		sl.createTable();
		System.out.println("Table Created. . . . .");
		Scanner input = new Scanner(System.in);
	do{	
		System.out.println("***EMPLOYEE MANAGEMENT SYSTEM USING IN MEMORY DB h2***");
		System.out.println("1. ADD");
		System.out.println("2. UPDATE");
		System.out.println("3. DELETE");
		System.out.println("4. LIST");
		System.out.print("Please Enter Your Choice : ");
		
		try{
		int n = input.nextInt();
		switch(n){
			case 1:
				System.out.println("Moving to ADD");
				//processAnimate(3);
				sl.insertIntoTable(input);
				break;
			case 2:
				System.out.println("Moving to UPDATE");
				//processAnimate(3);
				sl.updateIntoTable(input);
				break;
			case 3:
				System.out.println("Moving to DELETE");
				//processAnimate(3);
				sl.deleteFromTable(input);
				break;
			case 4:
				System.out.println("Moving to LIST");
				sl.selectFromTable();
				//processAnimate(3);
				//for (EmployeeData data : employData) {
				//	System.out.println(data.getEmpName());
				//}
				break;
			default:
				System.out.print("INVALID Option");
				break;	
				}}
	catch(InputMismatchException e){
		System.out.println("\nYour Input Does Not Match the Type of Input Expected.\n\nPlease Enter an Integer Value");
	}
		
		System.out.println("\nTo Stop press Q/q?");
		c = input.next().charAt(0);
		}while( c!='Q' && c!='q');
	input.close();
	}
}
