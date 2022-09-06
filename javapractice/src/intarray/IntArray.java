package intarray;

import java.util.HashSet;

public class IntArray {

	public static void main(String[] args) 
	{
		int count =0;
		int[] arr = {4,5,6,4,5,6,4,5,5,5,5,5,6,4};
		HashSet set1=new HashSet();
		for(int i=0;i<arr.length;i++) 
		{		  
	         set1.add(arr[i]);  	         
		}
		Object[] a = set1.toArray();
		
		for(Object i : a)
		{
			int x = (int) i;
			for(int j =0;j<arr.length;j++ ) 
			{
				if( x==arr[j]) 
				{
					count++;
				}
			}
			System.out.println(x +" : "+count);
			count = 0;
		}
		
		

	}

}
