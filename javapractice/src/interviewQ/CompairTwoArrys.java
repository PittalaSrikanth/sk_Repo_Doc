package interviewQ;

import java.util.Arrays;

public class CompairTwoArrys {

	public static void main(String[] args) {
		char[] array1 = new char[] {'a', 'b', 'c', 'd', 'e'};   
		char[] array2 = new char[] {'a', 'b', 'c', 'd', 'e'};  
		//comparing two arrays using equals() method  
		if (Arrays.equals(array1, array2))   
		System.out.println("Arrays are equal.");   
		else  
		System.out.println("Arrays are not equal.");   
		
		int[] array3 = new int[] {'1', '2', '3', '4', '5'};   
		int[] array4 = new int[] {'1', '2', '3', '4', '5'};  
		//comparing two arrays using equals() method  
		if (Arrays.equals(array3, array4))   
		System.out.println("Arrays are equal.");   
		else  
		System.out.println("Arrays are not equal.");   

	}

}
