package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class LearnList {
	public static void main(String[] args) {
		String[] str = {"Adam","Ben","Zara","Adam","Charlie","James","Ben"};
		List <String> lst = new ArrayList<String>();
		lst.add("Adam");
		lst.add("Ben");
		
		System.out.println(lst);
		//System.out.println(lst.get(3));
		//System.out.println(lst.get(6));
		for (int i = 0; i < str.length; i++) {
			lst.add(str[i]);
		}
		System.out.println(lst);
	}

}
