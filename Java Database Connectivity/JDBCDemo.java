package jdbcDemo;
import java.sql.*;	// Step 1: Load the SQL package
import java.util.Scanner;
public class JDBCDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		// Step 2: Load & Register your driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 3: Open a database connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Admin@12345");
		
		// Step 4: Create SQL Statements --> Queuries
		Statement stmt = con.createStatement();
		
		// Insert data into the database
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Movie ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Movie Name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter Movie Rating: ");
		int rating = sc.nextInt();
		
		System.out.println("Enter Movie Review: ");
		String review = sc.next();
		
		// Write insert query
		String insert_query = "insert into movies values ("+id+",'"+name+"',"+rating+",'"+review+"')";
		
		// String insert_query = "insert into movies values (101, 'Batman', 8, 'Good');
		
		
		int records = stmt.executeUpdate(insert_query);
		
		if(records == 1)
				System.out.println("Records inserted succesfully!!");
		else
			System.out.println("Insertion failed!!!");
		
		
		String update_query = "update movies set Rating = 9 where ID = 101";
		
		int no = stmt.executeUpdate(update_query);
		
		System.out.println(no+" record updated!!");
		
		String delete_query = "delete from movies where ID = 103";
		
		int deleteCount = stmt.executeUpdate(delete_query);
		
		System.out.println(deleteCount+" row deleted!!");
		
		ResultSet rs = stmt.executeQuery("select * from movies");
		
		// Step 6: Process the result
		while(rs.next()) {
			//rs.getInt(1);
			int Id = rs.getInt("ID");
			String Name = rs.getString("Name");
			int Rating = rs.getInt("Rating");
			String Review = rs.getString("Reviews");
			
			System.out.println("Movie ID: "+Id+" Name: "+Name+" Rating: "+Rating+" Review: "+Review);

	}
		// Step 7: Close connection
				rs.close();
				stmt.close();
				con.close();
	}
}
