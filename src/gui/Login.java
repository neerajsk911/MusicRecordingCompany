 package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import databases.GUILoginCheck;

public class Login implements ActionListener,ResourcePaths{
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
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);

		us.setFont(new Font("Chiller", Font.PLAIN, 20));
		ps.setFont(new Font("Chiller", Font.PLAIN, 20));	
		bt.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));

		
		JPanel panel1 = new JPanel(); 	
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		JLabel panel1Image=new JLabel(new ImageIcon(LoginOutTop));
		panel1.add(panel1Image);
		JLabel panel2Image=new JLabel(new ImageIcon(LoginOutLeft),JLabel.CENTER);
		panel2.add(panel2Image);
		
		JLabel panel3Image=new JLabel(new ImageIcon(LoginOutRight),SwingConstants.CENTER);
		panel3.add(panel3Image);
		
		JLabel panel4Image=new JLabel(new ImageIcon(LoginOutBottom),SwingConstants.CENTER);
		panel4.add(panel4Image);
		
		panel1.setBackground(Color.black);		//right
		panel2.setBackground(Color.black);		//right
		panel3.setBackground(Color.black);		//right
		panel4.setBackground(Color.black);		//right
		panel5.setBackground(Color.black);

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
		
		JLabel panel6Image=new JLabel(new ImageIcon(LoginInTop));
		panel6.add(panel6Image);
		JLabel panel7Image=new JLabel(new ImageIcon(LoginInLeft));
		panel7.add(panel7Image);
		
		JLabel panel8Image=new JLabel(new ImageIcon(LoginInRight));
		panel8.add(panel8Image);
		
		JLabel panel9Image=new JLabel(new ImageIcon(LoginInBottom));
		panel8.add(panel9Image);

		panel6.setBackground(Color.black);
		panel7.setBackground(Color.black);
		panel8.setBackground(Color.black);
		panel9.setBackground(Color.black);
		panel10.setBackground(Color.black);
		panel10.setBackground(new Color(0, 0, 0,0));

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
		

		us.setForeground(Color.white);
		ps.setForeground(Color.white);
		Box box=new Box(BoxLayout.Y_AXIS);

		//Creates 20px of vertical space
		box.add(Box.createVerticalStrut(20));
		box.add(us);
		box.add(username);
		
		box.add(Box.createVerticalStrut(20));
		box.add(ps);
		box.add(password);
		
		box.add(Box.createVerticalStrut(20));
		box.add(bt);
		
		panel10.add(box,SwingConstants.CENTER);
		
		frame.setVisible(true);
		password.addActionListener(this);
		bt.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		guiManager=new GUIManager();
		
		GUILoginCheck g=new GUILoginCheck();
		String user=username.getText();
		
		@SuppressWarnings("deprecation")
		String pass=password.getText();

		String validationResult=g.ValidateGUILogin(user,pass).trim();

		//For Debugging
		System.out.println("val:"+validationResult);
		JLabel greetText=new JLabel("Hello "+validationResult+"!");

		guiManager.LoadAnotherGif(LoadCircle);
		
		//Make delay for animation
		try {
			Thread.sleep(1000);
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