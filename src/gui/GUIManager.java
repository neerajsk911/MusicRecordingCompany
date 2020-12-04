package gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
class LoadAnimation extends Canvas{
	public JFrame load= new JFrame();
	public String gifName=null;
	public LoadAnimation() {
		load.setLayout(new BorderLayout());
		gifName="res/821.gif";
		load.getContentPane().add(this,BorderLayout.CENTER);
		System.out.println("Added!"+this);
		load.pack();
		load.setSize(320,100);
		load.setLocationRelativeTo(null);
		load.setVisible(true);
	}
	public LoadAnimation(String name) {
		gifName=name;
		load.add(this);
		System.out.println("Added!"+this);
		load.pack();
		load.setSize(300,100);
		load.setLocationRelativeTo(null);
		load.setVisible(true);
	}
	public void paint(Graphics g) {   
		Toolkit t=Toolkit.getDefaultToolkit();  
		Image i=t.getImage(gifName);  
		g.drawImage(i,20,0,this);   
	}	
}

public class GUIManager {
	public LoadAnimation g=null;
	
	public void MenuGUI() {
//		TODO: Theme the menu buttons
//		display.add(displayTable);
//		menuBar.add(display);
		System.out.println("reached here");
		
	}
	
	public void frameGUI() {
		//TODO: Design the frame GUI for admin window
	}
	
	public void StartLoadAnimation() {
		g=new LoadAnimation();
		System.out.println(g);
	}
	public void StopLoadAnimation() {
		g.load.setVisible(false);
		System.out.println(g);
		g.repaint();
	}
	public void LoadAnotherGif(String name) {
		//TODO: Take the path of the GIF and loads it
		g=new LoadAnimation(name);
	}
}

