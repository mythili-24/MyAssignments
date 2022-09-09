package week1.day2;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=11;
		int rem=1;
	
		for (int i = 2; i < n; i++) {
			if(n%i == 0) {
				
				rem = 0;
			} 
			
			
			
		}
		
		if(rem ==0) {
			System.out.println("This is not a prime number");
		} else {
			System.out.println("This is a primenumber");
		}
		
		
	}
	
}

	


