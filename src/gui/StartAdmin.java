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
	JMenuItem displayTable=new JMenuItem("Display a table");
	//TODO: Add more display features
	
	JMenuItem insertTable=new JMenuItem("Insert value into a table");
	JMenuItem updateTable=new JMenuItem("Update a table");
	JMenuItem deleteTable=new JMenuItem("Delete a table");
	
	
	public StartAdmin() {
		//TODO: Call admin function
		adminGUIFrame.pack();
		adminGUIFrame.setSize(860,600);
		adminGUIFrame.setLocationRelativeTo(menuBar);
		adminGUIFrame.setVisible(true);
		MenuGUI();
		
		if(Login.privilege.equals("admin")) {
			insert.add(insertTable);
			update.add(updateTable);
			delete.add(deleteTable);

			menuBar.add(insert);
			menuBar.add(update);
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
