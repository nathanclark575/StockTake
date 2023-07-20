import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StockEdit
{
	
	// reads the file and prints it
	public void readAndPrint()
	{
		String file = "stock.csv";
		BufferedReader reader = null;
		String line = "";
		
		try
		{
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null)
			{
				String[] row = line.split(",");
				
				for (String i : row)
				{
					System.out.printf("%-10s", i);
				}
				
				System.out.println();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// search for a values and return the amount of it
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
					System.out.println("Amount of " + SKU + " = " + row[1]);
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
	
	// change stock of a given product by an ammount that can be entered at the page
	public void changeStock(String SKU, int change)
	{
		File temp = new File("temp.csv");
		File file = new File("Stock.csv");
		
		//BufferedReader br = null;
		String line = "";
		
		//PrintWriter pw = null;
		
		
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
					pw.println(row[0] + "," + Integer.toString(value));
					
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
	
	// get product description
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