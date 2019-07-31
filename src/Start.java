import java.io.IOException;
import java.sql.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Start {
	public static void main(String [] args) throws IOException {
		connectDatabase();
    }
	private static void connectDatabase() {
		try{  
			Class.forName("com.mysql.jdbc.Driver").newInstance();  
			Connection con = DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Books","root","root");  
			//here Books is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from test");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+ rs.getString(2));  
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}  
}
