// page allows you to sign up by adding username and password, then gives option to return to login

// finish action event and what to do when button is hit

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/* The sign up page, where a user can sign up for an account and go back to the login page */

public class SignUpPage implements ActionListener
{
	// set up of the page
	JFrame frame = new JFrame();
	
	// add the sign up option
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
			
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel("");
			
	JButton setUpButton = new JButton("Set");
	
	// for going back to login page
	JButton loginButton = new JButton("Login");
	
	IdandPasswords idandPasswords = new IdandPasswords();
	
	SignUpPage()
	{
		
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);
		
		messageLabel.setBounds(125, 250, 250, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 15));
		
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		
		// set button so that you can add password to id and passwords
		setUpButton.setBounds(50, 200, 75 ,25);
		setUpButton.addActionListener(this);
		setUpButton.setFocusable(false);
		frame.add(setUpButton);
		
		// login button to take you back to login page
		loginButton.setBounds(275, 200, 75, 25);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		frame.add(loginButton);
		
		
		frame.setTitle("Sign Up Page");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	// Set password or go to login page, depending on the chosed option
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		// gets userID and password, need to make user info on a updatable file, so it can be used
		if (e.getSource()==setUpButton)
		{
			String userID = userIDField.getText();
			String userPassword = String.valueOf(userPasswordField.getPassword());
			
			
			// check to see if userID exists
			int resualt = 0;
			
			try 
			{
				resualt = idandPasswords.check(userID, userPassword);
			} 
			catch (FileNotFoundException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			// if user already exits
			if (resualt != 0)
			{
				messageLabel.setForeground(Color.black);
				messageLabel.setText("userID already exits");
				return;
			}
			
			idandPasswords.addToFile(userID, userPassword);
			
			messageLabel.setForeground(Color.black);
			messageLabel.setText("userID and password set");
			
			return;
		}
		
		// go back to login page
		if (e.getSource()==loginButton)
		{
			frame.dispose();
			IdandPasswords idandPasswords = new IdandPasswords();
			LoginPage loginPage = new LoginPage();
		}
	}

}
