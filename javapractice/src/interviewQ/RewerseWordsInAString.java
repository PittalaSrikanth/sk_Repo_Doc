package interviewQ;

public class RewerseWordsInAString {

	public static void main(String[] args) 
	{
		String str = "hellow srikanth good morning";
		String[] words = str.split(" ");
		
		
		for(String word : words)
		{
			char[] wordchar = word.toCharArray();
			for(int i = wordchar.length-1; i>=0;i--)
			{
				System.out.print(wordchar[i]);
			}
			System.out.print(" ");
		}

	}

}
