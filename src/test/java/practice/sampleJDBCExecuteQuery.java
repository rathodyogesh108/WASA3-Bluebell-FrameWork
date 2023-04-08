package practice;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;



public class sampleJDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		//driver for database
		Driver driverRef=new Driver();
		
		//Step1:Register the driver
		
		DriverManager.registerDriver(driverRef);
		
		//Step2:get the connection from database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
		
		//step3:issue the create statement
				Statement state=con.createStatement();
		
		//step4:execute a query
	ResultSet result = state.executeQuery("select * from candidateinfo");
	while(result.next())
	{
		System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));
	}
		
		
		//step5:close the database
			con.close();
			System.out.println("db closed");

	}

}
