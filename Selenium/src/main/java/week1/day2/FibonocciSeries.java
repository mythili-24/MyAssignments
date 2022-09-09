package week1.day2;

public class FibonocciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int range=8,firstnum=0,secondnum=1, sum;
        System.out.println(firstnum);
        System.out.println(secondnum);
        for (int i = 0; i <range - 2; i++) {
        	sum=firstnum+secondnum;
        	System.out.println(sum);
        	firstnum = secondnum;
        	secondnum = sum;
			
		}
	}

}
