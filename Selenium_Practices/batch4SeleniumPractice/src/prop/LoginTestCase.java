package prop;

import java.io.IOException;

public class LoginTestCase {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		LoginPage l = new LoginPage();
		PropertyReaderClass reader = new PropertyReaderClass();
		
		
		l.Login(reader.GetPropertyByKey("user"), reader.GetPropertyByKey("password"));
		
		reader.SetProperty("city", "bhongir");
		
		
		l.Logout();

	}

}
