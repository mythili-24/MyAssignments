package week7.day2;

public class LearnConstructor {
	{
		System.out.println("i am a simple block");
	}
	static {
		System.out.println("i am a static block");
	}
	public LearnConstructor() {
		System.out.println(" i am a constructor block");
	}
	public LearnConstructor(String name)
	{
		System.out.println("i am a parameterised constructor");
	}

	public static void main(String[] args) {
		LearnConstructor obj=new LearnConstructor("abc");
		

	}

}
