package databases;
import java.util.ArrayList;

public interface dbInsert {
	public String INS_MUSICIAN="insert into musician values (?,?,?)";	//call UpdateComposer/updateSong if the musician is a composer
	public String INS_SONG="insert into song values (?,?,?,?)";
	public String INS_ALBUM="insert into album values (?,?,?,?,?,?,?)";
	public String INS_BAND="insert into band values (?,?)";
	public String INS_SINGER="insert into singer values (?,?,?)";
	public String INS_COMPOSER="insert into composer values (?,?,?)";
	public String INS_PERFORMED="insert into performed_by values (?,?)";
	public String INS_LANGUAGE="insert into songlanguage values (?,?)";
	public String INS_PRODUCTION="insert into production values (?,?,?)";
	
	int insertAlbum(ArrayList<String>parameters);
	int insertSong(ArrayList<String>parameters);
	int insertMusician(ArrayList<String>parameters);
	int insertSinger(ArrayList<String>parameters);
	int insertComposer(ArrayList<String>parameters);
	int insertPerformedBy(ArrayList<String>parameters);
	int insertBand(ArrayList<String>parameters);
	int insertSongLanguage(ArrayList<String>parameters);
	int insertProduction(ArrayList<String>parameters);
}