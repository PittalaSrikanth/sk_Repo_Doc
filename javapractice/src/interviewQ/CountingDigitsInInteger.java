package interviewQ;

public class CountingDigitsInInteger {

	public static void main(String[] args) {
		int num = 15234;
		int count = 0;
	      while(num!=0){
	         num = num/10;
	         count++;
	      }
	      System.out.println("Number of digits in the entered integer are :: "+count);
	}

}
