package dayOne;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader 
{

	public static Properties p;
	
	public String GetPropertyValueByKey(String Key) throws IOException 
	{
		FileInputStream file = new FileInputStream("D:\\Automation_\\Siddhi_Notes_Repo\\Selenium_Practices\\batch4SeleniumPractice\\testdata.properties");
		p = new Properties();
		p.load(file);	
		return p.getProperty(Key);
	}
	
	
	public void setProperty(String key, String Value) throws FileNotFoundException, IOException
	{
		p.setProperty(key, Value);
		p.store(new FileOutputStream("D:\\Automation_\\Siddhi_Notes_Repo\\Selenium_Practices\\batch4SeleniumPractice\\testdata.properties"),"testing");
	}

}
