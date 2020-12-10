package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.SwingConstants;
import javax.swing.Timer;

import core.Terminate;
import databases.*;

public class StartAdmin extends Login implements ActionListener,Messages{

	JFrame adminGUIFrame=new JFrame("Music Recording Company");
	static boolean AdminGUIState=false;		//Status of the Window in adminGUIFrame

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

	ImageIcon InitbgImage=new ImageIcon(WelcomeToMusicRec);
	JLabel initBg=new JLabel(InitbgImage);

	JLabel aboutBg=new JLabel(new ImageIcon(AboutUs));

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

	ImageIcon logoutIcon=new ImageIcon(LogoutIcon);

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
	JMenuItem deleteMusician=new JMenuItem("Delete a Musician");
	JMenuItem deleteSong=new JMenuItem("Delete a Song");
	JMenuItem deleteBand=new JMenuItem("Delete a Band");
	JMenuItem deleteAlbumbyid=new JMenuItem("Delete an Album by id");
	JMenuItem deleteAlbumbydate=new JMenuItem("Delete an Album by date");

	JMenuItem abtUs=new JMenuItem("About Us");

	public StartAdmin() {
		frame.setVisible(false);
		if(!AdminGUIState)
			frameGUI();
		adminGUIFrame.setIconImage(icon);
		adminGUIFrame.pack();
		adminGUIFrame.setSize(1280,720);
		adminGUIFrame.setLocationRelativeTo(menuBar);
		adminGUIFrame.setVisible(true);
		
		adminGUIFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				new Terminate();
				System.exit(0);
		  }
		});
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

			delete.add(deleteMusician);
			delete.add(deleteSong);
			delete.add(deleteBand);
			delete.add(deleteAlbumbyid);
			delete.add(deleteAlbumbydate);
			
			menuBar.add(insert);
			menuBar.add(update);
			menuBar.add(delete);
		}
		
		menuBar.add(about);
		adminGUIFrame.setJMenuBar(menuBar);
		MenuEvents();
	}

	public void MenuGUI() {
		
		//Local User Accessible Contents
		display.add(displayMusicians);
		display.add(displayMalSongs);
		display.add(displayLatestSongs);
		display.add(maxbudget);
		menuBar.add(display);
		about.add(abtUs);

		menuBar.add(display);
		System.out.println("reached here");
	}

	public void frameGUI() {
		//Checks for the status of the Welcome window in adminGUIFrame
		if(AdminGUIState==false) {
			AdminGUIState=true;
			adminGUIFrame.add(initBg);
		}
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
		deleteMusician.addActionListener(this);
		deleteSong.addActionListener(this);
		deleteBand.addActionListener(this);
		deleteAlbumbyid.addActionListener(this);
		deleteAlbumbydate.addActionListener(this);

		//About Listener
		abtUs.addActionListener(this);
		abtUs.setActionCommand("About");
	}

	@Override
	public void actionPerformed(ActionEvent e){

		String ActionCommand=e.getActionCommand();

		switch (ActionCommand) {

		//Display Events
		case "Display Malayalam Songs":
			ReInitPanels();
			MakePanels("nothing");
			BlackPanels();
			System.out.println("Disp Mal Songs");
			try {
				JTable table=new JTable(QueryEvaluator.displayMalSongs());
				//				adminGUIFrame.add(new JScrollPane(table));	
				JLabel panelOutTop=new JLabel(new ImageIcon(MalPanOutTop));
				panel1.add(panelOutTop);

				JLabel panelOutLeft=new JLabel(new ImageIcon(MalPanOutLeft));
				panel2.add(panelOutLeft);

				JLabel panelOutRight=new JLabel(new ImageIcon(MalPanOutRight));
				panel3.add(panelOutRight);

				JLabel panelOutBottom=new JLabel(new ImageIcon(MalPanOutBottom));
				panel4.add(panelOutBottom);

				JLabel panelInTop=new JLabel(new ImageIcon(MalPanInTop),SwingConstants.CENTER);
				panel6.add(panelInTop);

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
			MakePanels("nothing");
			BlackPanels();
			System.out.println("Disp Latest Songs");
			try {
				JTable table=new JTable(QueryEvaluator.displayLatestsongs());
				//				adminGUIFrame.add(new JScrollPane(table));	

				JLabel panelOutTop=new JLabel(new ImageIcon(LatPanOutTop));
				panel1.add(panelOutTop);

				JLabel panelOutLeft=new JLabel(new ImageIcon(LatPanOutLeft));
				panel2.add(panelOutLeft);

				JLabel panelOutRight=new JLabel(new ImageIcon(LatPanOutRight));
				panel3.add(panelOutRight);

				JLabel panelOutBottom=new JLabel(new ImageIcon(LatPanOutBottom));
				panel4.add(panelOutBottom);

				JLabel panelInTop=new JLabel(new ImageIcon(LatPanInTop));
				panel6.add(panelInTop);

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
			MakePanels("Display Album with Max Budget");
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
			MakePanels("Display Musicians");
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
			MakePanels("Add a New Production");

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

						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();

						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			break;
		case "Add New Album":
			ReInitPanels();
			MakePanels("Add New Album");
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

						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();

						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			break;

		case "Add New Song":
			ReInitPanels();
			MakePanels("nothing");
			BlackPanels();
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

				title.setForeground(Color.white);
				author.setForeground(Color.white);
				albumId.setForeground(Color.white);
				bandId.setForeground(Color.white);

				title.setFont(new Font("Chiller",Font.PLAIN,24));
				author.setFont(new Font("Chiller",Font.PLAIN,24));
				albumId.setFont(new Font("Chiller",Font.PLAIN,24));
				bandId.setFont(new Font("Chiller",Font.PLAIN,24));

				box.add(Box.createVerticalStrut(30));
				box.add(title);
				box.add(Box.createVerticalStrut(5));
				box.add(titleField);
				box.add(Box.createVerticalStrut(20));
				box.add(author);
				box.add(Box.createVerticalStrut(5));
				box.add(authorField);
				box.add(Box.createVerticalStrut(20));
				box.add(albumId);
				box.add(Box.createVerticalStrut(5));
				box.add(albumIdField);
				box.add(Box.createVerticalStrut(20));
				box.add(bandId);
				box.add(Box.createVerticalStrut(5));
				box.add(bandIdField);
				box.add(Box.createVerticalStrut(20));
				box.add(submitButton);

				JLabel panelOutTop=new JLabel(new ImageIcon(InsSongPanOutTop));
				panel1.add(panelOutTop);

				JLabel panelOutLeft=new JLabel(new ImageIcon(InsSongPanOutLeft));
				panel2.add(panelOutLeft);

				JLabel panelOutRight=new JLabel(new ImageIcon(InsSongPanOutRight));
				panel3.add(panelOutRight);

				JLabel panelOutBottom=new JLabel(new ImageIcon(InsSongPanOutBottom));
				panel4.add(panelOutBottom);

				JLabel panelInTop=new JLabel(new ImageIcon(InsSongPanInTop));
				panel6.add(panelInTop);

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

						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();

						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			break;

		case "Add New Musician":
			ReInitPanels();
			MakePanels("Add New Musician");
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


						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();


						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			break;

		case "Add New Band":
			ReInitPanels();
			MakePanels("Add New Band");
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

						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();

						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}

			break;

		case "Add New Singer":
			ReInitPanels();
			MakePanels("Add New Singer");
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

						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();

						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			break;

		case "Add New Composer":
			ReInitPanels();
			MakePanels("Add New Composer");
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

						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();

						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			break;

		case "Map the Musician of a Song":
			ReInitPanels();
			MakePanels("Map the Musician of a Song");
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

						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();

						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}

			break;

		case "Map Song to a Language":
			ReInitPanels();
			MakePanels("Map Song to a Language");
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

						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();

						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
					}
				});
			}
			break;

			//Update Events
		case "Change a Musician Name":
			ReInitPanels();
			MakePanels("Change a Musician Name");
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

						JLabel status=new JLabel(UPD_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().updateMusicianName(name, id);
						if(retCode==1) {
							status.setText(UPD_MUS_NAME_SUCCESS);
							status.setForeground(Color.green);
						}
						box.add(status);

						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();

						//Making changes to the frame to reflect the added status label
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);

					}
				});
			}		//Stop copying here here

			break;

		case "Change a Musician Address":
			ReInitPanels();
			MakePanels("Change a Musician Address");
			System.out.println("Update Musician Address");

			//Paste the copied content below this

			{
				JLabel MId=new JLabel("Musician ID:");
				JLabel MAddress=new JLabel("New Address:");

				JTextField MIdField=new JTextField(10);
				JTextField MAddressField=new JTextField(10);
				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");

				box.add(MId);box.add(MIdField);
				box.add(MAddress);box.add(MAddressField);
				box.add(submitButton);

				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				submitButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String id=MIdField.getText();
						String address=MAddressField.getText();
						System.out.println("Parameters:"+id+" "+address+"\nSubmit Event:Update Musician Address Submit Button");

						JLabel status=new JLabel(UPD_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().updateMusicianAddress(address, id);
						if(retCode==1) {
							status.setText(UPD_MUS_ADDR_SUCCESS);
							status.setForeground(Color.green);
						}
						box.add(status);
						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();
						//Making changes to the frame to reflect the added status label
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);

					}
				});
			}

			break;

		case "Update a Band Name":
			ReInitPanels();
			MakePanels("Update a Band Name");
			System.out.println("Update Band Name");

			//Paste the copied content below this

			{
				JLabel BandId=new JLabel("Band ID:");
				JLabel BandName=new JLabel("New Name:");

				JTextField BandIdField=new JTextField(10);
				JTextField BandNameField=new JTextField(10);
				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");

				box.add(BandId);box.add(BandIdField);
				box.add(BandName);box.add(BandNameField);
				box.add(submitButton);

				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				submitButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String bid=BandIdField.getText();
						String bname=BandNameField.getText();
						System.out.println("Parameters:"+bid+" "+bname+"\nSubmit Event:Update Band Name Submit Button");

						JLabel status=new JLabel(UPD_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().updateBandName(bname, bid);
						if(retCode==1) {
							status.setText(UPD_BAND_NAME_SUCCESS);
							status.setForeground(Color.green);
						}
						box.add(status);
						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();
						//Making changes to the frame to reflect the added status label
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);

					}
				});
			}

			break;

		case "Change Production Name":
			ReInitPanels();
			MakePanels("nothing");
			BlackPanels();
			System.out.println("Update Production Name");

			//Paste the copied content below this

			{
				JLabel PId=new JLabel("Production ID:");
				JLabel PName=new JLabel("New Name:");

				PId.setForeground(Color.white);
				PName.setForeground(Color.white);
				PId.setFont(new Font("Chiller",Font.PLAIN,26));
				PName.setFont(new Font("Chiller",Font.PLAIN,26));
				
				JTextField PIdField=new JTextField(10);
				JTextField PNameField=new JTextField(10);
				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");
				
				box.add(Box.createVerticalStrut(30));
				box.add(PId);
				box.add(Box.createVerticalStrut(5));
				box.add(PIdField);
				box.add(Box.createVerticalStrut(20));
				box.add(PName);
				box.add(Box.createVerticalStrut(5));
				box.add(PNameField);
				box.add(Box.createVerticalStrut(20));
				box.add(submitButton);

				panel10.add(box);

				JLabel panelOutTop=new JLabel(new ImageIcon(UpdProdPanOutTop));
				panel1.add(panelOutTop);

				JLabel panelOutLeft=new JLabel(new ImageIcon(UpdProdPanOutLeft));
				panel2.add(panelOutLeft);

				JLabel panelOutRight=new JLabel(new ImageIcon(UpdProdPanOutRight));
				panel3.add(panelOutRight);

				JLabel panelOutBottom=new JLabel(new ImageIcon(UpdProdPanOutBottom));
				panel4.add(panelOutBottom);

				JLabel panelInTop=new JLabel(new ImageIcon(UpdProdPanInTop));
				panel6.add(panelInTop);
				
				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				submitButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String pid=PIdField.getText();
						String pname=PNameField.getText();
						System.out.println("Parameters:"+pid+" "+pname+"\nSubmit Event:Update Production Name Submit Button");

						JLabel status=new JLabel(UPD_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().updateProductionName(pname, pid);
						if(retCode==1) {
							status.setText(UPD_PROD_NAME_SUCCESS);
							status.setForeground(Color.green);
						}
						box.add(status);
						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();
						//Making changes to the frame to reflect the added status label
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);

					}
				});
			}

			break;

		case "Update the Budget of a Production":
			ReInitPanels();
			MakePanels("Update the Budget of a Production");

			//Paste the copied content below this

			{
				JLabel PId=new JLabel("P ID:");
				JLabel PBudget=new JLabel("New Budget:");

				JTextField PIdField=new JTextField(10);
				JTextField PBudgetField=new JTextField(10);
				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");

				box.add(PId);box.add(PIdField);
				box.add(PBudget);box.add(PBudgetField);
				box.add(submitButton);

				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				submitButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String pid=PIdField.getText();
						int pbudget=Integer.parseInt(PBudgetField.getText());
						System.out.println("Parameters:"+pid+" "+pbudget+"\nSubmit Event:Update Production Budget Submit Button");

						JLabel status=new JLabel(UPD_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().updateProductionBudget(pbudget, pid);
						if(retCode==1) {
							status.setText(UPD_PROD_BUDGET_SUCCESS);
							status.setForeground(Color.green);
						}
						box.add(status);
						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();
						//Making changes to the frame to reflect the added status label
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);

					}
				});
			}

			System.out.println("Update Budget");

			break;

		case "Change an Album Title":
			ReInitPanels();
			MakePanels("Change an Album Title");
			System.out.println("Update Album Title");

			//Paste the copied content below this

			{
				JLabel AId=new JLabel("Album ID:");
				JLabel ATitle=new JLabel("New Title:");

				JTextField AIdField=new JTextField(10);
				JTextField ATitleField=new JTextField(10);
				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");

				box.add(AId);box.add(AIdField);
				box.add(ATitle);box.add(ATitleField);
				box.add(submitButton);

				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				submitButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String aid=AIdField.getText();
						String atitle=ATitleField.getText();
						System.out.println("Parameters:"+aid+" "+atitle+"\nSubmit Event:Update Album Title Submit Button");

						JLabel status=new JLabel(UPD_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().updateAlbumTitle(atitle, aid);
						if(retCode==1) {
							status.setText(UPD_ALB_TITLE_SUCCESS);
							status.setForeground(Color.green);
						}
						box.add(status);
						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();
						//Making changes to the frame to reflect the added status label
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);

					}
				});
			}

			break;

		case "Update the Author of a Song":
			ReInitPanels();
			MakePanels("Update the Author of a Song");
			System.out.println("Update Author");

			//Paste the copied content below this

			{
				JLabel STitle=new JLabel("Song Title:");
				JLabel Author=new JLabel("New Author Name:");

				JTextField STitleField=new JTextField(10);
				JTextField AuthorField=new JTextField(10);
				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");

				box.add(STitle);box.add(STitleField);
				box.add(Author);box.add(AuthorField);
				box.add(submitButton);

				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				submitButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						String stitle=STitleField.getText();
						String author=AuthorField.getText();
						System.out.println("Parameters:"+stitle+" "+author+"\nSubmit Event:Update Song Author Name Submit Button");

						JLabel status=new JLabel(UPD_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().updateSongAuthor(author, stitle);
						if(retCode==1) {
							status.setText(UPD_SONG_AUTHOR_SUCCESS);
							status.setForeground(Color.green);
						}
						box.add(status);
						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();
						//Making changes to the frame to reflect the added status label
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);

					}
				});
			}

			break;

			//Delete Events
		case "Delete a Musician":
			ReInitPanels();
			MakePanels("Delete a Musician");
			System.out.println("Delete Musician");
			
			{
				JLabel MId=new JLabel("Musician Id to be deleted:");
				
				JTextField MIdField=new JTextField(10);
				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");
				
				box.add(MId);box.add(MIdField);
				box.add(submitButton);
				
				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String mid=MIdField.getText();
						System.out.println("Parameters:"+mid+"\nSubmit Event:Delete Musician MId Name Submit Button");
						
						JLabel status=new JLabel(DEL_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().deleteMusicianById(mid);
						if(retCode==1) {
							status.setText(DEL_MUS_SUCCESS);
							status.setForeground(Color.green);
						}
						box.add(status);
						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();
						//Making changes to the frame to reflect the added status label
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
						
					}
				});
			}		
			break;

		case "Delete a Song":
			ReInitPanels();
			MakePanels("Delete a Song");
			System.out.println("Delete Song");
			
			{
				JLabel Stitle=new JLabel("Song title to be deleted:");
				
				JTextField StitleField=new JTextField(10);
				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");
				
				box.add(Stitle);box.add(StitleField);
				box.add(submitButton);
				
				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String stitle=StitleField.getText();
						System.out.println("Parameters:"+stitle+"\nSubmit Event:Delete Song Title Name Submit Button");
						
						JLabel status=new JLabel(DEL_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().deleteSongByTitle(stitle);
						if(retCode==1) {
							status.setText(DEL_SONG_SUCCESS);
							status.setForeground(Color.green);
						}
						box.add(status);
						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();
						//Making changes to the frame to reflect the added status label
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
						
					}
				});
			}		//Stop copying here here
			
			break;
		case "Delete a Band":
			ReInitPanels();
			MakePanels("Delete a Band");
			System.out.println("Delete a Band");
			
			{
				JLabel BId=new JLabel("Band id to be deleted:");
				
				JTextField BIdField=new JTextField(10);
				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");
				
				box.add(BId);box.add(BIdField);
				box.add(submitButton);
				
				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String bid=BIdField.getText();
						System.out.println("Parameters:"+bid+"\nSubmit Event:Delete Band Name Submit Button");
						
						JLabel status=new JLabel(DEL_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().deleteBandById(bid);
						if(retCode==1) {
							status.setText(DEL_BAND_SUCCESS);
							status.setForeground(Color.green);
						}
						box.add(status);
						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();
						//Making changes to the frame to reflect the added status label
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
						
					}
				});
			}
			
			break;
		case "Delete an Album by id":
			ReInitPanels();
			MakePanels("Delete an Album by id");
			System.out.println("Delete an Album by id");
			
			{
				JLabel AId=new JLabel("Album id to be deleted:");
				
				JTextField AIdField=new JTextField(10);
				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");
				
				box.add(AId);box.add(AIdField);
				box.add(submitButton);
				
				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String aid=AIdField.getText();
						System.out.println("Parameters:"+aid+"\nSubmit Event:Delete Album by id Name Submit Button");
						
						JLabel status=new JLabel(DEL_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().deleteAlbumById(aid);
						if(retCode==1) {
							status.setText(DEL_ALB_SUCCESS);
							status.setForeground(Color.green);
						}
						box.add(status);
						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();
						//Making changes to the frame to reflect the added status label
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
						
					}
				});
			}		
			
			break;
		case "Delete an Album by date":
			ReInitPanels();
			MakePanels("Delete an Album by date");
			System.out.println("Delete an Album by date");
			
			
			{
				JLabel Sdate=new JLabel("Start Date:");
				JLabel Edate=new JLabel("End Date:");
				
				JTextField SdateField=new JTextField(10);
				JTextField EdateField=new JTextField(10);

				Box box=new Box(BoxLayout.Y_AXIS);
				JButton submitButton=new JButton("Submit");
				
				box.add(Sdate);box.add(SdateField);
				box.add(Edate);box.add(EdateField);

				box.add(submitButton);
				
				panel10.add(box);

				panel5.add(panel10,BorderLayout.CENTER);
				adminGUIFrame.add(panel5);
				adminGUIFrame.setVisible(true);
				submitButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String sd=SdateField.getText();
						String ed=EdateField.getText();

						System.out.println("Parameters:"+sd+" "+ed+ "\nSubmit Event:Delete Album by date Name Submit Button");
						
						JLabel status=new JLabel(DEL_FAIL);
						status.setForeground(Color.red);
						int retCode=new QueryEvaluator().deleteAlbumByDateRange(sd, ed);
						if(retCode==1) {
							status.setText(DEL_ALB_SUCCESS);
							status.setForeground(Color.green);
						}
						box.add(status);
						int delay = 2000;
						ActionListener taskPerformer = new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								status.setVisible(false);
							}
						};
						Timer tick=new Timer(delay,taskPerformer);
						tick.start();
						//Making changes to the frame to reflect the added status label
						adminGUIFrame.setSize(1280,719);
						adminGUIFrame.setSize(1280,720);
						
					}
				});
			}
		
		case "About":
//			ReInitPanels();
			adminGUIFrame.getContentPane().removeAll();
			adminGUIFrame.repaint();
			adminGUIFrame.add(aboutBg);
			adminGUIFrame.pack();
			System.out.println("About reached");
			break;
		}

	}
	public void ReInitPanels() {
		panel1.removeAll();
		panel2.removeAll();
		panel3.removeAll();
		panel4.removeAll();
		panel5.removeAll();
		panel6.removeAll();
		panel10.removeAll();
		adminGUIFrame.remove(initBg);
		adminGUIFrame.remove(aboutBg);
		adminGUIFrame.repaint();
	}

	public void BlackPanels() {
		adminGUIFrame.repaint();
		panel1.setBackground(Color.black);
		panel2.setBackground(Color.black);
		panel3.setBackground(Color.black);
		panel4.setBackground(Color.black);
		panel5.setBackground(Color.black);
		panel6.setBackground(Color.black);
		panel10.setBackground(Color.black);
	}
	public void MakePanels(String todo) {

		panel1.setBackground(Color.red);
		panel2.setBackground(Color.green);
		panel3.setBackground(Color.yellow);
		panel4.setBackground(Color.magenta);
		panel5.setBackground(Color.blue);
		
		JButton logoutButton=new JButton("Logout");
		logoutButton.setIcon(logoutIcon);
		logoutButton.setForeground(Color.green);
		logoutButton.setBackground(Color.black);
		panel3.add(logoutButton);
		
		logoutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adminGUIFrame.removeAll();
				adminGUIFrame.dispose();
				frame.removeAll();
				frame.dispose();
				AdminGUIState=false;
				new Terminate();
				new Login();
			}
		});
		
		panel1.setPreferredSize(new Dimension(100, 100));
		panel2.setPreferredSize(new Dimension(100, 100));
		panel3.setPreferredSize(new Dimension(100, 100));
		panel4.setPreferredSize(new Dimension(100, 100));
		panel5.setPreferredSize(new Dimension(100, 100));

		if(!todo.equals("nothing")) {
			JLabel nameJLabel=new JLabel("Music Recording Company",SwingConstants.CENTER);
			JLabel todoLabel=new JLabel(todo,SwingConstants.CENTER);
			nameJLabel.setFont(new Font("Chiller",Font.BOLD,42));
			panel1.add(nameJLabel);
			todoLabel.setForeground(Color.white);
			todoLabel.setFont(new Font("Impact",Font.PLAIN,24));
			panel6.add(todoLabel);
		}
		panel6.setBackground(Color.black);
		panel10.setBackground(Color.white);

		panel5.setLayout(new BorderLayout());

		panel6.setPreferredSize(new Dimension(50, 50));
		panel10.setPreferredSize(new Dimension(50, 50));

		panel5.add(panel6, BorderLayout.NORTH);

		adminGUIFrame.add(panel1, BorderLayout.NORTH);
		adminGUIFrame.add(panel2, BorderLayout.WEST);
		adminGUIFrame.add(panel3, BorderLayout.EAST);
		adminGUIFrame.add(panel4, BorderLayout.SOUTH);
	}
}
