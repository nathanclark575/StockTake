import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* The welcome page, which is now available to the user and offers a logout option */

public class StockChangePage implements ActionListener
{
	// keep track of total spend
	double total = 0;
	
	// setting up the page
	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("Hello!");
	
	JButton logoutButton = new JButton("Logout");
	
	// Product A
	JLabel aLabel = new JLabel("Product A");
	JButton aAdd = new JButton("Add 1");
	JButton aRemove = new JButton("Take 1");
	
	// Total and checkout
	JLabel totalLabel = new JLabel("Total = £" + total);
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
		
		// product A
		aLabel.setBounds(50, 100, 200, 35);
		aLabel.setFont(new Font(null, Font.PLAIN, 15));
		aLabel.setText("Product A : £1");
		
		aAdd.setBounds(200, 107, 75, 25);
		aAdd.addActionListener(this);
		aAdd.setFocusable(false);
		frame.add(aAdd);
		
		aRemove.setBounds(275, 107, 75, 25);
		aRemove.addActionListener(this);
		aRemove.setFocusable(false);
		frame.add(aRemove);
		
		// total and checkout
		totalLabel.setBounds(50, 250, 115, 25);
		frame.add(totalLabel);
		
		checkoutButton.setBounds(200, 250, 100, 25);
		checkoutButton.addActionListener(this);
		checkoutButton.setFocusable(false);
		frame.add(checkoutButton);
		
		frame.add(aLabel);
		
		frame.setTitle("Welcome Page");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	// check stock of A
	public String stockCheck(String A) throws FileNotFoundException
	{
		File file = new File("Stock.txt");
		Scanner scan = new Scanner(file);
		
		while (scan.hasNextLine())
		{
			String data = scan.nextLine();
			String[] parts = data.split(":");
			
			if (parts[0].equals(A))
			{
				return parts[1];
			}
		}
		
		scan.close();
		
		return "-1";
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
		
		// change total based on aAdd or aRemove
		if (e.getSource()==aAdd)
		{
			total++;
			totalLabel.setText("Total = £" + total);
		}
		
		if (e.getSource()==aRemove)
		{
			total--;
			totalLabel.setText("Total = £" + total);
		}
		
		if (e.getSource()==checkoutButton)
		{
			// code to send info to checkout file for page
			
			try {
				String s = stockCheck("A");
				System.out.println(s);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// load checkout page
			StockShowPage checkout = new StockShowPage();
		}
	}
}
