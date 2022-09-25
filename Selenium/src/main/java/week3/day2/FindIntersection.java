package week3.day2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Pseudo Code
		 * 
		 * a) Declare An array for {3,2,11,4,6,7}; b) Declare another array for
		 * {1,2,8,4,9,7}; c) Declare for loop iterator from 0 to array length d) Declare
		 * a nested for another array from 0 to array length e) Compare Both the arrays
		 * using a condition statement
		 * 
		 * f) Print the first array (shoud match item in both arrays)
		 */

		// int[] num1 = {3,2,11,4,6,7};
		// int[] num2 = {1,2,8,4,9,7};
		List<Integer> num1 = Arrays.asList(3, 2, 11, 4, 6, 7);
		List<Integer> num2 = Arrays.asList(1, 2, 8, 4, 9, 7);

		for (int i = 0; i < num1.size(); i++) {

			for (int j = 0; j < num2.size(); j++) {

				if (num1.get(i) == num2.get(j)) {
					System.out.println(num1.get(i));
				}
			}
		}
	}

}
