package interviewQ;

public class countRepeatingDigitsInNumber {

	public static void main(String[] args) {
		
		int N = 14452506;
		int res = 0;
		  
	  
	    int cnt[] = new int[10];
	  
	    while (N > 0)
	    {
	  
	        int rem = N % 10;
	  
	        cnt[rem]++;
	  
	        N = N / 10;
	    }
	  
	    for (int i = 0; i < 10; i++)
	    {
	  
	        if (cnt[i] > 1)
	        {
	            res++;
	            System.out.println(i + " digit count :   " + cnt[i] );
	        }
	        
	    }
	  
	   System.out.println("count of repeating digit : " +res);

	}

}
