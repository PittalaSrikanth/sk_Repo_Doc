package dayOne;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowMethodsPractices {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.google.co.in/");
		Thread.sleep(5000);
		
		// maximizing the window
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		// setting window in full screen
		driver.manage().window().fullscreen();
		
		
		Thread.sleep(5000);
		// get dimension of my browser
		Dimension windowDim =	driver.manage().window().getSize();
		System.out.println(windowDim.height);
		System.out.println(windowDim.width);
		
		Thread.sleep(5000);
		// set dimension for my browser
		Dimension mydisiredDim = new Dimension(200,100);
		driver.manage().window().setSize(mydisiredDim);
		
		Thread.sleep(5000);
		// get coordinates of my browser
		Point coordinates =	driver.manage().window().getPosition();
		System.out.println(coordinates.x);
		System.out.println(coordinates.y);
		
		Thread.sleep(5000);
		// set coordinates for my browser
		Point cor = new Point(30, 15);
		driver.manage().window().setPosition(cor);
		
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();

	}

}
