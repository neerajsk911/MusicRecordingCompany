package core;
import gui.*;
public class Driver extends Thread{
	public static void main(String[] args) {

		GUIManager g=new GUIManager();
		g.StartLoadAnimation();		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Reached Sleep Catch in Driver");
		}
		
		g.StopLoadAnimation();
		new Login();
	}
}
