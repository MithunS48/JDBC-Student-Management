import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{
	public Connection getConnection() {
		Connection con=null;
		try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDB","root","Mithun@48");
		System.out.println("succressfull");
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
			
			
		}
		return con;
	}
	
}