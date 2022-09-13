package interviewQ;

public class StringImmutableProof {

	public static void main(String[] args) {
		String s1 = "InterviewBit";
		String s2 = s1;

		System.out.println(s1 == s2); //they are equal
		System.out.println(s1 +" : "+s2); //they are equal

		s1 += "Scaler";

		System.out.println(s1 == s2); //not equal
		System.out.println(s1 +" : "+s2); //they are equal

	}

}
