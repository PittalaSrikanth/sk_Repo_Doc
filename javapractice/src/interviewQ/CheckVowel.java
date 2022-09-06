package interviewQ;

public class CheckVowel {

	public static void main(String[] args) 
	{
		String s = "asdfsadfjvomokw ecmcpomwpcmewodfncewscsc sdvca";
		Boolean result = s.toLowerCase().matches(".*[aeiou].*");
		System.out.println(result);
	}

}
