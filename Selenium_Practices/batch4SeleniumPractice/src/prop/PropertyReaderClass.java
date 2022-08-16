package prop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderClass 
{
	public static Properties p;
	
	public String GetPropertyByKey(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("D:\\Automation_\\Siddhi_Notes_Repo\\Selenium_Practices\\batch4SeleniumPractice\\testdata.properties");
		p = new Properties();
		p.load(file);
		return p.getProperty(key);
	}
	
	public void SetProperty(String key, String Value) throws FileNotFoundException, IOException
	{
		p.setProperty(key, Value);
		p.store(new FileOutputStream("D:\\Automation_\\Siddhi_Notes_Repo\\Selenium_Practices\\batch4SeleniumPractice\\testdata.properties"), "test");
		
	}

}
