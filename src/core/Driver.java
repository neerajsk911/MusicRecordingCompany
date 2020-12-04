package core;
import gui.*;
import databases.*;
public class Driver extends Thread{
	public static void main(String[] args) {

		GUIManager g=new GUIManager();
		g.StartLoadAnimation();
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		g.StopLoadAnimation();
		new Login();
	}
}
