package databases;

public interface RecordRemover {
	public String DLT_MUSICIAN_BY_ID="delete from musician where id=?";
	public String DLT_SONG_BY_TITLE="delete from song where title=?";
	public String DLT_BAND_BY_ID="delete from band where band_id=?";
	public String DLT_ALBUM_BY_ID="delete from album where album_id=?";
	public String DLT_ALBUM_BY_DATE_RANGE="delete from album where release_date between ? and ?";
	
	int deleteMusicianById(String id);
	int deleteSongByTitle(String title);
	int deleteBandById(String id);
	int deleteAlbumById(String id);
	int deleteAlbumByDateRange(String start,String end);
	
}
