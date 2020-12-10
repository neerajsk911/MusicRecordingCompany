package databases;
public interface dbUpdater {
	
	public String UPD_MUSICIAN_NAME="update musician set m_name = ? where m_id=?";
	public String UPD_MUSICIAN_ADDR="update musician set m_address=? where m_id=?";
	public String UPD_BAND_NAME="update band set b_name=? where band_id=?";
	public String UPD_PROD_NAME="update production set p_name=? where p_id=?";
	public String UPD_PROD_BUDGET="update production set budget=? where p_id=?";

	public String UPD_ALBUM_TITLE="update album set album_title=? where album_id=?";
	public String UPD_SONG_AUTHOR="update song set author=? where title=?";
	
	public String INCR_SONG="update singer set songs_sung=songs_sung+1 where m_id=?";
	public String INCR_COMP="update composer set song_composed=song_composed+1 where m_id=?";
	
	int updateMusicianName(String name,String id);
	int updateMusicianAddress(String address,String id);
	int updateBandName(String name,String id);
	int updateProductionName(String name,String id);
	int updateProductionBudget(int budget,String id);
	int updateAlbumTitle(String title,String id);
	int updateSongAuthor(String author,String title);
	int incrementSongs(String id);
	int incrementComposed(String id);
}
	