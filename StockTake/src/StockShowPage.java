import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

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
		
		// for csv show
		//JPanel jpanel = new JPanel();
		//BoxLayout verticalLayout = new BoxLayout(jpanel, BoxLayout.X_AXIS);
		//jpanel.setLayout(verticalLayout);
		//jpanel.setBounds(100, 100, 100, 100);
		//frame.add(jpanel);
		
		//JLabel label = new JLabel("New label");
		//jpanel.add(label);
		
		String[] column = {"a" ,"b"};
		String[][] data = {
				{"1", "2"},
				{"3", "4"}
		};
		
		StockEdit stockEdit = new StockEdit();
		
		
		JTable table = new JTable(data, column);
		table.setEnabled(false);
		table.setBounds(100, 100, 100, 100);
		frame.add(table);

		
		frame.setTitle("Stock Show Page");
		
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