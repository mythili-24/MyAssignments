package week1.day2;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int original = 34343;
		int palindrome = 0;
	    int modRemainder;
	
	for (int xerox = original; xerox!=0; xerox = xerox /10) {
		
		modRemainder = xerox%10;
        palindrome = palindrome * 10 + modRemainder;
	}

	if(original == palindrome) {
		System.out.println("This is a palindrome");
	} else {
		System.out.println("This is not a palindrome");
	}

}
}
