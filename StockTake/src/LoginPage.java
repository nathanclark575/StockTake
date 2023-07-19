/* The login page for the system. From here you can login, or go to the sign up page */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener
{
	IdandPasswords idandPasswords = new IdandPasswords();
	
	// Setting up of the page, with the button, labels and layout
	JFrame frame = new JFrame();
	
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel("Login Page");
	JLabel loginMessage = new JLabel("");
	
	
	// sign up button
	JButton signUpButton = new JButton("Sign up");
	
	HashMap<String, String> loginInfo =  new HashMap<String, String>();

	// set all the bounds, and add all of the features to the frame
	LoginPage()
	{
		
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);
		
		messageLabel.setBounds(150, 50, 250, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));
		
		loginMessage.setBounds(100, 250, 250, 35);
		loginMessage.setFont(new Font(null, Font.ITALIC, 10));
		
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(loginMessage);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		
		// add sign up button, with actionlisterner
		signUpButton.setBounds(50, 200, 75 ,25);
		signUpButton.addActionListener(this);
		signUpButton.setFocusable(false);
		frame.add(signUpButton);
		
		frame.setTitle("Login Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	// Action listerner, checks for when buttons are pressed
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==resetButton)
		{
			loginMessage.setText(null);
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		if (e.getSource()==loginButton)
		{
			String userID = userIDField.getText();
			// needed to get string version of password field as not just text like userID
			String password = String.valueOf(userPasswordField.getPassword());
			
			int resualt = 0;
			
			// Check combo, using the file methods
			try 
			{
				resualt = idandPasswords.check(userID, password);
			} 
			catch (FileNotFoundException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (resualt == 1)
			{
				//loginMessage.setForeground(Color.green);
				//loginMessage.setText("Login Successful");
				StockChangePage stockChangePage = new StockChangePage(userID);
			}
			else
			{
				loginMessage.setForeground(Color.red);
				loginMessage.setText("Incorrect combination of userID and password");
			}
			
		}
		// goto sign up page
		if (e.getSource()==signUpButton)
		{
			frame.dispose();
			SignUpPage signUpPage = new SignUpPage();
		}
	}
	
}