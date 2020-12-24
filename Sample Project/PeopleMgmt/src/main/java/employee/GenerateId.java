package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GenerateId {
	public int generateEmployeeId(){
		int emp_id=0;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/people","root","Admin@12345");
			Statement stmt = conn.createStatement();
			String query="select max(emp_id) as emp_id from PEOPLE_EMPLOYEE ";
			ResultSet rs = null;
			rs = stmt.executeQuery(query);
			if(rs.next()){
				String id = rs.getString("emp_id");
				emp_id=Integer.parseInt(id);
			}
			emp_id = emp_id + 1;		
		    }
			catch(SQLException  ex){
				ex.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return emp_id;	
		}
}
