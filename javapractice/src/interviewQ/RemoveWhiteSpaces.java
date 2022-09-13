package interviewQ;

public class RemoveWhiteSpaces {

	public static void main(String[] args) {
		
		String str = "fjalskfs asdfasdlkfasdkjfklds fsa fdskfdaskfjklasdfjkasdlfj";
		
		
		StringBuilder output = new StringBuilder();
		
		char[] charArray = str.toCharArray();
		
		for(char c : charArray) {
			if (!Character.isWhitespace(c))
				output.append(c);
		}
		
		System.out.println( output.toString());

	}

}
