package interviewQ;

import java.util.ArrayList;

public class CountDuplicateCharInString {

	static ArrayList<String> list = new ArrayList<String>();
	
	public static void main(String[] args) 
	{
		String str = "hellow srikanth good morning";
		for(int i = 0; i<str.length();i++)
		{
			int count = 0;
			char ch = str.charAt(i);
			if(list.contains(Character.toString(ch))) 
			{
				continue;
			}
			else {
				list.add(Character.toString(ch));
				for(int j = 0; j<str.length();j++)
				{
					if(ch == str.charAt(j)) {
						count++;
					}
				}
			}
			
			
			System.out.println(ch + " count :  "+ count);
		}
	}

}
