package interviewQ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateCharInString {

	public static void main(String[] args) 
	{
		List<Character>  l = new ArrayList<Character>();
		String str = "afsfdfjaskfdslfafjdafjdaksfkfksdffjdsafffserjfewjrreqwofna";
		char[] ch = str.toCharArray();
		for(char c : ch) {
			l.add(c);
		}
		Set<Character> s = new LinkedHashSet<Character>(l);
		System.out.println(s);
		
		Set<Character> s1 = new HashSet<Character>(l);
		System.out.println(s1);

	}

}
