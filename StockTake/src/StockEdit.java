import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/* Manages all of the opertaions involoving stock.csv */

public class StockEdit
{
	
	// search for a product using its SKU and return the amount of stock for that product, or "None" if it is not listed
	public String searchCSV(String SKU)
	{
		String file = "Stock.csv";
		BufferedReader bf = null;
		String line = "";
		
		try
		{
			bf = new BufferedReader(new FileReader(file));
			while ((line = bf.readLine()) != null)
			{
				String[] row = line.split(",");
				if (row[0].equals(SKU))
				{
					return row[1];
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bf.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		return "None";
	}
	
	// change stock of a given product by an amount
	public void changeStock(String SKU, int change)
	{
		// all of the new content of the file is stored in temp, which eventialy replaces the file at the file location of stock.csv
		File temp = new File("temp.csv");
		File file = new File("Stock.csv");
		String line = "";		
		
		try 
		{
			FileWriter fw = new FileWriter(temp);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			while ((line = br.readLine()) != null)
			{
				String[] row = line.split(",");
				
				if (row[0].equals(SKU))
				{
					String val = row[1];
					int value = Integer.parseInt(val) + change;
					pw.println(row[0] + "," + Integer.toString(value) + "," + row[2]);
				}
				
				else
				{
					pw.println(line);
				}
				
			}
			
			br.close();
			pw.flush();
			pw.close();
			
			file.delete();
			File path = new File("Stock.csv");
			temp.renameTo(path);
			
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	// get product description based on a SKU, or "None" if that product is not listed
	public String productDescription(String sku)
	{
		File file = new File("Stock.csv");
		String line = "";
		
		BufferedReader br = null;
		
		try
		{
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null)
			{
				String[] row = line.split(",");
				
				if (sku.equals(row[0]))
				{
					return row[2];
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				br.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return "None";
	}
}