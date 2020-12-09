package databases;

public interface dbDisplay {
	public String DISP_MAL_SONGS="select title,author,m_name from Song s natural join SongLanguage sl "
					+ "natural join Performed_by natural join Musician where sl.Language='Malayalam'";
	
	public String DISP_LATEST_SONGS="select title,author,album_title,m_name from song natural join album "
					+ "natural join performed_by natural join musician where release_date>'31-12-2018'";
	
	public String DISP_MAX_BUDGET="select album_title,p_name,genre,budget from album natural join production "
					+ "where budget in (select max(budget) from production)";
	
}
