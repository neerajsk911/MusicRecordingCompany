package databases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class QueryEvaluator extends ConnectDB implements dbUpdater,dbInsert,RecordRemover{

	public static PreparedStatement preparedStatement=null;
	public static ResultSet resultSet=null;

	public static DefaultTableModel displayTable() throws SQLException {
		
		try {
			preparedStatement=connection.prepareStatement("select * from musician");
			resultSet=preparedStatement.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buildTableModel(resultSet);	
	}
	
	//To Make a tableModel using the ResultSet
	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();
	    //ColumnNames
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }
	    //Rows of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex=1;columnIndex<=columnCount;columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }
	    return new DefaultTableModel(data,columnNames);
	}
	
	@Override
	public void insertAlbum(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
	}
	@Override
	public void insertSong(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertMusician(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertSinger(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertComposer(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertPerfomedBy(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertSongLanguage(ArrayList<String> parameters) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertProduction(ArrayList<String> parameters) {

		try {
			String idString=parameters.get(0);
			String nameString=parameters.get(1);
			int budget=Integer.parseInt(parameters.get(2));
			
			System.out.println("Inserting Production:"+idString+" "+nameString+" "+budget);
			preparedStatement=connection.prepareStatement(INS_PRODUCTION);
			preparedStatement.setString(1, idString);
			preparedStatement.setString(2, nameString);
			preparedStatement.setInt(3, budget);
			System.out.println("Insertion Status:"+preparedStatement.executeUpdate());
		}
		catch(Exception e) { System.err.println("Inserting Production Stopped due to:"+e.getMessage());}
	}
	@Override
	public void updateMusicianName(String name, String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateMusicianAddress(String address, String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateBandName(String name, String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateProductionName(String name, String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateProductionBudget(int budget, String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateAlbumTitle(String title, String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateSongAuthor(String author, String title) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void incrementSongs(String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void incrementComposed(String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteMusicianById(String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteMusicianByName(String name) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteSongByTitle(String title) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteSongByAuthor(String author) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteBandById(String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteBandByName(String name) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAlbumById(String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAlbumByTitle(String title) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAlbumByDateRange(String start, String end) {
		// TODO Auto-generated method stub
		
	}
	
}
