package interviewQ;

public class PrimeNumberUptoGivenNo {

	public static void main(String[] args) 
	{
		int n = 200;
		
		
		for(int i = 2; i<=n; i++)
		{
			boolean flag = true;
			for(int j = 2; j<=i/2; j++)
			{
				if(i%j==0)
				{
					flag = false;
					break;
				}
				
			}
			if(flag)
			{
				System.out.println(i);
			}
		

		}

}
}
