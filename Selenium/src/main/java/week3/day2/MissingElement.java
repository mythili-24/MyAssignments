package week3.day2;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MissingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,7,6,8};

		// Sort the array	
		

		// loop through the array (start i from arr[0] till the length of the array)

			// check if the iterator variable is not equal to the array values respectively
			
				// print the number
				
				// once printed break the iteration
		List<Integer> lst=Arrays.asList(1,2,3,4,7,6,8);
		Collections.sort(lst);
		
		int startValue = lst.get(0);
		
		for (int i = 0; i <=arr.length; i++) {
			
			if(lst.get(i) == startValue) {
				startValue = startValue+1;
			}else {
				System.out.println(startValue);
				break;
			}
			
		}
	}

}
