import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* Manages the ID and Passwords for the whole system in a file that can be, written to, read and checked for an ID and Password combo */

public class IdandPasswords
{	
	
	// write a dic entry to file
	public void addToFile(String userID, String password)
	{
			
		// open the file and append to it
		File file = new File("IdandPasswords.txt");
		BufferedWriter bf = null;
			
		try
		{
			// the true states that the file exists and causes it to append, instead of re-writing the file
			bf = new BufferedWriter(new FileWriter(file, true));
				
			bf.write(userID + ":" + password);
			bf.newLine();
				
			bf.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bf.close();
			}
			catch (Exception e)
			{
					
			}
		}
		
	}
		
	// read the file and print its absoloute path
	public void readFile() throws FileNotFoundException
	{
			
		ArrayList<String> lst = new ArrayList<String>();
		File file = new File("IdandPasswords.txt");
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine())
		{
			lst.add(scan.nextLine());
		}
			
		scan.close();
			
		System.out.println(lst);
		System.out.println(file.getAbsolutePath());
	}
		
	// check userID and password combo
	public int check(String userID, String password) throws FileNotFoundException
	{
		File file = new File("IdandPasswords.txt");
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine())
		{
			String data = scan.nextLine();
			String[] parts = data.split(":");
				
			// userID and password match, return 1
			if (userID.equals(parts[0]) && password.equals(parts[1]))
			{
				return 1;
			}
			
			// userID used, but don't match
			else if (userID.equals(parts[0]))
			{
				return -1;
			}

		}
		// userID missing
		return 0;
	}
		
}
