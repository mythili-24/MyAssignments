package week3.day1;

public class ReverseString {

	public static void main(String[] args) {
		
		//Classroom Assignment 1 A: Reverse the String-Name
		//Goal: To understand the String, loop
		//a) Create a class by name: ReverseString (with main method) in same package
		//b) Write a logic to reverse a String
		//c) Run and Confirm the reversed String is printed in console
		//Hint: Convert the String to characters, get the characters in reverse order and 
		//print every character without white space.
		/*
		 * convert string into array
		 * get the char in reverse order
		 * print every char without white space
		 * 
		 * 
		 * 
		 * 
		 */
		String name="TestLeaf";
		char[]charArray = name.toCharArray();
		for(int i=charArray.length-1;i>=0;i--) {
			System.out.print(charArray[i]);//remove ln to print in single line
			
		}
	}

}
