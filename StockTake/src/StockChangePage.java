import java.awt.Color;
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
	
	// making a stock edit object
	StockEdit stockEdit = new StockEdit();
	
	// setting up the page
	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("Hello!");
	
	JButton logoutButton = new JButton("Logout");
	
	// Stuff needed to take a SKU and confim it as a product, to display lower down
	JLabel aLabel = new JLabel("SKU");
	JTextField barcode = new JTextField();
	JButton searchButton = new JButton("Search");
	
	// checkout
	JButton checkoutButton = new JButton("Checkout");
	
	// to show prouduct that has been searched, the number in stock, and to offer the ability to change stock count
	JLabel productLabel = new JLabel("Product");
	JLabel productCountLabel = new JLabel("Stock");
	JLabel stockChangeLabel = new JLabel("Change");
	
	JLabel product = new JLabel("");
	JLabel productCount = new JLabel("");
	JTextField stockChange = new JTextField();
	
	// for invalid SKU message
	JLabel skuError = new JLabel("");
	
	
	
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
		barcode.setBounds(100, 107, 165, 25);
		frame.add(barcode);
		
		// SKU enter button
		searchButton.setBounds(260, 108, 75, 25);
		searchButton.addActionListener(this);
		searchButton.setFocusable(false);
		frame.add(searchButton);
		
		// To show the product that has been searched, the number in stock, and to offer the ability to change the stock
		productLabel.setBounds(75, 200, 75, 25);
		productLabel.setFont(new Font(null, Font.PLAIN, 15));
		frame.add(productLabel);
		
		productCountLabel.setBounds(175, 200, 75, 25);
		productCountLabel.setFont(new Font(null, Font.PLAIN, 15));
		frame.add(productCountLabel);
		
		stockChangeLabel.setBounds(275, 200, 75, 25);
		stockChangeLabel.setFont(new Font(null, Font.PLAIN, 15));
		frame.add(stockChangeLabel);
		
		// product
		product.setBounds(100, 175, 75, 25);
		product.setFont(new Font(null, Font.PLAIN, 15));
		product.setText("");
		frame.add(product);
		
		// product stock amount
		productCount.setBounds(190, 175, 75, 25);
		productCount.setFont(new Font(null, Font.PLAIN, 15));
		productCount.setText("");
		frame.add(productCount);
		
		// stock change field
		stockChange.setBounds(265, 175, 75, 25);
		frame.add(stockChange);
		
		// skuError
		skuError.setBounds(150, 150, 150, 35);
		skuError.setFont(new Font(null, Font.PLAIN, 15));
		skuError.setForeground(Color.red);
		skuError.setText("");
		frame.add(skuError);
		
		
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
		
		if (e.getSource()==searchButton)
		{
			
			// check the stock csv for the product and then display the stock amount and a change field
			String sku = barcode.getText();
			String skuCheck = stockEdit.searchCSV(sku);

			
			// if it is in the stock.csv file show the SKU and product count, add description later?
			if (skuCheck != "None")
			{
				
				// get rid of SKU error if correct one typed
				skuError.setText(null);
				
				product.setText(sku);
				
				productCount.setText(skuCheck);
	
			}
			
			// if it is not in the stock.csv file, show error "invalid SKU"
			else
			{
				product.setText(null);
				productCount.setText(null);
				skuError.setText("Invalid SKU");
				
			}
			
		}
	}
}
