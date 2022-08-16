package dayOne;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintWebTable 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		Thread.sleep(2000);
		
	List<WebElement> noOfRows =	driver.findElements(By.xpath("//table[@id='customers']//tr"));
	System.out.println(noOfRows.size());
		for(int i=2;i<=noOfRows.size();i++)
		{
			List<WebElement> noOftabledata = driver.findElements(By.xpath("//table[@id='customers']//tr["+i+"]//td"));
			for(int j =1;j<=noOftabledata.size();j++)
			{
				String tableData =driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]//td["+j+"]")).getText();
				System.out.print(tableData+ "  " );
			}
			System.out.println();
		}
		
		
		
		driver.close();
		driver.quit();
	}
}
