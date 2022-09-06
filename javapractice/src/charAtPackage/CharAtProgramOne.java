package charAtPackage;

public class CharAtProgramOne 
{
	public static void main(String[] args) 
	{
		// Print Characters Presented at Odd Positions by Using the charAt() Method
		
		String s = "Practice java programs";
		int length  = s.length();
		for(int i =0; i<=length-1;i++)
		{
			if(i%2!=0)
			{
				System.out.println(i +" : "+ s.charAt(i));
			}
		}
	}
}
