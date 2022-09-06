package interviewQ;

public class RewerseString {

	public static void main(String[] args) 
	{
		String str = "Hellow Srikanth good morning";
		
		for(int i=str.length()-1;i>=0;i--)
		{
			System.out.print(str.charAt(i));
		}

	}

}
