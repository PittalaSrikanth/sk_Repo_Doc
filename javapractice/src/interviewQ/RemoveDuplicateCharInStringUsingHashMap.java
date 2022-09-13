package interviewQ;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateCharInStringUsingHashMap {

	public static void main(String[] args) 
	{
		String string = "hellow world";
		char str[] = string.toCharArray();
		Map<Character,Integer> exists = new HashMap<>();
		 
		  String st = "";
		  for(int i = 0; i < str.length; i++){
		    if(!exists.containsKey(str[i]))
		    {
		      st += str[i];
		      exists.put(str[i], 1);
		    }
		  }
		 System.out.println(st.toCharArray());
		}

	}


