package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import databases.*;

public class StartAdmin extends Login implements ActionListener{
	
	JFrame adminGUIFrame=new JFrame("Music Recording Company");

	JMenu display=new JMenu("Display");
	JMenu insert=new JMenu("Insert");
	JMenu update=new JMenu("Update");
	JMenu delete=new JMenu("Delete");
	JMenu about=new JMenu("About Us");
	
	ImageIcon addSongIcon=new ImageIcon(AddSongIcon);	
	ImageIcon addMusicianIcon=new ImageIcon(MusicianIcon);
	ImageIcon addAlbumIcon=new ImageIcon(AlbumIcon);
	ImageIcon addBandIcon=new ImageIcon(BandIcon);
	ImageIcon addSingerIcon=new ImageIcon(SingerIcon);
	ImageIcon addComposerIcon=new ImageIcon(ComposerIcon);
	ImageIcon addProductionIcon=new ImageIcon(ProductionIcon);
	ImageIcon addLanguageIcon=new ImageIcon(LanguageIcon);
	ImageIcon addMusicianSingerIcon=new ImageIcon(MusicianSongIcon);
	ImageIcon updateBandIcon=new ImageIcon(BoomboxIcon);
	ImageIcon updateAddressIcon=new ImageIcon(AddressIcon);
	ImageIcon updateMusicianNameIcon=new ImageIcon(MusicianNameIcon);
	ImageIcon updateBudgetIcon=new ImageIcon(BudgetIcon);
	ImageIcon updateAuthorIcon=new ImageIcon(AuthorIcon);
	ImageIcon updateAlbumTitleIcon=new ImageIcon(AlbumTitleIcon);
	ImageIcon updateProductionNameIcon=new ImageIcon(Production2Icon);
	
	JMenuBar menuBar=new JMenuBar(); 
	//Display Operations
	JMenuItem displayTable=new JMenuItem("Display a table");
	
	//Insert Operations
	JMenuItem insertProduction=new JMenuItem("Add a New Production",addProductionIcon);
	JMenuItem insertAlbum=new JMenuItem("Add New Album",addAlbumIcon);
	JMenuItem insertSong=new JMenuItem("Add New Song",addSongIcon);
	JMenuItem insertMusician=new JMenuItem("Add New Musician",addMusicianIcon);
	JMenuItem insertBand=new JMenuItem("Add New Band",addBandIcon);
	JMenuItem insertSinger=new JMenuItem("Add New Singer",addSingerIcon);	
	JMenuItem insertComposer=new JMenuItem("Add New Composer",addComposerIcon);
	JMenuItem insertPerformedBy=new JMenuItem("Map the Musician of a Song",addMusicianSingerIcon);
	JMenuItem insertSongLanguage=new JMenuItem("Map Song to a Language",addLanguageIcon);
	
	//Update Operations
	JMenuItem updateMusicianName=new JMenuItem("Change a Musician Name",updateMusicianNameIcon);
	JMenuItem updateMusicianAddress=new JMenuItem("Change a Musician Address",updateAddressIcon);
	JMenuItem updateBandName=new JMenuItem("Update a Band Name",updateBandIcon);
	JMenuItem updateProdName=new JMenuItem("Change Production Name",updateProductionNameIcon);
	JMenuItem updateProdBudget=new JMenuItem("Update the Budget of a Production",updateBudgetIcon);
	JMenuItem updateAlbumTitle=new JMenuItem("Change an Album Title",updateAlbumTitleIcon);
	JMenuItem updateSongAuthor=new JMenuItem("Update the Author of a Song",updateAuthorIcon);	
	
	//Delete Operations
	JMenuItem deleteTable=new JMenuItem("Delete a table");
		
	public StartAdmin() {
		
		frame.setVisible(false);
		adminGUIFrame.setIconImage(icon);
		adminGUIFrame.pack();
		adminGUIFrame.setSize(1280,720);
		adminGUIFrame.setLocationRelativeTo(menuBar);
		adminGUIFrame.setVisible(true);
		MenuGUI();
		
		if(privilege.equals("admin")) {
					
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
		MenuEvents();
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
	public void MenuEvents() {
		
		//Display Listeners
		displayTable.addActionListener(this);
		
		//Insert Listeners
		insertProduction.addActionListener(this);
		insertAlbum.addActionListener(this);
		insertSong.addActionListener(this);
		insertMusician.addActionListener(this);
		insertBand.addActionListener(this);
		insertSinger.addActionListener(this);
		insertComposer.addActionListener(this);
		insertPerformedBy.addActionListener(this);
		insertSongLanguage.addActionListener(this);
		
		//Update Listeners
		updateMusicianName.addActionListener(this);
		updateMusicianAddress.addActionListener(this);
		updateBandName.addActionListener(this);
		updateProdName.addActionListener(this);
		updateProdBudget.addActionListener(this);
		updateAlbumTitle.addActionListener(this);
		updateSongAuthor.addActionListener(this);
		
		//Delete Listeners
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e){

		String ActionCommand=e.getActionCommand();
		
		switch (ActionCommand) {
		
		//Display Events
		case "Display a table":
			try {
				JTable table=new JTable(QueryEvaluator.displayTable());
				adminGUIFrame.add(new JScrollPane(table));				
				adminGUIFrame.setSize(1280,719);
			}
			catch (SQLException e2) {	System.err.println("Display Musician Error");		}
			break;
		
		//Insert Events
		case "Add a New Production":
			System.out.println("Add Production");
			
			break;
			
		case "Add New Album":
			System.out.println("Add Album");
			
			break;
			
		case "Add New Song":
			System.out.println("Add Song");
			
			break;
			
		case "Add New Musician":
			System.out.println("Add Musician");
			
			break;
			
		case "Add New Band":
			System.out.println("Add Band");
			
			break;
			
		case "Add New Singer":
			System.out.println("Add Singer");
			
			break;
			
		case "Add New Composer":
			System.out.println("Add Composer");
			
			break;
			
		case "Map the Musician of a Song":
			System.out.println("Map Musician-->Song");
			
			break;
			
		case "Map Song to a Language":
			System.out.println("Map Song-->Language");
			
			break;
		
		//Update Events
		case "Change a Musician Name":
			System.out.println("Update Musician Name");
			
			break;
			
		case "Change a Musician Address":
			System.out.println("Update Musician Address");
			
			break;
			
		case "Update a Band Name":
			System.out.println("Update Band Name");
			
			break;
			
		case "Change Production Name":
			System.out.println("Update Production Name");
			
			break;
			
		case "Update the Budget of a Production":
			System.out.println("Update Budget");
			
			break;
			
		case "Change an Album Title":
			System.out.println("Update Album Title");
			
			break;
			
		case "Update the Author of a Song":
			System.out.println("Update Author");
			
			break;
		
		//Delete Events
			
	
		default:
			break;
		}
		
	}
}
