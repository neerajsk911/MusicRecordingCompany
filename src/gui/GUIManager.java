package gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
class LoadAnimation extends Canvas implements ResourcePaths{
	public JFrame load= new JFrame();
	public String gifName=null;
	public LoadAnimation() {
		load.setUndecorated(true);
		load.setLayout(new BorderLayout());
		gifName=ReindeerForward;
		JLabel loadAn=new JLabel(new ImageIcon(gifName));
		load.add(loadAn);
		load.getContentPane().add(this,BorderLayout.CENTER);
		load.pack();
		load.setSize(320,80);
		load.setLocationRelativeTo(null);
		load.setVisible(true);
	}
	public LoadAnimation(String name) {
		load.setUndecorated(true);
		gifName=name;
		load.getContentPane().add(this,BorderLayout.CENTER);
		load.pack();
//		load.setSize(320,80);
		load.repaint();
		load.setLocationRelativeTo(null);
		load.setVisible(true);
	}
	public void paint(Graphics g) {   
		Toolkit t=Toolkit.getDefaultToolkit();  
		Image i=t.getImage(gifName);  
		g.drawImage(i,30,10,this);   
	}	
}

public class GUIManager {
	public LoadAnimation g;
	
	public void StartLoadAnimation() {
		g=new LoadAnimation();
	}
	public void StopLoadAnimation() {
		g.load.setVisible(false);
		g.load.getContentPane().removeAll();
		g.load.removeAll();
		g.load.dispose();
		g.load.repaint();
	}
	public void LoadAnotherGif(String name) {
		//TODO: Take the path of the GIF and loads it
		System.out.println("Loading New Gif Path:"+name);
		g=new LoadAnimation(name);
	}
}

