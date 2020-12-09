package databases;

public interface RecordRemover {
	public String DLT_MUSICIAN_BY_ID="delete from musician where id=?";
	public String DLT_MUSICIAN_BY_NAME="delete from musician where m_name=?";
	public String DLT_SONG_BY_TITLE="delete from song where title=?";
	public String DLT_SONG_BY_AUTHOR="delete from song where author=?";
	public String DLT_BAND_BY_ID="delete from band where band_id=?";
	public String DLT_BAND_BY_NAME="delete from band where band_name=?";
	public String DLT_ALBUM_BY_ID="delete from album where album_id=?";
	public String DLT_ALBUM_BY_TITLE="delete from album where album_title=?";
	public String DLT_ALBUM_BY_DATE_RANGE="delete from album where release_date between ? and ?";
	
	void deleteMusicianById(String id);
	void deleteMusicianByName(String name);
	void deleteSongByTitle(String title);
	void deleteSongByAuthor(String author);
	void deleteBandById(String id);
	void deleteBandByName(String name);
	void deleteAlbumById(String id);
	void deleteAlbumByTitle(String title);
	void deleteAlbumByDateRange(String start,String end);
	
}
