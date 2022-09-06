package containsPackage;

public class ContainsExample1 
{
	public static void main(String[] args) 
	{  
        String str = "Hello Javatpoint readers";  
        boolean isContains = str.contains("Javatpoint");  
        System.out.println(isContains);  
        // Case Sensitive  
        System.out.println(str.contains("javatpoint")); // false  
    }  
}
