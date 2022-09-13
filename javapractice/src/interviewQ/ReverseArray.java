package interviewQ;

public class ReverseArray {

	public static void main(String[] args) {
		int[] arr = {78, 34, 1, 3, 90, 34,  6, 55, 20};
		int i = 0;
        int j = arr.length - 1;
		while(i < j) {
            //swapping ith and jth index elements
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

		for(int it=0;it<arr.length;it++) {
            System.out.print(arr[it] + " ");
        }
	}

}
