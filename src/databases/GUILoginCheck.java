package databases;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GUILoginCheck extends ConnectDB{
	public String query=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	public String ValidateGUILogin(String username,String password) {
		query="select privilege from loginDB where username=? and password=?";
		String result="";
		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				result=resultSet.getString("privilege");
			}
		}catch (Exception e) { 
			System.out.println(e.getMessage());
		}
		return result;
	}
}
