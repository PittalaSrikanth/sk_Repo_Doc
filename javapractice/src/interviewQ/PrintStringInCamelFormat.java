package interviewQ;

public class PrintStringInCamelFormat {

	public static void main(String[] args) 
	{
		String str = "hellow srikanth good morning";
		String[] words = str.split(" ");
		
		
		for(String word : words)
		{
			char[] wordchar = word.toCharArray();
			String firstChar = String.valueOf(wordchar[0]).toUpperCase();
			System.out.print(firstChar);
		
			for(int i =1; i<=wordchar.length-1; i++)
			{
				System.out.print(wordchar[i]);
			}
			System.out.print(" ");
		}

	}

}
