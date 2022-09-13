package interviewQ;

public class StringContainsVowels {

	public static void main(String[] args) 
	{
		String s = "asdfsadfjvomokw ecmcpomwpcmewodfncewscsc sdvca";
		Boolean result = s.toLowerCase().matches(".*[aeiou].*");
		System.out.println(result);
		
		//or
		
		char[] chr = s.toCharArray();
		for(char ch : chr)
		 if(ch == 'a' || ch =='e' || ch =='i' || ch =='o' || ch =='u')
		 {
			 	System.out.println("Contains vowel");	
				break;
		 }
	}

}
