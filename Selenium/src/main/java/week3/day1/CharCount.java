package week3.day1;

public class CharCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * string input
		 * convert charArray
		 * loop through every char
		 * compare and get the count
		 * 
		 */
		
		String input="TestLeaf";
		char ch='T';
		int count=0;
		char[] charArray = input.toCharArray();
	
		for (int i = 0; i < charArray.length; i++) {
			if(charArray[i]==ch) {
				count++;
			}
			}
	}
		

}

