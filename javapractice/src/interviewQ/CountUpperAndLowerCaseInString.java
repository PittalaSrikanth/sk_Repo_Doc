package interviewQ;

public class CountUpperAndLowerCaseInString 
{

	public static void main(String[] args)
	{
		String str = "FJALKFJAaakalfjdsljfKJKKfafdlsfjdsklfjLDSKLFJSDAJFLLJLFkdlfjLKFlKFLjKLJLkfjlJFF";
		char[] ch = str.toCharArray();
		int Upper_count = 0;
		int Lower_count = 0;
		for(char c : ch)
		{
			if(Character.isUpperCase(c))
			{
				Upper_count++;
			}
			else {
				Lower_count++;
			}
		}
		System.out.println("Upper count : " + Upper_count);
		System.out.println("Lower count : " + Lower_count);
	}

}
