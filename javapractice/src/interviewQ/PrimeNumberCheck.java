package interviewQ;

public class PrimeNumberCheck {

	public static void main(String[] args) 
	{
		int n = 3;
		
		
		if (n == 0 || n == 1) {
			System.out.println("Not a prime");
		}
		if (n == 2) {
			System.out.println("prime");
		}
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				System.out.println("Not a prime");
				break;
			}
			else {
				System.out.println("prime");
				break;

			}
		}
		System.out.println("prime");


	}

}
