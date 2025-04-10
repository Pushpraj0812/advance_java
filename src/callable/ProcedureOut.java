package callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class ProcedureOut {
	
	public static void main(String[] args)throws Exception {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance_java", "root", "root");

			CallableStatement callStmt = conn.prepareCall("{CALL marksheetOut(?)}");
			
			callStmt.registerOutParameter(1,Types.INTEGER);
			
			callStmt.execute();
			
			int resultValue = callStmt.getInt(1);
			
			System.out.println("Result from empOut stored procedure: " + resultValue);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}