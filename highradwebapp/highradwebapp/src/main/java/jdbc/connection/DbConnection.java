package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbConnection {
	
	
	public Connection CreateC()
		{
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/grey_goose";
		String uname = "root";		
		String password = "Ananya@12345";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		
		
		try {
				try {
				
				Class.forName(driver);
				
				con = DriverManager.getConnection(url,uname,password);
				System.out.println("Db connection successfull");
			}catch( ClassNotFoundException e){
				
				e.printStackTrace();
			}
				
		}
		catch(  SQLException e) {
			e.printStackTrace();
			
		}
			
		return con;	
		}
	

}


	
