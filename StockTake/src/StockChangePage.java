import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/* The Stock Change page, used to alter the stock based on sales */

public class StockChangePage implements ActionListener
{
	
	// setting up the page
	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("Hello!");
	
	JButton logoutButton = new JButton("Logout");
	
	// Stuff needed to take a SKU and confim it as a product, to display lower down
	JLabel aLabel = new JLabel("SKU");
	JTextField barcode = new JTextField();
	JButton enterButton = new JButton("Enter");
	
	// checkout
	JButton checkoutButton = new JButton("Checkout");
	
	
	StockChangePage(String userID)
	{
		
		welcomeLabel.setBounds(0, 0, 200, 35);
		welcomeLabel.setFont(new Font(null, Font.PLAIN, 25));
		welcomeLabel.setText(userID);
		
		frame.add(welcomeLabel);
		
		// Add a logout button, that takes you back to login page
		logoutButton.setBounds(150, 350, 75 ,25);
		logoutButton.addActionListener(this);
		logoutButton.setFocusable(false);
		frame.add(logoutButton);
		
		// SKU label
		aLabel.setBounds(50, 100, 200, 35);
		aLabel.setFont(new Font(null, Font.PLAIN, 15));
		aLabel.setText("SKU");
		
		// SKU field
		barcode.setBounds(125, 107, 100, 25);
		frame.add(barcode);
		
		// SKU enter button
		enterButton.setBounds(200, 107, 100, 25);
		enterButton.addActionListener(this);
		enterButton.setFocusable(false);
		frame.add(enterButton);
		
		// checkout
		checkoutButton.setBounds(200, 250, 100, 25);
		checkoutButton.addActionListener(this);
		checkoutButton.setFocusable(false);
		frame.add(checkoutButton);
		
		frame.add(aLabel);
		
		frame.setTitle("Stock Change Page");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// if logout selected, close the welcome page and reopen a new login page
		if (e.getSource()==logoutButton)
		{
			frame.dispose();
		
			LoginPage loginPage = new LoginPage();
		}
		
		if (e.getSource()==checkoutButton)
		{
			
			// load checkout page
			StockShowPage checkout = new StockShowPage();
		}
	}
}
