package databases;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {

	public Connection connection=null;
	public String url="jdbc:postgresql://localhost:5432/Music Recording Company";
	public String dbUname="postgres";
	public String dbPswrd="2001";
	
	public ConnectDB(){
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection(url,dbUname,dbPswrd);
			System.out.println("Connection Done!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}