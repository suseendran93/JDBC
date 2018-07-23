package javaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SampleJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Load the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Connect to database
			Connection con=DriverManager.getConnection("", "", "");
			
			//Write a SQL query
			String sql="SELECT * FROM hexaware_schema.hexaware_table";
			
			//Prepare the statement
			PreparedStatement ps=con.prepareStatement(sql);
			
			//Execute query
			ResultSet rs=ps.executeQuery();
			
			//Iterate the data
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				long phone=rs.getLong("phone");
				System.out.println(id+" "+name+" "+email+" "+phone);
				
			}
			
			//Close DB connection
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
