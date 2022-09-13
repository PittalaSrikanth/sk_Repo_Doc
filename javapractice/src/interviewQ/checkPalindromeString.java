package interviewQ;

public class checkPalindromeString {

	public static void main(String[] args) {
		String input = "level";
//		String input = "12321";
		boolean flag = true;
		int length = input.length();
		for(int i=0; i < length/2; i++) {
			if(input.charAt(i) != input.charAt(length-i-1)) {
				flag = false;
				System.out.println("Not Palindrom");
				break;
			}
		}
		if(flag)
			System.out.println("Palindrom");

	}

}
