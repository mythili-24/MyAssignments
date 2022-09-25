package week3.day1;

public class Polymorphism {
	public void getStudentInfo(int id) {
		System.out.println("id" + " "+ id);
	}
	public void getStudentInfo(int id,String name) {
		System.out.println("id is" + " "+ id);
		System.out.println("name "+" "+ name);
	}
	public void getStudentInfo(String email, long phonenum) {
		System.out.println("email"+ " "+ email);
		System.out.println("phonenum " + " "+phonenum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Polymorphism obj = new Polymorphism();
         obj.getStudentInfo(1123);
         obj.getStudentInfo(1123,"test");
         obj.getStudentInfo("mkkjh_gmail.com", 457787690);
	}
	

}
