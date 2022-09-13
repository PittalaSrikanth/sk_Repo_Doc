package interviewQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDuplicateCharInStringWithHashmap {

	
	public static void main(String[] args) 
	{
		String str = "afjdafldfldasfldaflfjjfjqwirjirjiowergnvnoc2emq";
		
        HashMap<Character, Integer> charmap = new HashMap<Character, Integer>();
 
        char[] strarr = str.toCharArray();
 
        for (char c : strarr) {
            if (charmap.containsKey(c)) {
                charmap.put(c, charmap.get(c) + 1);
            }
            else {
                charmap.put(c, 1);
            }
        }
        for (Map.Entry entry : charmap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

	}

}
