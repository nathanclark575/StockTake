import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/* Manages the ID and Passwords for the system */

public class IdandPasswords
{	
	
	// Add a userID and Password to the file
	public void addToFile(String userID, String password)
	{
		
		File file = new File("IdandPasswords.txt");
		BufferedWriter bf = null;
			
		try
		{
			// true, so that the file is appeneded to and not overwritten
			bf = new BufferedWriter(new FileWriter(file, true));
				
			bf.write(userID + ":" + password);
			bf.newLine();
				
			bf.flush();
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
			catch (Exception e)
			{
					
			}
		}
		
	}
		
	// check userID and password combo. return 0 if userID does not exist, -1 if userID and password do not match, 1 if they match.
	public int check(String userID, String password) throws FileNotFoundException
	{
		
		File file = new File("IdandPasswords.txt");
		Scanner scan = new Scanner(file);
		
		while (scan.hasNextLine())
		{
			String data = scan.nextLine();
			String[] parts = data.split(":");
				
			if (userID.equals(parts[0]) && password.equals(parts[1]))
			{
				return 1;
			}
			
			else if (userID.equals(parts[0]))
			{
				return -1;
			}

		}
		
		return 0;
		
	}
		
}