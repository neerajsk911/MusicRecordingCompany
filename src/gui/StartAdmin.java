package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class StartAdmin implements ActionListener{
	JFrame adminGUIFrame=new JFrame("Music Recording Company");

	JMenu display=new JMenu("Display");
	JMenu insert=new JMenu("Insert");
	JMenu update=new JMenu("Update");
	JMenu delete=new JMenu("Delete");
	JMenu about=new JMenu("About Us");
	
	JMenuBar menuBar=new JMenuBar();
	//Display Operations
	JMenuItem displayTable=new JMenuItem("Display a table");
	
	//Insert Operations
	JMenuItem insertProduction=new JMenuItem("Add a New Production");
	JMenuItem insertAlbum=new JMenuItem("Add New Album");
	JMenuItem insertSong=new JMenuItem("Add New Song");
	JMenuItem insertMusician=new JMenuItem("Add New Musician");
	JMenuItem insertBand=new JMenuItem("Add New Band");
	JMenuItem insertSinger=new JMenuItem("Add New Singer");	
	JMenuItem insertComposer=new JMenuItem("Add New Composer");
	JMenuItem insertPerformedBy=new JMenuItem("Map the Musician of a Song");
	JMenuItem insertSongLanguage=new JMenuItem("Map Song to a Language");
	
	
	JMenuItem updateMusicianName=new JMenuItem("Change a Musician Name");
	JMenuItem updateMusicianAddress=new JMenuItem("Change a Musician Address");
	JMenuItem updateBandName=new JMenuItem("Update a Band Name");
	JMenuItem updateProdName=new JMenuItem("Change Production Name");
	JMenuItem updateProdBudget=new JMenuItem("Update the Budget of a Production");
	JMenuItem updateAlbumTitle=new JMenuItem("Change an Album Title");
	JMenuItem updateSongAuthor=new JMenuItem("Update the Author of a Song");	
	
	JMenuItem deleteTable=new JMenuItem("Delete a table");
	
	
	public StartAdmin() {
		
		adminGUIFrame.pack();
		adminGUIFrame.setSize(860,600);
		adminGUIFrame.setLocationRelativeTo(menuBar);
		adminGUIFrame.setVisible(true);
		MenuGUI();
		
		if(Login.privilege.equals("admin")) {
					
			insert.add(insertProduction);
			insert.add(insertAlbum);
			insert.add(insertSong);
			insert.add(insertMusician);
			insert.add(insertBand);
			insert.add(insertSinger);
			insert.add(insertComposer);
			insert.add(insertPerformedBy);
			insert.add(insertSongLanguage);
			
			update.add(updateMusicianName);
			update.add(updateMusicianAddress);
			update.add(updateBandName);
			update.add(updateProdName);
			update.add(updateProdBudget);
			update.add(updateAlbumTitle);
			update.add(updateSongAuthor);

			
			delete.add(deleteTable);

			menuBar.add(insert);
			menuBar.add(update);
			menuBar.add(delete);
		}
		menuBar.add(about);
		adminGUIFrame.setJMenuBar(menuBar);
	}
	
	public void MenuGUI() {
		//TODO: Theme the menu buttons
		display.add(displayTable);
		menuBar.add(display);
		System.out.println("reached here");
	}
	
	public void frameGUI() {
		//TODO: Design the frame GUI for admin window
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
