package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import databases.*;

public class Login extends Thread implements ActionListener{
	GUIManager guiManager=new GUIManager();
	public static String privilege;
	
	JFrame frame=new JFrame("Music Recording Company");
	JLabel label_main=new JLabel("Music Recording Company");
//	JLabel bgImage=new JLabel();
	JButton bt=new JButton("Submit");
	JLabel us=new JLabel("Username:");
	JLabel ps=new JLabel("Password:");
	JTextField username=new JTextField(10);
	JPasswordField password=new JPasswordField(10);
	
	public Login() {
		label_main.setForeground(Color.blue);
//		bgImage.setIcon(new ImageIcon("D:\\1.png"));
		frame.getContentPane().setBackground(Color.green);
		frame.add(label_main);
		frame.add(us);
		frame.add(username);
		frame.add(ps);
		frame.add(password);
		frame.add(bt);
//		frame.add(bgImage);
		frame.pack();
		frame.setSize(860,600);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		password.addActionListener(this);
		bt.addActionListener(this);
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		guiManager.StartLoadAnimation();
		
		GUILoginCheck g=new GUILoginCheck();
		String user=username.getText();
		
		@SuppressWarnings("deprecation")
		String pass=password.getText();

		String validationResult=g.ValidateGUILogin(user,pass).trim();

		//For Debugging
		System.out.println("val:"+validationResult);
		JLabel greetText=new JLabel("Hello "+validationResult+"!");

		try {
			Thread.sleep(2000);
		} 
		catch (Exception e2) { System.out.println("Login Interrupted");		}
		
		guiManager.StopLoadAnimation();
		frame.setVisible(true);
		if(validationResult.equals("admin")) {
			//TODO: Admin Page
			privilege=validationResult;
			System.out.println("Hello Admin!");
			greetText.setAlignmentY(-80);
			frame.getContentPane().setBackground(Color.blue);
			frame.add(greetText);
			new StartAdmin();
		}
		else if(validationResult.equals("local")) {
			//TODO: Local Page
			privilege=validationResult;
			System.out.println("Hello Regular!");
			greetText.setAlignmentY(-80);
			frame.getContentPane().setBackground(Color.cyan);
			frame.add(greetText);
			new StartAdmin();
		}
		else{
			//TODO: User not found dialog
			JDialog userNotFoundDialog=new JDialog(frame,"User Not Found!");
			JLabel UNF_label=new JLabel("The Username and Password did not match our records!");
			userNotFoundDialog.pack();
			userNotFoundDialog.setSize(400,100);
			userNotFoundDialog.setLocationRelativeTo(null);
			userNotFoundDialog.add(UNF_label,SwingConstants.CENTER);
			userNotFoundDialog.setVisible(true);
			//frame.setVisible(false);
		}
	}
}
