package Illuminated;

public class ObjectComparision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 1;
		int b = 1;
		String s = "hola";
		String t = "hola";
		
		System.out.println("el objeto a es igual a b? " + (a==b));
		System.out.println("El objeto s es igual a t? " + (s==t));
		
		a=b;
		s=t;
		System.out.println("el objeto a es igual a b? " + (a==b));
		System.out.println("El objeto s es igual a t? " + (s==t));
		
		String u;
		u = "hola";
		
		SimpleDate independenceDay1;
		independenceDay1 = new SimpleDate(7,4,1776);
		
		SimpleDate independenceDay2;
		independenceDay2 = new SimpleDate(7,4,1776);
		System.out.println("El objeto s es igual a t? " + (independenceDay1==independenceDay2));
		
		independenceDay2 = independenceDay1;
		System.out.println("El objeto s es igual a t? " + (independenceDay1==independenceDay2));
		
		System.out.println("Día "+ independenceDay1.getDay());
	}

}
