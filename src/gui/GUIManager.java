package gui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
class LoadAnimation extends Canvas{
	public JFrame load= new JFrame();
	public LoadAnimation() {
		load.add(this);
		System.out.println("Added!"+this);
		load.pack();
		load.setSize(300,100);
		load.setLocationRelativeTo(null);
		load.setVisible(true);
	}
	public void paint(Graphics g) {    
		Toolkit t=Toolkit.getDefaultToolkit();  
		Image i=t.getImage("res/821.gif");  
		g.drawImage(i,0,0,this);    
	}	
}

public class GUIManager {
	public LoadAnimation g=null;
	
	public void MenuGUI() {
		//TODO: Theme the menu buttons
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
	}
	public void SetGifPath() {
		//TODO: Take the path of the GIF and loads it
	}
}

