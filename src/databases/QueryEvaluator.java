package databases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QueryEvaluator extends ConnectDB implements dbUpdater,dbInsert,RecordRemover{

	public PreparedStatement preparedStatement=null;
	public ResultSet resultSet=null;

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
		// TODO Auto-generated method stub
		
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
