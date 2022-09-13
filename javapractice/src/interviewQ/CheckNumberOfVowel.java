package interviewQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckNumberOfVowel {

	public static void main(String[] args) 
	{
		
		char[] vowels = {'a','e','i','o','u'};
		System.out.println("Printing vowels: "+Arrays.toString(vowels));  
		
		List<Character> list = new  ArrayList<Character>();
		List<Character> v = new ArrayList<Character>();
		
		for(char s : vowels)
		{
			list.add(s);
			
		}
		
		System.out.println(list);
		
		String s = "asdfsadfjvomokw eicmcpomwpacemieowuodfncewscsc sdvca";
		char[] eachchar = s.toCharArray();
		for(char each : eachchar) 
		{
			int count = 0;
			if(!v.contains(each))
			{
				if(list.contains(each))
				{
					v.add(each);
					for(int i = 0;i<eachchar.length;i++)
					{
						if(each == eachchar[i])
						{
							count++;
						}
					}
					System.out.println(each +" count : "+ count);
				}
			}
			
			
			
		}
		
	}

}
