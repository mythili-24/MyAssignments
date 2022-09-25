package week3.day1;

public class ReverseEvenWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * string input="TestLeaf located in chennai" convert string into word check if
		 * the word is odd or even index(i%2!=0) if it is even index reverse the string
		 * print the output
		 */
		String name = "TestLeaf located in chennai";
		char[] charArray= name.toCharArray();
		String[] split = name.split(" ");
		for (int i = 0; i <= split.length; i++) {
			if (i % 2 != 0) {
				System.out.println(charArray);
				for(int j=split.length-1;j>=0;j--) {
					System.out.println(charArray[j]);
				}

			}
			else {
				System.out.println("odd");
			}
		}
	}
}
