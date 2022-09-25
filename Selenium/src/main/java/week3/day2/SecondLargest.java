package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecondLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Here is the input
				//int[] data = {3,2,11,4,6,7};

				
				/*
				 Pseudo Code:
				 1) Arrange the array in ascending order
				 2) Pick the 2nd element from the last and print it
				 */
				List<Integer> lst = Arrays.asList(3,2,11,4,6,7);
				Collections.sort(lst);
				//for (Integer num:lst) {
					System.out.println(lst.get(lst.size()-2));
					//break;
				//}
				
	}

}
