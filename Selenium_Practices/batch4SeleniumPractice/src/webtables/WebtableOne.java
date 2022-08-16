package webtables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebtableOne 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		// no of records
		List<WebElement> allrecords =	driver.findElements(By.xpath("//table[@id='customers']//tr"));
		int recordscount = allrecords.size();
		
		System.out.println("No of records in my web table is : "+ recordscount);
		
		// no of coloums
		List<WebElement> allcoloums =	driver.findElements(By.xpath("//table[@id='customers']//th"));
		int coloumRecords = allcoloums.size();
		System.out.println("No of coloums in my web table is : "+ coloumRecords);
		
		for(WebElement coloum : allcoloums)
		{
		  System.out.println("Coloum heading : "+coloum.getText());
		}
		
		

		
		// no of testdate cells
		List<WebElement> allcells =	driver.findElements(By.xpath("//table[@id='customers']//td"));
		int cells = allcells.size();
		System.out.println("No of cells in my web table is : "+ cells);
		System.out.println("No of cells in entire web table is : "+ (cells+coloumRecords));
		for(WebElement cell : allcells)
		{
		  System.out.println("cell data : "+cell.getText());
		}
		

		

		
		driver.close();
		driver.quit();
	}
}
