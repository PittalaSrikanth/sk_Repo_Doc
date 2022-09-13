package interviewQ;

public class ChangeTheCaseOfCharInString {

	public static void main(String[] args) 
	{
		String str = "aPplE";
		StringBuilder res = new StringBuilder("");
		char[] ch = str.toCharArray();
		for(char c : ch)
		{
			if(Character.isUpperCase(c))
			{
				res.append(Character.toLowerCase(c));
			}
			else if (Character.isLowerCase(c)) 
			{
				res.append(Character.toUpperCase(c));
			}
		}
		System.out.println(res);
	}

}
