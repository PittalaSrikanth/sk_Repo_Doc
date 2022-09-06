package charAtPackage;

public class CharAtProgramTwo 
{
	public static void main(String[] args)
	{
		// Counting Frequency of a character in a String by Using the charAt() Method
		String s = "Practice java programs";
		int length  = s.length();
		int count=0;
		for(int i =0; i<=length-1;i++)
		{
			if(s.charAt(i)=='r')
			{
				count++;
			}
		}
		System.out.println(count);
	}
}
