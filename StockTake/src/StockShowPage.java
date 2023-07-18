import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// make it so that it displays current stock

class StockShowPage implements ActionListener
{
	// setting up the page
	JFrame frame = new JFrame();
	JLabel checkoutLabel = new JLabel("Hello!");
	
	JButton logoutButton = new JButton("Logout");
	
	
	
	StockShowPage()
	{
		
		checkoutLabel.setBounds(0, 0, 200, 35);
		checkoutLabel.setFont(new Font(null, Font.PLAIN, 25));
		
		frame.add(checkoutLabel);
		
		// Add a logout button, that takes you back to login page
		logoutButton.setBounds(150, 350, 75 ,25);
		logoutButton.addActionListener(this);
		logoutButton.setFocusable(false);
		frame.add(logoutButton);
		

		
		frame.setTitle("Checkout Page");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==logoutButton)
		{
			LoginPage loginPage = new LoginPage();
		}
	}
}