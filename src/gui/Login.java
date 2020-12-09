 package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import databases.GUILoginCheck;

public class Login implements ActionListener,ResourcePaths{
	int width_margin=10;
	int height_margin= 10;
	GUIManager guiManager=null;
	public static String privilege;
	
	JFrame frame= new JFrame();

	JLabel label1= new JLabel("Music Recording Company"); 
	JButton bt=new JButton("Submit");
	JLabel us=new JLabel("Username:");
	JLabel ps=new JLabel("Password:");
	JTextField username=new JTextField(10);
	JPasswordField password=new JPasswordField(10);
	Image icon = Toolkit.getDefaultToolkit().getImage(TitleMusicIcon); 

	public Login() {
		frame.setTitle("Welcome To Music Recording Company System");
		frame.setIconImage(icon);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(1280,720);
		frame.setSize(860,600);
		frame.setLayout(new BorderLayout(10, 10));
		frame.setLocationRelativeTo(null);

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();

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

		//-----------------sub panels----------------------

		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		JPanel panel9 = new JPanel();
		JPanel panel10 = new JPanel();

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
		panel5.add(panel10, BorderLayout.CENTER);


		//---------------------sub panels-----------------


		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.WEST);
		frame.add(panel3, BorderLayout.EAST);
		frame.add(panel4, BorderLayout.SOUTH);
		frame.add(panel5, BorderLayout.CENTER);

		
		label1.setForeground(Color.black);
		label1.setFont(label1.getFont().deriveFont(Font.BOLD, 20f));
		panel1.add(label1);

		us.setForeground(Color.black);
		ps.setForeground(Color.black);


		panel10.add(us);
		panel10.add(username);
		panel10.add(ps);
		panel10.add(password);
		panel10.add(bt);
		frame.setVisible(true);
		password.addActionListener(this);
		bt.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		guiManager=new GUIManager();
		guiManager.LoadAnotherGif(ReindeerForward);
		
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
			frame.setVisible(false);
		}
		else if(validationResult.equals("local")) {
			
			//TODO: Local Page
			privilege=validationResult;
			System.out.println("Hello Regular!");
			greetText.setAlignmentY(-80);
			frame.getContentPane().setBackground(Color.cyan);
			frame.add(greetText);
			new StartAdmin();
			frame.setVisible(false);
		}
		else{
			//TODO: User not found dialog
			JPanel imgPanel=new JPanel();
			JDialog userNotFoundDialog=new JDialog(frame,"User Not Found!");
			userNotFoundDialog.setLayout(new BorderLayout());
			JLabel UNF_label=new JLabel("The Username and Password did not match our records!",SwingConstants.CENTER);
//			userNotFoundDialog.pack();
			JLabel SantaText=new JLabel(" ".repeat(3)+"UH-OH Not this way!");
			JLabel bgImage=new JLabel();
			imgPanel.setLayout(new BorderLayout());
			bgImage.setIcon(new ImageIcon(ReindeerReverse));
			imgPanel.add(bgImage,BorderLayout.CENTER);
			imgPanel.add(SantaText,BorderLayout.WEST);
			userNotFoundDialog.setSize(420,150);
			userNotFoundDialog.setLocationRelativeTo(null);
			userNotFoundDialog.add(imgPanel,BorderLayout.NORTH);
			userNotFoundDialog.add(UNF_label,BorderLayout.CENTER);
			userNotFoundDialog.setVisible(true);
			//frame.setVisible(false);
		}
	}
	
}