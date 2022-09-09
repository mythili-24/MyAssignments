package week1.day2;

import java.util.Arrays;

public class MissingElementsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,7,6,8};
		Arrays.sort(arr);
		int temp =arr[0];
		for (int i = 0; i < arr.length; i++) {
			
			 if(temp != arr[i]) {
				 
				 System.out.println(temp);
				 break;
			 }
			 else {
				 temp=temp+1;
				 
			 }
			 }
		}
		

	}


