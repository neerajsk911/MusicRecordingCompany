package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import databases.*;

public class StartAdmin extends Login implements ActionListener,Messages{
	
	JFrame adminGUIFrame=new JFrame("Music Recording Company");
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	JPanel panel6 = new JPanel();
	JPanel panel7 = new JPanel();
	JPanel panel8 = new JPanel();
	JPanel panel9 = new JPanel();
	JPanel panel10 = new JPanel();
	

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
	JMenuItem displayMusicians=new JMenuItem("Display Musicians");
	JMenuItem displayMalSongs=new JMenuItem("Display Malayalam Songs");
	JMenuItem displayLatestSongs=new JMenuItem("Display Latest Songs");
	JMenuItem maxbudget=new JMenuItem("Display Album with Max Budget");
	
	
	
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
		display.add(displayMusicians);
		display.add(displayMalSongs);
		display.add(displayLatestSongs);
		display.add(maxbudget);
		menuBar.add(display);
		
		menuBar.add(display);
		System.out.println("reached here");
	}
	
	public void frameGUI() {
		//TODO: Design the frame GUI for admin window
	}
	public void MenuEvents() {
		
		//Display Listeners
		displayMalSongs.addActionListener(this);
		displayMusicians.addActionListener(this);
		displayLatestSongs.addActionListener(this);
		maxbudget.addActionListener(this);
		
		
		
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
		case "Display Malayalam Songs":
			ReInitPanels();
			MakePanels();
			System.out.println("Disp Mal Songs");
			try {
				JTable table=new JTable(QueryEvaluator.displayMalSongs());
//				adminGUIFrame.add(new JScrollPane(table));	
				panel10.add(new JScrollPane(table));
				panel5.add(panel10, BorderLayout.CENTER);
				adminGUIFrame.add(panel5, BorderLayout.CENTER);
//				adminGUIFrame.setSize(1280,719);
				adminGUIFrame.setVisible(true);
			}
			catch (SQLException e2) {	System.err.println("Display Mal Songs Error");		}
			break;
			
			
		case "Display Latest Songs":
			ReInitPanels();
			MakePanels();
			System.out.println("Disp Latest Songs");
			try {
				JTable table=new JTable(QueryEvaluator.displayLatestsongs());
//				adminGUIFrame.add(new JScrollPane(table));		
				panel10.add(new JScrollPane(table));
				panel5.add(panel10, BorderLayout.CENTER);
				adminGUIFrame.add(panel5, BorderLayout.CENTER);
				adminGUIFrame.setSize(1280,719);
//				adminGUIFrame.setSize(1280,720);
				adminGUIFrame.setVisible(true);
			}
			catch (SQLException e2) {	System.err.println("Display Songs Error");		}
			break;
			
			
		case "Display Album with Max Budget": 
			ReInitPanels();
			MakePanels();
			System.out.println("Disp Max Budget");
			try {
				JTable table=new JTable(QueryEvaluator.maxBudget());
//				adminGUIFrame.add(new JScrollPane(table));		
				panel10.add(new JScrollPane(table));
				panel5.add(panel10, BorderLayout.CENTER);
				adminGUIFrame.add(panel5, BorderLayout.CENTER);
				adminGUIFrame.setSize(1280,719);
				adminGUIFrame.setVisible(true);
			}
			catch (SQLException e2) {	System.err.println("Display Budget Error");		}
			break;
		
		
		case "Display Musicians":
			ReInitPanels();
			MakePanels();
			try {
				JTable table=new JTable(QueryEvaluator.displayMusicians());
//				adminGUIFrame.add(new JScrollPane(table));		
				panel10.add(new JScrollPane(table));
				panel5.add(panel10, BorderLayout.CENTER);
				adminGUIFrame.add(panel5, BorderLayout.CENTER);
				adminGUIFrame.setSize(1280,719);
				adminGUIFrame.setSize(1280,720);
				adminGUIFrame.setVisible(true);
			}
			catch (SQLException e2) {	System.err.println("Display Musician Error");		}
			break;
		
		//Insert Events
		case "Add a New Production":
			
			ReInitPanels();
			MakePanels();
			
			System.out.println("Add Production");
			
			JLabel id=new JLabel("Production ID:");
			JLabel name=new JLabel("Production Name:");
			JLabel budget=new JLabel("Production Budget:");
			
			JTextField idTextField=new JTextField(10);
			JTextField nameTextField=new JTextField(10);
			JTextField budgetTextField=new JTextField(10);
			
			//Making local Instances for reusing
			{
				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");

				box.add(id);
				box.add(idTextField);
				box.add(name);
				box.add(nameTextField);
				box.add(budget);
				box.add(budgetTextField);
				box.add(submitButton);
				panel10.add(box,BorderLayout.CENTER);

				panel5.add(panel10, BorderLayout.CENTER);
				adminGUIFrame.add(panel5, BorderLayout.CENTER);
				adminGUIFrame.setVisible(true);
				submitButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						ArrayList<String>parameters=new ArrayList<>();
						parameters.add(idTextField.getText());
						parameters.add(nameTextField.getText());
						parameters.add(budgetTextField.getText());

						System.out.println("Values:"+parameters+"\nSubmit Event:Add Production Submit Button");
						int retCode=new QueryEvaluator().insertProduction(parameters);
						JLabel status=new JLabel(INS_FAIL);
						status.setForeground(Color.red);
						if(retCode==1) {
							status.setText(INS_PRD_SUCCESS);
							status.setForeground(Color.green);							
						}
						box.add(status);
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			break;
		case "Add New Album":
			ReInitPanels();
			MakePanels();
			System.out.println("Add Album");
			{
				JLabel albumID=new JLabel("Album ID:");
				JLabel albumTitle=new JLabel("Album Title:");
				JLabel copyright=new JLabel("Copyright:");
				JLabel genre=new JLabel("Genre:");
				JLabel format=new JLabel("Format:");
				JLabel prodId=new JLabel("Production ID:");
				JLabel releaseDate=new JLabel("Release Date:");

				JTextField idField=new JTextField(10);
				JTextField titleField=new JTextField(10);
				JTextField copyrightField=new JTextField(10);
				JTextField genreField=new JTextField(10);
				JTextField formatField=new JTextField(10);
				JTextField prodIdField=new JTextField(10);
				JTextField relDateField=new JTextField(10);
			
				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");

				box.add(albumID); box.add(idField); box.add(albumTitle);
				box.add(titleField); box.add(copyright); box.add(copyrightField);
				box.add(genre); box.add(genreField); box.add(format);
				box.add(formatField); box.add(prodId); box.add(prodIdField);
				box.add(releaseDate); box.add(relDateField);box.add(submitButton);

				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ArrayList<String> parameters=new ArrayList<>();
						parameters.add(idField.getText());
						parameters.add(titleField.getText());
						parameters.add(copyrightField.getText());
						parameters.add(genreField.getText());
						parameters.add(formatField.getText());
						parameters.add(prodIdField.getText());
						parameters.add(relDateField.getText());
						
						System.out.println("Parameters:"+parameters+"\nSubmit Event:Add Album Submit Button");
						JLabel status=new JLabel(INS_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().insertAlbum(parameters);
						if(retCode==1) {
							status.setText(INS_ALB_SUCCESS);
							status.setForeground(Color.green);							
						}
						box.add(status);
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			break;
			
		case "Add New Song":
			ReInitPanels();
			MakePanels();
			System.out.println("Add Song");
			{
				JLabel title=new JLabel("Song Title:");
				JLabel author=new JLabel("Author:");
				JLabel albumId=new JLabel("Album ID:");
				JLabel bandId=new JLabel("Band ID:");

				JTextField titleField=new JTextField(10);
				JTextField authorField=new JTextField(10);
				JTextField albumIdField=new JTextField(10);
				JTextField bandIdField=new JTextField(10);

				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");
				
				box.add(title);box.add(titleField);box.add(author);
				box.add(authorField);box.add(albumId);box.add(albumIdField);
				box.add(albumIdField);box.add(bandId);box.add(bandIdField);
				box.add(submitButton);
				
				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ArrayList<String>parameters=new ArrayList<>();
						parameters.add(titleField.getText());
						parameters.add(authorField.getText());
						parameters.add(albumIdField.getText());
						parameters.add(bandIdField.getText());
						
						System.out.println("Parameters:"+parameters+"\nSubmit Event:Add Song Submit Button");
						JLabel status=new JLabel(INS_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().insertSong(parameters);
						if(retCode==1) {
							status.setText(INS_SONG_SUCCESS);
							status.setForeground(Color.green);							
						}
						box.add(status);
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			break;
			
		case "Add New Musician":
			ReInitPanels();
			MakePanels();
			System.out.println("Add Musician");
			{
				JLabel MId=new JLabel("Musician ID:");
				JLabel Mname=new JLabel("Musician Name:");
				JLabel address=new JLabel("Musician Address:");

				JTextField IdField=new JTextField(10);
				JTextField nameField=new JTextField(10);
				JTextField addressField=new JTextField(10);

				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");
				
				box.add(MId);box.add(IdField);box.add(Mname);
				box.add(nameField);box.add(address);box.add(addressField);
				box.add(submitButton);
				
				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ArrayList<String>parameters=new ArrayList<>();
						parameters.add(IdField.getText());
						parameters.add(nameField.getText());
						parameters.add(addressField.getText());
						
						System.out.println("Parameters:"+parameters+"\nSubmit Event:Add Musician Submit Button");
						JLabel status=new JLabel(INS_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().insertMusician(parameters);
						if(retCode==1) {
							status.setText(INS_MUSICIAN_SUCCESS);
							status.setForeground(Color.green);							
						}
						box.add(status);
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			break;
			
		case "Add New Band":
			ReInitPanels();
			MakePanels();
			System.out.println("Add Band");
			
			{
				JLabel BId=new JLabel("Band ID:");
				JLabel Bname=new JLabel("Band Name:");

				JTextField BIdField=new JTextField(10);
				JTextField BnameField=new JTextField(10);

				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");
				
				box.add(BId);box.add(BIdField);box.add(Bname);box.add(BnameField);
				box.add(submitButton);
				
				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ArrayList<String>parameters=new ArrayList<>();
						parameters.add(BIdField.getText());
						parameters.add(BnameField.getText());
						
						System.out.println("Parameters:"+parameters+"\nSubmit Event:Add Band Submit Button");
						JLabel status=new JLabel(INS_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().insertBand(parameters);
						if(retCode==1) {
							status.setText(INS_BAND_SUCCESS);
							status.setForeground(Color.green);		
						}
						box.add(status);
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			
			break;
			
		case "Add New Singer":
			ReInitPanels();
			MakePanels();
			System.out.println("Add Singer");
			
			{
				JLabel mid=new JLabel("Singer ID(Musician ID):");
				JLabel sCount=new JLabel("Songs Sung:");
				JLabel lingual=new JLabel("Lingual:");

				JTextField midField=new JTextField(10);
				JTextField sCountField=new JTextField(10);
				JTextField lingualField=new JTextField(10);

				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");
				
				box.add(mid);box.add(midField);box.add(sCount);
				box.add(sCountField);box.add(lingual);box.add(lingualField);
				box.add(submitButton);
				
				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ArrayList<String>parameters=new ArrayList<>();
						parameters.add(midField.getText());
						parameters.add(sCountField.getText());
						parameters.add(lingualField.getText());
						
						System.out.println("Parameters:"+parameters+"\nSubmit Event:Add Singer Submit Button");
						JLabel status=new JLabel(INS_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().insertSinger(parameters);
						if(retCode==1) {
							status.setText(INS_SINGER_SUCCESS);
							status.setForeground(Color.green);							
						}
						box.add(status);
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			break;
			
		case "Add New Composer":
			ReInitPanels();
			MakePanels();
			System.out.println("Add Composer");
			
			{
				JLabel mid=new JLabel("Composer ID(Musician ID):");
				JLabel cCount=new JLabel("Songs Composed:");
				JLabel genre=new JLabel("Genre:");

				JTextField midField=new JTextField(10);
				JTextField cCountField=new JTextField(10);
				JTextField genreField=new JTextField(10);

				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");
				
				box.add(mid);box.add(midField);box.add(cCount);
				box.add(cCountField);box.add(genre);box.add(genreField);
				box.add(submitButton);
				
				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ArrayList<String>parameters=new ArrayList<>();
						parameters.add(midField.getText());
						parameters.add(cCountField.getText());
						parameters.add(genreField.getText());
						
						System.out.println("Parameters:"+parameters+"\nSubmit Event:Add Composer Submit Button");
						JLabel status=new JLabel(INS_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().insertComposer(parameters);
						if(retCode==1) {
							status.setText(INS_COMPOSER_SUCCESS);
							status.setForeground(Color.green);							
						}
						box.add(status);
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			break;
			
		case "Map the Musician of a Song":
			ReInitPanels();
			MakePanels();
			System.out.println("Map Musician-->Song");			
			{
				JLabel title=new JLabel("Song Title:");
				JLabel mId=new JLabel("Musician ID:");

				JTextField titleField=new JTextField(10);
				JTextField mIdField=new JTextField(10);

				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");
				
				box.add(title);box.add(titleField);box.add(mId);box.add(mIdField);
				box.add(submitButton);
				
				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ArrayList<String>parameters=new ArrayList<>();
						parameters.add(titleField.getText());
						parameters.add(mIdField.getText());
						
						System.out.println("Parameters:"+parameters+"\nSubmit Event:Map Nusician Submit Button");
						JLabel status=new JLabel(INS_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().insertPerformedBy(parameters);
						if(retCode==1) {
							status.setText(MAP_MUSICIAN_SUCCESS);
							status.setForeground(Color.green);							
						}
						box.add(status);
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			
			break;
			
		case "Map Song to a Language":
			ReInitPanels();
			MakePanels();
			System.out.println("Map Song-->Language");
			
			{
				JLabel title=new JLabel("Song Title(as in database):");
				JLabel lang=new JLabel("Songs Sung:");

				JTextField titleField=new JTextField(10);
				JTextField langField=new JTextField(10);

				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");
				
				box.add(title);box.add(titleField);box.add(lang);box.add(langField);
				box.add(submitButton);
				
				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ArrayList<String>parameters=new ArrayList<>();
						parameters.add(titleField.getText());
						parameters.add(langField.getText());
						
						System.out.println("Parameters:"+parameters+"\nSubmit Event:Add Song Submit Button");
						JLabel status=new JLabel(INS_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().insertSongLanguage(parameters);
						if(retCode==1) {
							status.setText(MAP_LANGUAGE_SUCCESS);
							status.setForeground(Color.green);
						}
						box.add(status);
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			
			break;
		
		//Update Events
		case "Change a Musician Name":
			ReInitPanels();
			MakePanels();
			System.out.println("Update Musician Name");
			//Copy this entire block
			{
				JLabel MId=new JLabel("Musician ID:");
				JLabel MName=new JLabel("New Name:");
				
				JTextField MIdField=new JTextField(10);
				JTextField MNameField=new JTextField(10);
				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");
				
				box.add(MId);box.add(MIdField);
				box.add(MName);box.add(MNameField);
				box.add(submitButton);
				
				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String id=MIdField.getText();
						String name=MNameField.getText();
						System.out.println("Parameters:"+id+" "+name+"\nSubmit Event:Update Musician Name Submit Button");
						
						JLabel status=new JLabel(INS_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().updateMusicianName(name, id);
						if(retCode==1) {
							status.setText(MAP_LANGUAGE_SUCCESS);
							status.setForeground(Color.green);
						}
						box.add(status);
						
						//Making changes to the frame to reflect the added status label
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
						
					}
				});
			}		//Stop copying here here
			
			break;
			
		case "Change a Musician Address":
			ReInitPanels();
			MakePanels();
			System.out.println("Update Musician Address");
			
			//Paste the copied content below this
			
			break;
			
		case "Update a Band Name":
			ReInitPanels();
			MakePanels();
			System.out.println("Update Band Name");

			//Paste the copied content below this
			
			break;
			
		case "Change Production Name":
			ReInitPanels();
			MakePanels();
			System.out.println("Update Production Name");
			
			//Paste the copied content below this
			
			break;
			
		case "Update the Budget of a Production":
			ReInitPanels();
			MakePanels();
			
			//Paste the copied content below this
			
			System.out.println("Update Budget");
			
			break;
			
		case "Change an Album Title":
			ReInitPanels();
			MakePanels();
			System.out.println("Update Album Title");
			
			//Paste the copied content below this
			
			break;
			
		case "Update the Author of a Song":
			ReInitPanels();
			MakePanels();
			System.out.println("Update Author");
			
			//Paste the copied content below this
			
			break;
		
		//Delete Events
			
	
		default:
			break;
		}
		
	}
	public void ReInitPanels() {
		panel1.removeAll();
		panel2.removeAll();
		panel3.removeAll();
		panel4.removeAll();
		panel5.removeAll();
		panel5.removeAll();
		panel7.removeAll();
		panel8.removeAll();
		panel9.removeAll();
		panel10.removeAll();
		adminGUIFrame.repaint();
	}
	
	public void MakePanels() {
		panel1.setBackground(Color.red);
		panel2.setBackground(Color.green);
		panel3.setBackground(Color.yellow);
		panel4.setBackground(Color.magenta);
		panel5.setBackground(Color.blue);
		
		panel1.setPreferredSize(new Dimension(100, 100));
		panel2.setPreferredSize(new Dimension(100, 100));
		panel3.setPreferredSize(new Dimension(100, 100));
		panel4.setPreferredSize(new Dimension(100, 100));
		panel5.setPreferredSize(new Dimension(100, 100));

		panel6.setBackground(Color.black);
		panel7.setBackground(Color.darkGray);
		panel8.setBackground(Color.gray);
		panel9.setBackground(Color.lightGray);
		panel10.setBackground(Color.white);

		panel5.setLayout(new BorderLayout());

		panel6.setPreferredSize(new Dimension(50, 50));
		panel7.setPreferredSize(new Dimension(50, 50));
		panel8.setPreferredSize(new Dimension(50, 50));
		panel9.setPreferredSize(new Dimension(50, 50));
		panel10.setPreferredSize(new Dimension(50, 50));

		panel5.add(panel6, BorderLayout.NORTH);
		panel5.add(panel7, BorderLayout.WEST);
		panel5.add(panel8, BorderLayout.EAST);
		panel5.add(panel9, BorderLayout.SOUTH);
		
		adminGUIFrame.add(panel1, BorderLayout.NORTH);
		adminGUIFrame.add(panel2, BorderLayout.WEST);
		adminGUIFrame.add(panel3, BorderLayout.EAST);
		adminGUIFrame.add(panel4, BorderLayout.SOUTH);
	}
}
