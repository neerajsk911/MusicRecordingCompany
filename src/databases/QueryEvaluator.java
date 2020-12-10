package databases;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class QueryEvaluator extends ConnectDB implements dbUpdater,dbInsert,dbDisplay,RecordRemover{

	public static PreparedStatement preparedStatement=null;
	public static ResultSet resultSet=null;

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

	public static DefaultTableModel displayMalSongs() throws SQLException {

		try {
			preparedStatement=null;
			resultSet=null;
			preparedStatement=connection.prepareStatement(DISP_MAL_SONGS);
			resultSet=preparedStatement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buildTableModel(resultSet);	
	}

	public static DefaultTableModel displayMusicians() throws SQLException {

		try {
			preparedStatement=connection.prepareStatement("select * from musician");
			resultSet=preparedStatement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buildTableModel(resultSet);	
	}

	public static DefaultTableModel displayLatestsongs() throws SQLException {

		try {
			preparedStatement=null;
			resultSet=null;
			preparedStatement=connection.prepareStatement(DISP_LATEST_SONGS);
			resultSet=preparedStatement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buildTableModel(resultSet);	
	}

	public static DefaultTableModel maxBudget() throws SQLException {

		try {
			preparedStatement=null;
			resultSet=null;
			preparedStatement=connection.prepareStatement(DISP_MAX_BUDGET);
			resultSet=preparedStatement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buildTableModel(resultSet);	
	}	

	@Override
	public int insertAlbum(ArrayList<String> parameters) {
		try {
			preparedStatement=connection.prepareStatement(INS_ALBUM);
			preparedStatement.setString(1, parameters.get(0));
			preparedStatement.setString(2, parameters.get(1));
			preparedStatement.setString(3, parameters.get(2));
			preparedStatement.setString(4, parameters.get(3));
			preparedStatement.setString(5, parameters.get(4));
			preparedStatement.setString(6, parameters.get(5));
			preparedStatement.setDate(7, Date.valueOf(parameters.get(6)));

			System.out.println("Insert Album Status:"+preparedStatement.executeUpdate());

		}catch(Exception e) {System.err.println("Inserting Albums Stopped due to:"+e.getMessage()); return 0;}		

		return 1;
	}
	@Override
	public int insertSong(ArrayList<String> parameters) {
		try {
			preparedStatement=connection.prepareStatement(INS_SONG);
			preparedStatement.setString(1, parameters.get(0));
			preparedStatement.setString(2, parameters.get(1));
			preparedStatement.setString(3, parameters.get(2));
			preparedStatement.setString(4, parameters.get(3));

			System.out.println("Insert Song Status:"+preparedStatement.executeUpdate());

		}catch(Exception e) {System.err.println("Inserting Songs Stopped due to:"+e.getMessage()); return 0;}
		return 1;

	}
	@Override
	public int insertMusician(ArrayList<String> parameters) {
		try {
			preparedStatement=connection.prepareStatement(INS_MUSICIAN);
			preparedStatement.setString(1, parameters.get(0));
			preparedStatement.setString(2, parameters.get(1));
			preparedStatement.setString(3, parameters.get(2));

			System.out.println("Insert Musician Status:"+preparedStatement.executeUpdate());

		}catch(Exception e) {System.err.println("Inserting Musicians Stopped due to:"+e.getMessage()); return 0;}
		return 1;

	}
	@Override
	public int insertSinger(ArrayList<String> parameters) {
		try {
			preparedStatement=connection.prepareStatement(INS_SINGER);
			preparedStatement.setString(1, parameters.get(0));
			preparedStatement.setInt(2, Integer.parseInt(parameters.get(1)));
			preparedStatement.setString(3, parameters.get(2));

			System.out.println("Insert Musician Status:"+preparedStatement.executeUpdate());

		}catch(Exception e) {System.err.println("Inserting Singer Stopped due to:"+e.getMessage()); return 0;}
		return 1;
	}
	@Override
	public int insertComposer(ArrayList<String> parameters) {
		try {
			preparedStatement=connection.prepareStatement(INS_COMPOSER);
			preparedStatement.setString(1, parameters.get(0));
			preparedStatement.setInt(2, Integer.parseInt(parameters.get(1)));
			preparedStatement.setString(3, parameters.get(2));

			System.out.println("Insert Composer Status:"+preparedStatement.executeUpdate());

		}catch(Exception e) {System.err.println("Inserting Composer Stopped due to:"+e.getMessage()); return 0;}
		return 1;

	}
	@Override
	public int insertPerformedBy(ArrayList<String> parameters) {
		try {
			preparedStatement=connection.prepareStatement(INS_PERFORMED);
			preparedStatement.setString(1, parameters.get(0));
			preparedStatement.setString(2, parameters.get(1));

			System.out.println("Insert Performed_By Status:"+preparedStatement.executeUpdate());
			if(parameters.get(1).charAt(0)=='S') 
				incrementSongs(parameters.get(1));
			else if(parameters.get(1).charAt(0)=='C')
				incrementComposed(parameters.get(1));
		}catch(Exception e) {System.err.println("Inserting Performed_By Stopped due to:"+e.getMessage()); return 0;}
		return 1;
	}

	@Override
	public int insertBand(ArrayList<String> parameters) {
		try {
			preparedStatement=connection.prepareStatement(INS_BAND);
			preparedStatement.setString(1, parameters.get(0));
			preparedStatement.setString(2, parameters.get(1));

			System.out.println("Insert Band Status:"+preparedStatement.executeUpdate());

		}catch(Exception e) {System.err.println("Inserting Band Stopped due to:"+e.getMessage()); return 0;}
		return 1;
	}

	@Override
	public int insertSongLanguage(ArrayList<String> parameters) {
		try {
			preparedStatement=connection.prepareStatement(INS_LANGUAGE);
			preparedStatement.setString(1, parameters.get(0));
			preparedStatement.setString(2, parameters.get(1));

			System.out.println("Insert SongLanguage Status:"+preparedStatement.executeUpdate());

		}catch(Exception e) {System.err.println("Inserting SongLanguage Stopped due to:"+e.getMessage()); return 0;}
		return 1;

	}
	@Override
	public int insertProduction(ArrayList<String> parameters) {

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
		catch(Exception e) { System.err.println("Inserting Production Stopped due to:"+e.getMessage()); return 0;}
		return 1;
	}
	@Override
	public int updateMusicianName(String name, String id) {
		try {
			String newName=name;
			String MId=id;

			//For debugging
			System.out.println("Updating Musician Name:"+newName+" "+id);
			preparedStatement=connection.prepareStatement(UPD_MUSICIAN_NAME);
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, MId);
			System.out.println("Update Status:"+preparedStatement.executeUpdate());
		}
		catch(Exception e) { System.err.println("Updating Musician Name Stopped due to:"+e.getMessage()); return 0;}
		return 1;
	}
	@Override
	public int updateMusicianAddress(String address, String id) {
		try {
			String newAddress=address;
			String MId=id;

			//For debugging
			System.out.println("Updating Musician Address:"+newAddress+" "+id);
			preparedStatement=connection.prepareStatement(UPD_MUSICIAN_ADDR);
			preparedStatement.setString(1, newAddress);
			preparedStatement.setString(2, MId);
			System.out.println("Update Status:"+preparedStatement.executeUpdate());
		}
		catch(Exception e) { System.err.println("Updating Musician Address Stopped due to:"+e.getMessage()); return 0;}
		return 1;
	}
	@Override
	public int updateBandName(String bname, String bid) {
		try {
			String newName=bname;
			String BandId=bid;

			//For debugging
			System.out.println("Updating Band Name:"+newName+" "+bid);
			preparedStatement=connection.prepareStatement(UPD_BAND_NAME);
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, BandId);
			System.out.println("Update Status:"+preparedStatement.executeUpdate());
		}
		catch(Exception e) { System.err.println("Updating Band Name Stopped due to:"+e.getMessage()); return 0;}
		return 1;
	}
	@Override
	public int updateProductionName(String pname, String pid) {
		try {
			String newName=pname;
			String PId=pid;

			//For debugging
			System.out.println("Updating Production Name:"+newName+" "+pid);
			preparedStatement=connection.prepareStatement(UPD_PROD_NAME);
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, PId);
			System.out.println("Update Status:"+preparedStatement.executeUpdate());
		}
		catch(Exception e) { System.err.println("Updating Production Name Stopped due to:"+e.getMessage()); return 0;}
		return 1;
	}
	@Override
	public int updateProductionBudget(int pbudget, String pid) {
		try {
			int newBudget=pbudget;
			String PId=pid;

			//For debugging
			System.out.println("Updating Production Budget:"+newBudget+" "+pid);
			preparedStatement=connection.prepareStatement(UPD_PROD_BUDGET);
			preparedStatement.setInt(1, newBudget);
			preparedStatement.setString(2, PId);
			System.out.println("Update Status:"+preparedStatement.executeUpdate());
		}
		catch(Exception e) { System.err.println("Updating Production Budget Stopped due to:"+e.getMessage()); return 0;}
		return 1;

	}
	@Override
	public int updateAlbumTitle(String atitle, String aid) {
		try {
			//For debugging
			System.out.println("Updating Album Title:"+atitle+" "+aid);
			preparedStatement=connection.prepareStatement(UPD_ALBUM_TITLE);
			preparedStatement.setString(1, atitle);
			preparedStatement.setString(2, aid);
			System.out.println("Update Status:"+preparedStatement.executeUpdate());
		}
		catch(Exception e) { System.err.println("Updating Album Title Stopped due to:"+e.getMessage()); return 0;}
		return 1;
	}
	@Override
	public int updateSongAuthor(String author, String stitle) {
		try {
			//For debugging
			System.out.println("Updating Song Author Name:"+author+" "+stitle);
			preparedStatement=connection.prepareStatement(UPD_SONG_AUTHOR);
			preparedStatement.setString(1, author);
			preparedStatement.setString(2, stitle);
			System.out.println("Update Status:"+preparedStatement.executeUpdate());
		}
		catch(Exception e) { System.err.println("Updating Song Author Name Stopped due to:"+e.getMessage()); return 0;}
		return 1;
	}
	@Override
	public int incrementSongs(String id) {
		try {
			System.out.println("Incrementing the Songs Sung by Singer:"+id);
			preparedStatement=connection.prepareStatement(INCR_SONG);
			preparedStatement.setString(1, id);
			System.out.println("Song Sung Increment Status:"+preparedStatement.executeUpdate());
		}
		catch (Exception e) {	System.err.println("Increment Songs Stopped due to:"+e.getMessage());	}
		return 1;
	}
	@Override
	public int incrementComposed(String id) {
		try {
			System.out.println("Incrementing the Songs Composed by Composer:"+id);
			preparedStatement=connection.prepareStatement(INCR_COMP);
			preparedStatement.setString(1, id);
			System.out.println("Songs Composed Increment Status:"+preparedStatement.executeUpdate());
		}
		catch (Exception e) {	System.err.println("Increment Composed Stopped due to:"+e.getMessage());	}
		return 1;
	}
	@Override
	public int deleteMusicianById(String id) {
		try {
			String mid=id;
			//For debugging
			System.out.println("Deleting Musician by MId:"+mid);
			preparedStatement=connection.prepareStatement(DLT_MUSICIAN_BY_ID);
			preparedStatement.setString(1, mid);
			System.out.println("Delete Status:"+preparedStatement.executeUpdate());
		}
		catch(Exception e) { System.err.println("Deleting Musician by MId Stopped due to:"+e.getMessage()); return 0;}
		return 1;
	}
	@Override
	public int deleteSongByTitle(String title) {
		try {
			String stitle=title;
			//For debugging
			System.out.println("Deleting Song by Tiltle:"+stitle);
			preparedStatement=connection.prepareStatement(DLT_SONG_BY_TITLE);
			preparedStatement.setString(1, stitle);
			System.out.println("Delete Status:"+preparedStatement.executeUpdate());
		}
		catch(Exception e) { System.err.println("Deleting Song by Title Stopped due to:"+e.getMessage()); return 0;}
		return 1;
	}
	@Override
	public int deleteBandById(String id) {
		try {
			String bid=id;
			//For debugging
			System.out.println("Deleting Band by id:"+bid);
			preparedStatement=connection.prepareStatement(DLT_BAND_BY_ID);
			preparedStatement.setString(1, bid);
			System.out.println("Delete Status:"+preparedStatement.executeUpdate());
		}
		catch(Exception e) { System.err.println("Deleting Band by Id Stopped due to:"+e.getMessage()); return 0; }
		return 1;
	}
	@Override
	public int deleteAlbumById(String id) {
		try {
			String aid=id;

			//For debugging
			System.out.println("Deleting Album by id:"+aid);
			preparedStatement=connection.prepareStatement(DLT_ALBUM_BY_ID);
			preparedStatement.setString(1, aid);
			System.out.println("Delete Status:"+preparedStatement.executeUpdate());
		}
		catch(Exception e) { System.err.println("Deleting Album by Id Stopped due to:"+e.getMessage()); return 0;}
		return 1;
	}

	@Override
	public int deleteAlbumByDateRange(String start, String end) {
		try {
			//For debugging
			System.out.println("Deleting Album by date between:"+start+" and "+end);
			preparedStatement=connection.prepareStatement(DLT_ALBUM_BY_DATE_RANGE);
			preparedStatement.setDate(1, Date.valueOf(start));
			preparedStatement.setDate(2, Date.valueOf(end));

			System.out.println("Delete Status:"+preparedStatement.executeUpdate());
		}
		catch(Exception e) { System.err.println("Deleting Album by date Stopped due to:"+e.getMessage()); return 0; }
		return 1;
	}
}
