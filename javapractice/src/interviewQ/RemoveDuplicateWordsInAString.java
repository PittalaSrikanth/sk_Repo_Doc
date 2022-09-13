package interviewQ;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateWordsInAString 
{

	public static void main(String[] args) 
	{
		String str = "Manage your profile across all our applications bank image Set up and manage your direct deposit computer image Access pay stubs tax documents digital onboards and timecards";
		String[] words = str.toLowerCase().split(" ");
		
		List<String> wordslist = new ArrayList<String>();
		
		for(String word : words)
		{
			wordslist.add(word);
		}
		
		Set<String> s = new LinkedHashSet<String>(wordslist);
		System.out.println(s);
		
	}

}
