package core;
import java.sql.SQLException;

import databases.*;
public class Terminate extends QueryEvaluator{
	public Terminate() {
		try {
			if(resultSet!=null)
				resultSet.close();
			if(preparedStatement!=null)
				preparedStatement.close();
			if(connection!=null)
				connection.close();
			System.out.println("Closed Everything");
		} catch (SQLException e) {
			System.err.println("Termination Error: "+e.getMessage());
		}
	}
}
