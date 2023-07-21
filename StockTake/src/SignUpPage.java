import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/* The sign up page, where a user can sign up for an account and go back to the login page */

public class SignUpPage implements ActionListener
{
	// creating an IDandPasswords object so that the relevent methods can be used in order to manage acsess.
	IdandPasswords idandPasswords = new IdandPasswords();
	
	// creating all of the objects used in the page
	JFrame frame = new JFrame();
	
	// buttons
	JButton setUpButton = new JButton("Set");
	JButton loginButton = new JButton("Login");
	
	// Text Fields
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	
	// labels
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel("");
	
	// Form the sign up page
	SignUpPage()
	{
		
		// buttons
		setUpButton.setBounds(50, 200, 75 ,25);
		setUpButton.addActionListener(this);
		setUpButton.setFocusable(false);
		frame.add(setUpButton);
		
		loginButton.setBounds(275, 200, 75, 25);
		loginButton.addActionListener(this);
		loginButton.setFocusable(false);
		frame.add(loginButton);
		
		// Text Fields
		userIDField.setBounds(125, 100, 200, 25);
		frame.add(userIDField);
		
		userPasswordField.setBounds(125, 150, 200, 25);
		frame.add(userPasswordField);
		
		// Labels
		userIDLabel.setBounds(50, 100, 75, 25);
		frame.add(userIDLabel);
		
		userPasswordLabel.setBounds(50, 150, 75, 25);
		frame.add(userPasswordLabel);
		
		messageLabel.setBounds(125, 250, 250, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 15));
		frame.add(messageLabel);
		
		// frame
		frame.setTitle("Sign Up Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	// Functionality of buttons, when pressed
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		// set button, checks to see if userID already exsits, if not sets the userID and Password combination
		if (e.getSource()==setUpButton)
		{
			String userID = userIDField.getText();
			String userPassword = String.valueOf(userPasswordField.getPassword());
			
			int resualt = 0;
			try 
			{
				resualt = idandPasswords.check(userID, userPassword);
			} 
			catch (Exception e1) 
			{
				e1.printStackTrace();
			}
			
			// if user already exits
			if (resualt != 0)
			{
				messageLabel.setForeground(Color.black);
				messageLabel.setText("userID already exits");
				return;
			}
			
			// if not, add to file
			idandPasswords.addToFile(userID, userPassword);
			messageLabel.setForeground(Color.black);
			messageLabel.setText("userID and password set");
			
			return;
		}
		
		// login button, go back to login page
		if (e.getSource()==loginButton)
		{
			frame.dispose();
			LoginPage loginPage = new LoginPage();
		}
	}

}
