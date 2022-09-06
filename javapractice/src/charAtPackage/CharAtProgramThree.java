package charAtPackage;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

public class CharAtProgramThree 
{
	public static void main(String[] args)
	{
		// Counting Frequency each character in a String by Using the charAt() Method
		String s = "practice java programs";
		int length  = s.length();
		int count=1;
		Set cs = new HashSet();	
		
		for(int i =0; i<=length-1;i++)
		{
			if(s.charAt(i)!=' ') 
			{
				if(cs.add(s.charAt(i))) 
				{
					for(int j = i+1;j<length-1;j++)
					{
						if(String.valueOf(s.charAt(i)).equals(String.valueOf(s.charAt(j))))
						{
							count++;
						}
					}
					System.out.println("No of chars "+s.charAt(i) + " : " +count);
					count=1;
				}
				
				
			}
			
		}
		
	}
}
