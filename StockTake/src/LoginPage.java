/* The login page for the system. From here you can login, or go to the sign up page */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener
{
	
	// creating an IDandPasswords object so that the relevent methods can be used in order to manage acsess.
	IdandPasswords idandPasswords = new IdandPasswords();
	
	// creating all of the objects used in the page
	JFrame frame = new JFrame();
	
	// buttons
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JButton signUpButton = new JButton("Sign up");
	
	// Text fields
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	
	// labels
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel("Login Page");
	JLabel loginMessage = new JLabel("");

	// form the login page
	LoginPage()
	{

		// buttons
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		frame.add(loginButton);
		
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);
		frame.add(resetButton);	
		
		signUpButton.setBounds(50, 200, 75 ,25);
		signUpButton.addActionListener(this);
		signUpButton.setFocusable(false);
		frame.add(signUpButton);
		
		// Text fields
		userIDField.setBounds(125, 100, 200, 25);
		frame.add(userIDField);
		
		userPasswordField.setBounds(125, 150, 200, 25);
		frame.add(userPasswordField);
		
		// labels
		userIDLabel.setBounds(50, 100, 75, 25);
		frame.add(userIDLabel);
		
		userPasswordLabel.setBounds(50, 150, 75, 25);
		frame.add(userPasswordLabel);
		
		messageLabel.setBounds(150, 50, 250, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));
		frame.add(messageLabel);
		
		loginMessage.setBounds(150, 250, 250, 35);
		loginMessage.setFont(new Font(null, Font.ITALIC, 10));
		frame.add(loginMessage);

		// frame
		frame.setTitle("Login Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	// Functionality of buttons, when pressed
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// reset button, clear userID and Password fields
		if (e.getSource()==resetButton)
		{
			loginMessage.setText(null);
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		// login button, check to see if the userID and Password are a combination stored in the system
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
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
			
			if (resualt == 1)
			{
				StockChangePage stockChangePage = new StockChangePage(userID);
			}
			else if (resualt == -1)
			{
				loginMessage.setForeground(Color.red);
				loginMessage.setText("Password does not match userID");
			}
			
			else
			{
				loginMessage.setForeground(Color.red);
				loginMessage.setText("userID not found");
			}
			
		}
		
		// signup button, take the user to the sign up page
		if (e.getSource()==signUpButton)
		{
			frame.dispose();
			SignUpPage signUpPage = new SignUpPage();
		}
	}
	
}