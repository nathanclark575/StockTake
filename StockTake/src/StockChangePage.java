import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/* The Stock Change page, used to alter the stock based on sales */

public class StockChangePage implements ActionListener
{
	
	// making a stock edit object, so that the stock.csv file can be edited
	StockEdit stockEdit = new StockEdit();
	
	// creating all of the objects used in the page
	JFrame frame = new JFrame();
	
	// buttons
	JButton logoutButton = new JButton("Logout");
	JButton searchButton = new JButton("Search"); // search stock
	JButton enterButton = new JButton("Enter"); // enter stock change
	
	// text fields
	JTextField barcode = new JTextField();
	JTextField stockChange = new JTextField();
	
	// labels
	JLabel welcomeLabel = new JLabel("Hello!");
	JLabel skuLabel = new JLabel("SKU");
	JLabel productLabel = new JLabel("Product");
	JLabel productCountLabel = new JLabel("Stock");
	JLabel stockChangeLabel = new JLabel("Change");
	JLabel product = new JLabel("");
	JLabel productCount = new JLabel("");
	JLabel skuError = new JLabel("");
	JLabel productDescriptionLabel = new JLabel("");
	JLabel productDescription = new JLabel("");
	
	// form the StockChangePage
	StockChangePage(String userID)
	{
		
		// buttons
		logoutButton.setBounds(150, 350, 75 ,25);
		logoutButton.addActionListener(this);
		logoutButton.setFocusable(false);
		frame.add(logoutButton);
		
		searchButton.setBounds(260, 108, 75, 25);
		searchButton.addActionListener(this);
		searchButton.setFocusable(false);
		frame.add(searchButton);
		
		enterButton.setBounds(335, 175, 75, 25);
		enterButton.addActionListener(this);
		enterButton.setFocusable(false);
		frame.add(enterButton);
		
		// Text Fields
		barcode.setBounds(100, 107, 165, 25);
		frame.add(barcode);
		
		stockChange.setBounds(265, 175, 75, 25);
		frame.add(stockChange);
		
		// Labels
		welcomeLabel.setBounds(0, 0, 200, 35);
		welcomeLabel.setFont(new Font(null, Font.PLAIN, 25));
		welcomeLabel.setText(userID);
		frame.add(welcomeLabel);
		
		skuLabel.setBounds(50, 100, 200, 35);
		skuLabel.setFont(new Font(null, Font.PLAIN, 15));
		skuLabel.setText("SKU");
		frame.add(skuLabel);
		
		productLabel.setBounds(75, 200, 75, 25);
		productLabel.setFont(new Font(null, Font.PLAIN, 15));
		frame.add(productLabel);
		
		productCountLabel.setBounds(175, 200, 75, 25);
		productCountLabel.setFont(new Font(null, Font.PLAIN, 15));
		frame.add(productCountLabel);
		
		stockChangeLabel.setBounds(275, 200, 75, 25);
		stockChangeLabel.setFont(new Font(null, Font.PLAIN, 15));
		frame.add(stockChangeLabel);
		
		product.setBounds(100, 175, 75, 25);
		product.setFont(new Font(null, Font.PLAIN, 15));
		product.setText("");
		frame.add(product);
		
		productCount.setBounds(190, 175, 75, 25);
		productCount.setFont(new Font(null, Font.PLAIN, 15));
		productCount.setText("");
		frame.add(productCount);
		
		skuError.setBounds(140, 140, 150, 35);
		skuError.setFont(new Font(null, Font.PLAIN, 15));
		skuError.setForeground(Color.red);
		skuError.setText("");
		frame.add(skuError);
		
		productDescriptionLabel.setBounds(50, 250, 100, 35);
		productDescriptionLabel.setFont(new Font(null, Font.PLAIN, 10));
		productDescriptionLabel.setText("Product Description:");
		frame.add(productDescriptionLabel);
		
		productDescription.setBounds(150, 250, 150, 35);
		productDescription.setFont(new Font(null, Font.PLAIN, 10));
		frame.add(productDescription);
		
		// frame
		frame.setTitle("Stock Change Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	// functionality for buttons
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// logout button, go back to login page
		if (e.getSource()==logoutButton)
		{
			frame.dispose();
			LoginPage loginPage = new LoginPage();
		}
		
		// search button, search for the product and display the product, stock and its description
		if (e.getSource()==searchButton)
		{
		
			String sku = barcode.getText();
			String skuCheck = stockEdit.searchCSV(sku);
			String description = stockEdit.productDescription(sku);

			
			// if it is in the stock.csv file show the SKU and product count and description
			if (skuCheck != "None")
			{
				skuError.setText(null);
				product.setText(sku);
				productCount.setText(skuCheck);
				productDescription.setText(description);
			}
			
			// if it is not in the stock.csv file, show error "invalid SKU"
			else
			{
				product.setText(null);
				productCount.setText(null);
				productDescription.setText(null);
				skuError.setText("Invalid SKU");
				
			}
			
		}
		
		// enter button, check to see if it is a valid stock change, if so carry it out
		if (e.getSource()==enterButton)
		{
			// check to see if input is valid
			int change = 0;
			
			try
			{
				change = Integer.parseInt(stockChange.getText());
			}
			catch (Exception error)
			{
				skuError.setText("Invalid stock change");
			}
			
			// if it is a valid input
			if (change != 0)
			{
				skuError.setText(null);
				stockEdit.changeStock(barcode.getText(), change);
				productCount.setText(stockEdit.searchCSV(barcode.getText()));
			}
		}
	}
}
