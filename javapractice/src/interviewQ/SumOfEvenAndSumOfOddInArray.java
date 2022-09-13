package interviewQ;

public class SumOfEvenAndSumOfOddInArray {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };
		int evenSum = 0;
		int oddSum = 0;
		
		for(int a : array)
		{
			if(a%2==0)
			{
				evenSum+=a;
			}
			else
			{
				oddSum+=a;
			}
		}
		
		System.out.println(evenSum);
		System.out.println(oddSum);
		
	}

}
