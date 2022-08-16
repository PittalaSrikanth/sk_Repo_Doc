package dayOne;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.BrowserType;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.google.common.io.Files;

public class ChromeBrowserLaunching {

	public static void main(String[] args) throws IOException 
	{
		HtmlUnitDriver chrome = new HtmlUnitDriver(BrowserVersion.CHROME);
		chrome.get("https://www.google.co.in/");
		String title = chrome.getTitle();
		System.out.println(title);
		
		HtmlUnitDriver ff = new HtmlUnitDriver(BrowserVersion.FIREFOX_52);
		ff.get("https://www.google.co.in/");
		String title1 = ff.getTitle();
		System.out.println(title1);

		
		HtmlUnitDriver edg = new HtmlUnitDriver(BrowserVersion.EDGE);
		edg.get("https://www.google.co.in/");
		String title2 = ff.getTitle();
		System.out.println(title2);
		

		HtmlUnitDriver ie = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER);
		ie.get("https://www.google.co.in/");
		String title3 = ff.getTitle();
		System.out.println(title3);

	}

}
