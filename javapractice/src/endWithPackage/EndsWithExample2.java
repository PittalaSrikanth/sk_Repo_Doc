package endWithPackage;

public class EndsWithExample2 
{
	public static void main(String argvs[])   
	{  
	String str = "Welcome to JavaTpoint";  
	  
	// the result of the following display statement  
	// shows endsWith() considers the case sensitiveness of   
	// the charaters of a string  
	System.out.println(str.endsWith("javaTpoint")); // false because J and j are different  
	System.out.println(str.endsWith("Javatpoint")); // false because T and t are different  
	System.out.println(str.endsWith("JavaTpoint")); // true because every character is same  
	  
	}  
}
