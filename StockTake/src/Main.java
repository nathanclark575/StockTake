import java.io.FileNotFoundException;

/* This page loads the programme */

public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//LoginPage loginPage = new LoginPage();
		
		StockEdit a = new StockEdit();
		
		a.readAndPrint();
		
		a.searchCSV("A");
		
		a.changeStock("A", "1");
		
		a.searchCSV("A");
		
		StockChangePage page = new StockChangePage("Nathan");

	}
}