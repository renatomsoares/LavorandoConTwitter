import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException; 

public class ConnectionFactory {
	
    public Connection getConnection() throws SQLException, ClassNotFoundException {
       
    	//Class.forName("com.mysql.jbdc.Driver");
		//System.out.println("SQL connecting...");
    	
    	return DriverManager.getConnection("jdbc:mysql://localhost:3306/tweet","root","admin");
    }
}